package java0708_method;
// 4. 리턴값도 있고 매개변수도 있다.
public class Java051_method {

	public static void main(String[] args) {
		int[] data=new int[]{2,10};
		System.out.println(max(data)); //data를 밑에 int[] num이 받음

	}//end main

	public static int max(int[] num){
		if(num[0]>num[1])
			return num[0];
		else if(num[0]<num[1])
			return num[1];
		else
			return -1;   //리턴값이 하나가 아닌것 같아 보여도 처리해서 하나의 리턴만 하니깐 결국엔 1개의 리턴값만 존재함.
	}//end max
	
	
}//end class
