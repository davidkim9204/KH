package java0804_jdbc;

import java.util.ArrayList;


import java0804_jdbc.dao.JoinDAO;
import java0804_jdbc.dto.EmployeesDTO;

public class Java200_jdbc {

	public static void main(String[] args) {
		
		JoinDAO dao=JoinDAO.getInstacne();
		ArrayList<EmployeesDTO>aList = dao.listMethod();
		for (int i=0; i<aList.size();i++){
			EmployeesDTO dto=aList.get(i);
//		for (EmployeesDTO dto : aList){	
			
			System.out.printf("%d %s %d  %d %s %d %d\n",
					dto.getEmployee_id(), dto.getFirst_name(), dto.getSalary(), 
					dto.getMdto().getDepartment_id(),
					dto.getMdto().getDepartment_name(),
					dto.getLdto().getLocation_id(),
					dto.getLdto().getCity());
	
		}
//		ArrayList<DepartmentDTO>aList = dao.listMethod();
//		for(int i=0;i<aList.size(); i++){
//			DepartmentDTO dto = aList.get(i);
//			//int department_id=dto.getDepartment_id(); //이렇게 일일이 하나씩 하지말고
//			System.out.printf("%d %s %d %d\n",
//					dto.getDepartment_id(),
//					dto.getDepartment_name(), 
//					dto.getManager_id(),
//					dto.getLocation_id());
		
		
//		MemDAO dao = MemDAO.getInstance();
//		dao.insertMethod(new MemDTO("이영희",30,"경기"));
//		
////		HashMap<String, Object>map=new HashMap<String, Object>();
////		map.put("num", 1); 
////		map.put("name", "공작");
////		dao.updateMethod(map);
//		
////		dao.deleteMethod(1); //
//		
//		ArrayList<MemDTO> mData=new ArrayList<MemDTO>();
//		mData.add(new MemDTO("first",8,"세종"));
//		mData.add(new MemDTO("first",5,"세종"));
//		mData.add(new MemDTO("first",3,"세종"));		
//		int cnt=dao.insertMethod(mData);
//		System.out.println("삽입갯수"+cnt);
//		
//		
//		
//		
//	//delete이후에 이것으로 수정. 2개다 할 수 있다.	
//		ArrayList<MemDTO>aList = dao.listMethod("영");
//		
////		ArrayList<MemDTO>aList = dao.listMethod();
//		for (int i=0; i<aList.size();i++){
//			MemDTO dto=aList.get(i);
//			System.out.printf("%d %s %d %s\n", dto.getNum(),dto.getName(),dto.getAge(),dto.getLoc());
		
		
	}//end main()
	
}//end class
