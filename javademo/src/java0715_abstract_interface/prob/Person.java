package java0715_abstract_interface.prob;

abstract public class Person {
	String name; //이름
	String jumin; //주민번호	
	

	public Person(String name, String jumin) {
		this.name = name;
		this.jumin = jumin;
	}	
	
	
	//주민번호 크기 반환
	public int genCount(){
		return jumin.length();
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJumin() {
		return jumin;
	}

	public void setJumin(String jumin) {
		this.jumin = jumin;
	}
	
	// 주민번호를 이용해서 성별을 구한후 반환
	abstract public char gender();
	
	// 주민번호를 이용한 년도4자리를 구한후 반환
	abstract public int getYear() ;
	
	
	// 주민번호를 이용한 월을 구한후 반환
	abstract public int getMonth();
	
	// 주민번호를 이용한 일을 구한후 반환
	abstract public int getDATE();

}//end class

//+추가공부

//String sn = new String ("java");
//
//char data=sn.charAt(2); /v
//System.out.println(data)
//
//String ko=sn.substring(0, 3); //jav
//String mm=sn.suhbstring(1,2); //a
//
//
//String ss=new String("2124");
//int num=integer.parselnt(ss.substring(1, 3));






