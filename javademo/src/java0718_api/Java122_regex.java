package java0718_api;

public class Java122_regex {

	public static void main(String[] args) {
		String sn="java korea";
		String sg="";
		String st="java     korea";  //공백 5개
		
		//sn변수에 저장된 문자열에서 'a' or 'r'이면 '_'로 변경해서 
		//sg변수에 저장하고 나머지는 그대로 사용한다.
		for(int i=0;i<sn.length();i++){
			if(sn.charAt(i)=='a'||sn.charAt(i)=='r')
				sg+='_';
			else 
				sg +=sn.charAt(i);
		}
		
		System.out.println(sg);
		
		System.out.println("regular expression을 이용한 문자변경");
		System.out.println(sn.replaceAll("[ar]", "_"));
		//sn변수에 저장되어 있는 문자열이 a or r 이면 _로 바꿔라
		//[]는 or를 의미.
		
		System.out.println(sn.matches(".*[ar].*"));//sn변수에 저장된 문자열에서 a이거나 r이 포함되어 있으면 true 아니면 false.
		// .임의의 문자 한자리   .*임의의 문자 여러자리
		
		System.out.println(st.replaceAll("\\s{2,3}", "@"));
		//\s는 공백을 의미(""안에서는 \\s.이미 \s는 특수문자 처리라고 약속을 해서). 
		//공백이 2개에서 3개면 @로 바꿔라.
		//{}는 갯수를 의미.
		
	}//end main()

}//end class
