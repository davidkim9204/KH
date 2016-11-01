package java0721_exception_stream;

public class Java147_exception {

	public static void main(String[] args) {
		int[] arr= new int[3];
		try{
		arr[4]=10;
		System.out.println(arr[4]);
		}catch(ArrayIndexOutOfBoundsException ex){
			//예외 정보
			//System.out.println(ex.getMessage());  //4
			System.out.println(ex.toString()); //override되어있다. 좀더 자세한 녀석
			ex.printStackTrace(); //예외가 발생한 경로를 전부 보여준다. 별도로 호출함. 리턴타입이 보이드이기 때문에 
			//예외 경로를 추적
		}finally{
			System.out.println("program end"); 
		}//이 영역은 반드시 써줄 필요는없다. 하지만 어떠한 경우라도 수행
	}//end main()
}//end class

