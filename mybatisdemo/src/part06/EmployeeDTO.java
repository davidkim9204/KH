package part06;

import java.util.List;

public class EmployeeDTO {
	private int employee_id;
	private String first_name;
	private int salary;
	private List<DepartmentDTO> dept;
	private List<LocationDTO> loc;
	

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

	public List<DepartmentDTO> getDept() {
		return dept;
	}

	public void setDept(List<DepartmentDTO> dept) {
		this.dept = dept;
	}

	public List<LocationDTO> getLoc() {
		return loc;
	}

	public void setLoc(List<LocationDTO> loc) {
		this.loc = loc;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	
	
}//end class
