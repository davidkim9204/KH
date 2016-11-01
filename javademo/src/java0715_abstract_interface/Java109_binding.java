package java0715_abstract_interface;

class BindSam{
	
	void process(){
		System.out.println("sam porcess");
	}
}

class BindExam extends BindSam{
	
	@Override
	void process(){
		System.out.println("exam process");
	}
	void display(){
		System.out.println("child method");
	}
	
	
}

public class Java109_binding {

	public static void main(String[] args) {
		BindSam sam=new BindExam(); //동적 바인딩
		sam.process();
		//sam.display(); //조상클래스에 없으니깐 오류가 뜬다구우우우우우우우우우우우우우우
		/*
		 * 동적 바인딩일때는 무조건 조상클래스에서 display()매소드를 찾은후
		 * 자손클래스의 오버라이딩 여부를 묻기 때문에
		 * 현재BindSam클래스에는 display()메소드가 정의되어 있지 않으므로 오류가 발생한다.
		 */
		
	//sam.display();	
		
		BindExam exam=(BindExam)sam;
		exam.display();
		
		
	}//end main()
	
}//end class
