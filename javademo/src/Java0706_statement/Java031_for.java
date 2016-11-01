package Java0706_statement;

public class Java031_for {

	public static void main(String[] args) {
		int odd=0; //홀수누적
		int even=0; //짝수 누적
		for(int i=1; i<=10; i++){
			if (i%2==0){
				even+=i;
			}else{
				odd+=i;
			}
		}
		
		System.out.printf("짝수누적:%d\n",even);//선언한것을 프린트 하려면 반드시 값을 지정해야 한다.
		System.out.printf("홀수누적:%d\n",odd);
		
		
	}//end main()
}//end class
