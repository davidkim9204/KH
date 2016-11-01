package Java0707_statement;

public class Java040_array {
	public static void main(String[] args) {
		//배열을 생성할 때 초기값이 주어지면 배열의 크기를 지정할 수 없다.
		int[] num=new int[]{60,75,88}; //값을 기준으로 크기를 잡고 인덱스를 생성한후 초기값을 입력한다. 배열의 크기를 지정하면 안된다.
		
	/*	System.out.println(num[0]);
		System.out.println(num[1]);
		System.out.println(num[2]);*/
		
		/*for(int i=0; i<num.length;i++){
			System.out.println(num[i]);
		}
		
		System.out.println("///////////////////////////////");
		System.out.println([2]);
		System.out.println([1]);
		System.out.println([0]);*/
		
		
		for(int i=2; i>=0;--i){
			System.out.println(num[i]);
		}
		
		for(int i=num.length-1; i>=0;--i){
			System.out.println(num[i]);
		}
		
		
		
	}//end main()

}//end class
