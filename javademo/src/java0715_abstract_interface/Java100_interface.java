package java0715_abstract_interface;

interface SampleA{
	void prn();
}

interface SampleB extends SampleA{
	void call();
}

class Animal {
	void play(){
		System.out.println("PLAY");
	}
	
}//end Animal


//extends~~~ implements   ~~~순서로 상속을 한다. extends가 먼저 상서ㅗㄱ
class Life extends Animal implements SampleB{
	
	@Override
	public void prn() {
		System.out.println("PRN");
		
	}
	
	@Override
	public void call() {
		System.out.println("CALL");
		
	}
	
	
	
}//end Life//////



public class Java100_interface {

	public static void main(String[] args) {
		
		Life ee=new Life();
		ee.call();
		ee.prn();
		
		
		
	}
	
}
