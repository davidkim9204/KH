package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import dto.BoardDTO;
import dto.PageDTO;
import service.BoardService;

@Controller

public class BoardController {
	private BoardService service;
	private int currentPage;
	private PageDTO pdto;
	
	public BoardController() {
	}
	
	//BoardService를 사용하기 위한 setter 정의  -> bean환경설정 property값을 받기 위해
	public void setService(BoardService service) {
		this.service = service;
	}
	
	@RequestMapping("/list.sb")
	//PageDTO pv쓰는 이유 : 원래는 int currentPage라 했는데 DTO 안에 객체로 선언이 되어있음 => 객체로 사용.
	//객체로 받으면 첫 접속일떄 null값이어도 오류가 없다. 내부에서 0으로 처리
	//객체로 받지 않으면  null 오류가 떠서 if를 사용하여 page초기값을 지정해야 한다.
	public ModelAndView listMethod(PageDTO pv){
		ModelAndView mav = new ModelAndView();
		
		//게시판 테이블의 총 레코드수 (service.countProcess())
		int totalRecord = service.countProcess();
		if(totalRecord >=1 ){
			if(pv.getCurrentPage()==0)
				currentPage=1;
			else
				currentPage=pv.getCurrentPage();
			
			//페이지번호 값 구하기
			pdto = new PageDTO(currentPage,totalRecord);
			
			//list.jsp에서 페이지번호를 사용하기위해 pdto를 pv라는 이름으로 넘겨준다.	
			mav.addObject("pv",pdto);
			mav.addObject("aList",service.listProcess(pdto));	
		}
		mav.setViewName("board/list");
		return mav;
	}//end listMethod()

	
	//제목을 눌렀을때 해당 글 번호에 해당하는 목록이 보여주는 곳.
	@RequestMapping("/view.sb")
	public ModelAndView viewMethod(int currentPage, int num){
		ModelAndView mav = new ModelAndView();
		BoardDTO dto = service.contentProcess(num);
		
		/*
		if(dto.getUpload()!=null){
		String up = dto.getUpload();
		int index = up.indexOf("_");
		dto.setUpload(up.substring(index+1));
		dto.setUpload(dto.getUpload().substring(dto.getUpload().indexOf("_")+1));		
		}
		
		try{
			dto.setUpload(dto.getUpload().substring(dto.getUpload().indexOf("_")+1));	
		}catch (Exception e) {
		
		}
		*/	
		mav.addObject("dto",dto);
		//view.jsp에서 currentPage값을 넘겨준다. 답변 삭제 수정 리스트로 갈때 해당 번호가 필요하기 때문.
		mav.addObject("currentPage",currentPage);
		mav.setViewName("board/view");
		return mav;
	}//end viewMethod()
	
	@RequestMapping(value = "/write.sb", method = RequestMethod.GET)
	public ModelAndView writeMethod(PageDTO pv,BoardDTO dto){ //currentpage와 num,ref,re_step,re_level 값 받아온다.
		ModelAndView mav = new ModelAndView();
		//if안에 ref가 0이 아니면 답변안에 글쓰기를 눌렀을 때 정보를 담아야 하고
		if(dto.getRef()!=0){
			mav.addObject("currentPage", pv.getCurrentPage());
			mav.addObject("dto",dto);
		}
		//그냥 list.jsp에서 글쓰기를 누르면 ref가 없으니깐 그냥 사용가능.
		mav.setViewName("board/write");
		return mav;
	}
	
	@RequestMapping(value = "/write.sb", method = RequestMethod.POST)
	public String writeProMethod(BoardDTO dto, PageDTO pv, HttpServletRequest req){ //HttpServletRequest req는 파일 첨부 때문에 사용.
												
							//업로드파일 객체값이 저장되어 있다.
		MultipartFile file = dto.getFilename();
		if(!file.isEmpty()){
			String fileName=file.getOriginalFilename();
			
			//중복 파일명을 처리하기 위해 난수 발생 
			UUID random=UUID.randomUUID();
			String root=req.getSession().getServletContext().getRealPath("/");
			//root+"temp/"
			
			/*C:\study\workspace_spring\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\spring_07_board\temp */
			String saveDirectory = root+"temp"+File.separator;  //File.separator 는 "/" 이다.
			
			//디렉토리 생성 용도
			File fe = new File(saveDirectory);
			if(!fe.exists())
				fe.mkdir();
			
			
			File ff = new File(saveDirectory,random+"_"+fileName);
			try {
				FileCopyUtils.copy(file.getInputStream(), new FileOutputStream(ff));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			dto.setUpload(random+"_"+fileName);
		}
		
		
		//클라이언트 ip주소 넣기
		dto.setIp(req.getRemoteAddr());

		//답변글이면
		if(dto.getRef()!=0){
		/*	HashMap<String, Integer> map = new HashMap<String, Integer>();
			map.put(dto.setRe_step(dto.getRe_step()+1));
			map.put(dto.setRe_level(dto.getRe_level()+1));  serviceimp에서 처리안할때는 여기서 처리도 가능*/
			service.reStepProcess(dto);
		}else{//제목글이면
			service.insertProcess(dto);		
		}
		
		return "redirect:/list.sb";
	}//end writeProMethod()
	
	
	@RequestMapping("/contentdownload.sb")
	public ModelAndView downMethod(int num){
		ModelAndView mav = new ModelAndView();
		mav.addObject("num",num);
		mav.setViewName("download");
		return mav;
		//하나의 뷰에 하나의 값은 생성자를 통해서 가능
							//       뷰		  모델명 모델값
		//return new ModelAndView("download","num",num);		
	}//end downMethod()
	
	@RequestMapping(value="/update.sb", method = RequestMethod.GET)
	public ModelAndView updateMethod(int num, int currentPage){
		ModelAndView mav = new ModelAndView();
		mav.addObject("dto",service.updateSelectProcess(num));
		mav.addObject("currentPage",currentPage);
		mav.setViewName("board/update");
		return mav;
	}//end updateMethod()
	
	@RequestMapping(value="/update.sb", method = RequestMethod.POST)
	public ModelAndView updateProc(BoardDTO dto, int currentPage, HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		service.updateProcess(dto, request);
		mav.addObject("currentPage", currentPage);
		mav.setViewName("redirect:list.sb");
		return mav;
	}//end updateProc()
	
	@RequestMapping("/delete.sb")
	public ModelAndView deleteMethod(int num, int currentPage, HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		//레코드를 삭제하기위한 num,  첨부파일 삭제에 필요한 request 
		service.deleteProcess(num, request);
		
		//글을 삭제 했을 때 만약에 16페이지의 마지막글을 삭제하면 17페이지의 첫번째 글이 16페이지의 마지막 글이 되게 만들어 주기 위해 사용.
		PageDTO pv = new PageDTO(service.countProcess());
		if(pv.getTotalPage() < currentPage)
			mav.addObject("currentPage", pv.getTotalPage());
		else
			mav.addObject("currentPage", currentPage);
		
			mav.setViewName("redirect:/list.sb");
			return mav;
	}//end deleteMethod()
	
}//end class
