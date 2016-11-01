package java0715_abstract_interface;

//독립된 객체 끼리는 바인딩할 수 없다.?!?!?!

class BindTest{
	String stn;
	public BindTest(String stn){
		this.stn=stn;
	}
	
	public String toString(){
		return stn;
	}
	
}//end BindTest///////////////////


class A{

}

class B{
		
}






public class Java105_binding {

	public static void main(String[] args) {
		/*A aa=new A();
		B bb=new B();
		aa=bb;*/
		
		//바인딩(binding): 두 개의 관계를 연결한 것이다.
		
		//정적바인딩: 메모리에 생성된 영역과 같은 타입으로 메모리를 관리한다.
		BindTest bt=new BindTest("java");
		System.out.println(bt.toString());
		
		//동적바인딩: 메모리에 생성된 영역을 부모객체로 메모리를 관리한다. 상속이 관계여야  가능하다
		//상속(is a) -> 업캐스팅 ->동적바인딩
//		Object obj=new Object();
//		String st=new String("jsp");
//		obj=(Object)st; //묵시적 형변환과 유사. // 반드시 업캐스팅이 일어나야 다운캐스팅을 할 수 있다.
		
		Object obj = new String("jsp");
		
		
		
		
		
		String sn=(String)obj; //다운 캐스팅 -> 동적 바인딩
		
		
		System.out.println(sn.toString());
		
		
		
	}//end main()
	
}//end class
