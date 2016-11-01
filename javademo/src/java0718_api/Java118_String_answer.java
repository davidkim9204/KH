package java0718_api;
/*
 * [출력결과]
 * aerok
 */
public class Java118_String_answer {

	public static void main(String[] args) {
		String sn="korea";
		char[] data=display(sn);
		System.out.println(data);

	}//end main

	public static char[] display(String alpa){
		//apla매개변수에 저장된 문자열을 reverse한후 반환하는 프로그램을 구현하세요.
		
		char[] data=new char[alpa.length()];   //여기 data는 새로운 지역변수
		/*data[0]=alpa.charAt(4);
		data[1]=alpa.charAt(3);*/
		for(int i=0;i<data.length;i++){
			data[i]=alpa.charAt(alpa.length()-i-1);
		}
		
		return data;
		
	}//end display()
}//end class

