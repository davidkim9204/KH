package controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.PersonDao;
import dto.PersonDTO;

/*
  
 view 페이지가 필요 없이 그냥 보내지는지 확인하는 용도. 

*/ 

@Controller
public class PersonController {
	
	private PersonDao dao;
	
	public PersonController(){
		
	}
	
	public void setDao(PersonDao dao) {
		this.dao = dao;
	}
	
	//http://127.0.0.1:8090/rest/person/list
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public @ResponseBody List<PersonDTO> listMethod(){
		return dao.list();
	}//end listMethod()
	
	//http://127.0.0.1:8090/rest/person/list/2
	//매핑주소{ss}하고 pathvariable(ss)하고 괄호 안에 값들이 같아야함.
	@RequestMapping(value="/list/{ss}", method = RequestMethod.GET)
	public @ResponseBody PersonDTO listMethod(@PathVariable("ss")int num){
		return dao.list(num);
	}//end listMethod
	
	//http://127.0.0.1:8090/rest/person/list/2/이영희
/*
	@RequestMapping(value="/list/{num}/{name}", method=RequestMethod.GET)
	public @ResponseBody PersonDTO listMethod(@PathVariable("num") int num, @PathVariable("name") String name){
		PersonDTO dto=new PersonDTO();
		dto.setName(name);
		dto.setNum(num);
		return dao.list(dto);
	}//end listMethod()
*/	
	
	@RequestMapping(value="/list/{num}/{name}", method=RequestMethod.GET)
	public @ResponseBody PersonDTO listMethod(PersonDTO dto){
		return dao.list(dto);
	}//end listMethod()
	
/*
 * $.ajax({
 * 	dataType:"text",
 * 	type:'POST',
 * 	data: JSON.stringify({"id":"user","pass":"4253","name":"야옹이"}),
 * 	url:'/'
 * }) 
 * 
 * 
 * 
 * 
 */	
	
	
	
	//http://127.0.0.1:8090/rest/person/
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ResponseEntity<String> insertMethod(@RequestBody PersonDTO dto){
		ResponseEntity<String> entity = null;
		try{
			dao.register(dto);
			entity=new ResponseEntity<String>("SUCCESS",HttpStatus.OK);
		}catch(Exception e){
			e.printStackTrace();
			entity= new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		return entity;
	}//end insertMethod()
	
	
}//end class
