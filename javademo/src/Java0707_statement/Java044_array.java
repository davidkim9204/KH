package Java0707_statement;

public class Java044_array {

	public static void main(String[] args) {
		int[][] num=new int [3][2];
		num[0][0]=1;
		num[0][1]=2;
		num[1][0]=3;
		num[1][1]=4;
		num[2][0]=5;
		num[2][1]=6;
/*		
		System.out.printf("%d\t",num[0][0]);
		System.out.printf("%d\n",num[0][1]);
		System.out.printf("%d\t",num[1][0]);
		System.out.printf("%d\n",num[1][1]);
		System.out.printf("%d\t",num[2][0]);
		System.out.printf("%d\n",num[2][1]);
		*/
		
		//num.length : 행의 크기를 리턴한다.
		for(int row=0;row<num.length;row++){ //2차원에서는 행을 의미, 3차원에서는 면 
			//num[row].length: row행에 해당하는 열의 크기를 리턴한다.
			for(int col=0;col<num[row].length;col++){ //지정 행의 열의 크기를 리턴한다.
				System.out.printf("%d\t",num[row][col]);
				
			}
			System.out.println();
		}
		
		//각 행마다 열이 다를 수 있기 때문에 고정시키면 안된다.
				/*for(int col=0;col<num[].length;col++){
					for(int row=0; row,num.length;row++){
				}
				*/
		
		
		
		System.out.println("//////////////////");
		
		for(int col=0;col<2;col++){
			for(int row=0;row<3;row++){
				System.out.printf("%d\t",num[row][col]);
			}
			System.out.println();
		}
		
		
		
		
		
		
		
	}//end main()
}//end class
