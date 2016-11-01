package java0721_exception_stream;

public class Java148_exception {

	public static void main(String[] args) {
		StringBuffer sb=null;
		try{
		sb.reverse();
		System.out.println(sb);
		}catch(NullPointerException ex){
			sb=new StringBuffer("java");
			System.out.println(sb.reverse());
		}finally{
			System.out.println("program end");
		} //try영역 빠져나오면 끝이다. 
		//여기서는 굳이finally가 없어도 되지만 반드시 필요한 경우가 있다.
		//생략을 한다면 finally생략가능하다. finally만 놔두어도 괜찮다.
		//try는 생략
	}//end main()
}//end class
