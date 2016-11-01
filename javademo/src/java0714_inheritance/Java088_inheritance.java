package java0714_inheritance;

class SuperConst{
	int x;
	int y;
	//SuperConst(){}
	
	public SuperConst(int x, int y){  //4
		this.x=x; //5
		this.y=y; //6
		System.out.printf("x=%d y=%d\n",x,y); //7
		
	} //8
}//end SuperConst class

class SubConst extends SuperConst{  //하나라도 생성자가 존재하면 무인자 생성자를 자동으로 제공해주지 않는다.
	SubConst(){  //2
	super(10, 20);  //3
	}//9
}//end SubConst class


public class Java088_inheritance {

	public static void main(String[] args) {
		SubConst sc = new SubConst();  //1
		
		//기본 생성자의 접근제어자는 class것을 따른다.
	}//end main() //11
	
}//end class
