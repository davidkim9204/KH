package Java0707_statement;

public class Java034_for {

	public static void main(String[] args) {
		
		int cnt=1;
		int sum=0;
		for(int row=1; row<=5 ;row++){
			sum=0;
			for(int col=1; col<=5 ;col++){
				sum+=cnt;//초기값을 무엇으로 잡는지가 결과에 영향을 주기때문에 식을 잘 세워야한다.
				System.out.printf("%d\t",cnt++);
				
				
			
			}
			System.out.println(sum);
			sum=0;//여기서는 2군데 다 가능하다.
		}
		
	}//end main()
}//end class
