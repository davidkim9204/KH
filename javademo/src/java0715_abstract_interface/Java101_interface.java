package java0715_abstract_interface;

interface TestB{
	void prn();
	
}

interface TestC{
	void prn();
	
}

class TestD{
	void prn(){
		System.out.println("TestD");
		
	}
}

class TestE extends TestD{
	
	@Override  //기재가 필수는 아님.
	void prn(){
		System.out.println("testE");
	}
}

class TestA implements TestB, TestC{
	
	@Override
	public void prn(){
		
	}
	
}



public class Java101_interface {

	public static void main(String[] args) {
		TestE te=new TestsE();
		te.prn();
		
		
		
	}//end main()
	
	
}//end class
