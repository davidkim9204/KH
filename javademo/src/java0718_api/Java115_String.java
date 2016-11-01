package java0718_api;

public class Java115_String {

	public static void main(String[] args) {
		String str = new String ("KoREa,jsp,java");
		System.out.println("문자열 길이:" +str.length()); //이때는 메소드이다.
		System.out.println("대문자:"+str.toUpperCase());
		System.out.println("소문자:"+str.toLowerCase());
		System.out.println("문자:"+str.charAt(1));
		System.out.println("인덱스:"+str.indexOf('R'));
		System.out.println("범위:"+str.substring(5)); //index5이하를 가져오는거
		System.out.println("범위:"+str.substring(2, 8)); //뒤 글자는 자바는 미만
		
		String[] arr=str.split(",");
		for(int i=0; i<arr.length;i++)
			System.out.printf("arr[%d]=%s\n",i,arr[i]);
		
		
		
		int x=10;
		int y=20;
		 
		System.out.printf("%d+%d=%d\n",x,y,x+y);
		
		
		//int =>: String
		String s1=String.valueOf(x);	// s1
		String s2=String.valueOf(y); //static이 선언되었기 때문에
		System.out.printf("%s+%s=%s\n",s1,s2,s1+s2); //string값이므로 문자열 연결에 사용된다.
		
		char[] data = {'1','2','3'};
		String s3=String.valueOf(data);
		System.out.println(data);
		
		//override한 것은 중복 설명하지 않는다.
		
		
		
	}//end main()
	
}//end class
