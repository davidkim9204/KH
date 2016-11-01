package part05;

public class EmployeeDTO {
	private int employee_id;
	private String first_name;
	private DepartmentDTO dept;
	private LocationDTO loc;
	

	public EmployeeDTO(){
		
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public DepartmentDTO getDept() {
		return dept;
	}

	public void setDept(DepartmentDTO dept) {
		this.dept = dept;
	}
	
	public LocationDTO getLoc() {
		return loc;
	}

	public void setLoc(LocationDTO loc) {
		this.loc = loc;
	}
	
	
	
}//end class
