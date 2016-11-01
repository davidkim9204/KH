package java0803_jdbc;

//Data Transfer Object(DTO): 데이터 관리 객체
//Variable Object (VO)
public class DepartmentDTO {
	private int department_id;
	private String department_name;
	private int manager_id;
	private int location_id;
	
	//데이터 타입을 선언할때 오라클에 있는 테이블을 보고 해야한다.
	//정수면 int로 cha
	
	
	//데이터 베이스가 크면클수록 세분화해서 나눠야 한다.
	//
	public DepartmentDTO(){
		
	}

	public int getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}

	public String getDepartment_name() {
		return department_name;
	}

	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}

	public int getManager_id() {
		return manager_id;
	}

	public void setManager_id(int manager_id) {
		this.manager_id = manager_id;
	}

	public int getLocation_id() {
		return location_id;
	}

	public void setLocation_id(int location_id) {
		this.location_id = location_id;
	}

	
	
	
}
