package java0715_abstract_interface;

/* 
 * -(private) +(public) *(protected)
 * 
 * class와 interface를 이용하여 성적처리
 * 클래스명 : User
 *  -name:String
 *  +User()
 *  +User(name:String)
 *  +toString():String
 *  
 *  인터페이스명 : Score
 *  +sol:int  (초기값:20)
 *  +getScore():int
 *  
 *  인터페이스명 : Print
 *  +toPaint():String
 *  
 *  [출력화면]
 *  이름 : 홍길동
 *  점수 : 60점
 */

interface Score{
	public int sol=20;
	
	public int getScore();
	
}

interface Print{
	public String toPaint();
	
}



class User {
	private String name;
	
	public User(){
		
	}
	
	public User(String name){
		this.name=name;
		
	}
	@Override
	public String toString(){  //모든 클래스는 하나의 클래스로부터 상속을 받는다. 최상위는 object ! 얘한테 상속을 받고 있다.
		return "이름:"+name+"\n";
		
	}
	

	
}

class UserTest extends User implements Score, Print{
	int s;
	public UserTest(String name, int s){
		super(name);
		this.s=s;
	}
	
	@Override
	public int getScore() {
		// TODO Auto-generated method stub
		return sol*s;
	}
	
	@Override
	public String toPaint() {
		// TODO Auto-generated method stub
		return super.toString() + "점수:" + getScore() + "점\n";
	}
	
	
}



public class Java102_interface {

	public static void main(String[] args) {
		UserTest ut=new UserTest("홍길동",3);
		System.out.println(ut.toPaint());
		
		
		
		
		
	}//end main()
	
}//end class
