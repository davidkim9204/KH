package java0708_method;

/*
 * [실행결과]
 * test avaj
 */
public class Java058_method {
	static char[] arr={'j','a','v','a',' ','t','e','s','t'};
	public static void main(String[] args) {
		
		System.out.println(reverse(arr));
		System.out.println(process());
		
	}//end main
	
	public static int[]process(){
		return new int[]{1,2,3};
	}
	//캐릭터일때만 안의 요소가 출력되고 숫자일땐 주소가 출력된다.0
	
	public static char[]reverse(char[] data){
		//data요소 앞뒤를 바꿔서 리턴하는 프로그램을 구현하세요.
		char[] num=new char[data.length];
		for(int i=0;i<num.length;++i){
			num[i]=data[data.length-1-i];
		}
		return num;
		
		
		/*//
		for(int i=0; i<arr.length;++i){
			arr=arr.length-1-i;
		}
		*//*
		return null;
		*/
		
	}//end reverse()
	
	
}//end class
