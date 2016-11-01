package java0721_exception_stream;


//throw는 존재만 숙지하는 정도로.
public class Java152_exception {

	public static void main(String[] args) {
		int num=3;
		process(num);
		
		
	}//end main()
	

	public static void process(int data){
		try{
			if(data<10)
				throw new ArithmeticException("10이상만 입력하세요");
			System.out.println(data);
		}catch (ArithmeticException ex){
			System.out.println(ex.toString());
		}
	}//end process()
	
	
}//end class
