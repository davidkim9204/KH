package java0719_api;

public class java127_StringBuffer {

	 public static void main(String[] args) {
		StringBuffer sb=new StringBuffer("java test");
		
		//바꾸ㅓ주는 메소드 제공 x
		
		//StringBuffer -> String
		String sn=sb.toString();
		//String -> char[]
		display(sn.toCharArray());
		 
		
	}//end main()
	
	 public static void display(char[] data){
	 	for(char cn: data)
	 		System.out.println(cn);
	 
	 } 
}//end class
