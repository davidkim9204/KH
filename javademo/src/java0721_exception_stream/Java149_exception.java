package java0721_exception_stream;

public class Java149_exception {

	public static void main(String[] args) {
		String data1="12";
		//String data2="a";
		String data2="0";
		
		try{
		 int x=Integer.parseInt(data1);
		 int y=Integer.parseInt(data2);
		 int res=x/y;
		}catch(NumberFormatException ex){
			System.out.println("숫자를 입력하세요.");
		}catch(ArithmeticException ex){
			System.out.println("분모는 0보다 큰 수를 입력하세요.");
		}catch(RuntimeException ex){
			System.out.println(ex.toString()); //예측 못할녀석일때는 적당히 이정도로.
		}
		//여러개의 catch를 사용했으므로 다중캐치
		//상속관계가 있다. 상속관계에 있는 것을 사용할때 상위의 캐치를 아래에 써야한다.
		//안그러면 오류가 난다. 위에서부터 검색에서 처리하기 때문.
		//각각의 오류에 따라서 처리하는게 다를수 있으니깐
		
	}//end main()
	
}//end class

//정확한 값을 가져온다면 굳이 예외처리를 안써도된다.
//이미 확실한 값을 가지고 있다면 할 필요가 없다.

