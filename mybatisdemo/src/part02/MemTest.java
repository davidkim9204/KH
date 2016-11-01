package part02;

import java.util.ArrayList;
import java.util.List;

import part02.dao.MemDao;
import part02.dto.MemDTO;

public class MemTest {

	public static void main(String[] args) {
		MemDao dao = new MemDao();
		
		//dao.insertMethod(new MemDTO("ㅁ",30));
		
		//num 컬럼의 값이 3 일 때 loc컬럼의 값을 '제주'로 수정
		/*HashMap<String,Object> map = new HashMap<String, Object>();
		map.put("loc", "제주");
		map.put("num", 7);
		dao.updateMethod(map);*/
		
		//dao.deleteMethod(11);
		
		/*List<MemDTO> alist=new ArrayList<MemDTO>();
		alist.add(new MemDTO(dao.keyMethod(),"java",20,"toronto"));
		alist.add(new MemDTO(dao.keyMethod(),"jsp",15,"summary"));
		dao.multiInsertMethod(alist);*/
		
		/*List<Integer> alist=new ArrayList<Integer>();
		alist.add(11);
		alist.add(1);
		System.out.println("total 삭제:"+dao.multiDeleteMethod(alist));*/
		
		/*//2개의 인덱스를 갖는 배열을 생성. 0번째 인덱스에는 num=3을 1번째 인덱스에 num=2를 넣고, sysout에서 다중 삭제 메소드 실행해서 0,1번째 인덱스 값을 삭제.
		Integer[] array=new Integer[2];
		array[0]=3;
		array[1]=2;
		System.out.println("total 삭제"+dao.multiDeleteMethod(array));*/
		
		/*MemDTO mt=new MemDTO();
		mt.setAge(25);
		
		//다이나믹 if 쓸 때 밑에꺼 쓰고 List<MemDTO> list = dao.allMethod() 주석처리
		List<MemDTO> list=dao.searchMethod(mt);
		*/
		
		MemDTO mt=new MemDTO();
		mt.setAge(12);
		
		mt.setNum(9);
		//dao.multiUptMethod(mt);
		
		MemDTO mm=new MemDTO("똘똘이",25);
		MemDTO mk=new MemDTO("뮤",30,"나");
		dao.locInsMethod(mk);
		
		List<MemDTO> list =dao.allMethod();
		for(MemDTO dto : list)
			System.out.printf("%d %s %d %s \n", dto.getNum(),dto.getName(),dto.getAge(),dto.getLoc());

	}//end main()

}//end class
