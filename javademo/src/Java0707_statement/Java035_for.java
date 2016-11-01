package Java0707_statement;

/*
 * 반목문에서 특정 위치로 이동(continue)을 하거나 빠져나가려(break)일때
 * 반복문에 label명을 지정하고 호출하면 된다.
 * 
 * 
 */



public class Java035_for {

	public static void main(String[] args) {
		int cnt=0;
		move:
		for(int i=1;i<=5;i++){
						
			for(int j=1;j<=5;j++){
				cnt++;
				if(cnt%3!=0){
				    //break move;
					continue move;			//특정위치를 빠져나오려면 라벨을 사용. 라벨로 이동한다. 자기자신은 라벨이 필요없다.
				}
					System.out.println(cnt+"\t");
			}
		}	
	}//end main()
	
}//end class
