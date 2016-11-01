package java0712_static_access.ans;

// -(private)    + (public)    #(protected)     X : default
/* 
 * -name:String                    
 * -dept:String 
 * -pay:int
 * -score:double
 * 
 * +setName(name:String):void
 * +setDept(dept:String):void
 * +setPay(pay:int):void
 * +setScore(score:double):void
 * +getName():String
 * +getDept():String
 * +getPay():int
 * +getScore():double
 * +setEmployee(name:String, dept:String, pay:int, score:double)
 * +toString():String 
 */






public class Employee {
	
	private String name;
	private String dept;
	private int pay;
	private double score;
	
	public void setName(String name){
		this.name=name;
	}
	
	public void setDept(String dept){
		this.dept=dept;
	}
	
	public void setPay(int pay){
		this.pay=pay;
	}
	
	public void setScore(double score){
		this.score=score;
		
	}
	
	public  String getName(){
		return name;
	}
	
	public int getPay(){
		return pay;
	}
	
	public double getScore(){
		return score;
	}
	
	public void setEmployee(String name,String dept, int pay, double score){
		this.name=name;
		this.dept=dept;
		this.pay=pay;
		this.score=score;
	}
	public String  toString(){
		return "이름은";
			
		System.out.println("이름은 %s이고 %s에 근무하며 급여는 %d원 입사성적은 %f입니다",name,dept,pay,score);
		
		
		return losal + " " + hisal + " " + grade;
	}
		
	}
	
	
	
	
	
	

}
















