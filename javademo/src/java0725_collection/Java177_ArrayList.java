package java0725_collection;

import java.util.ArrayList;

public class Java177_ArrayList {

	public static void main(String[] args) {
		ArrayList<String> aList=new ArrayList<String>();
		aList.add("oracle");
		aList.add("mysql");
		aList.add("mssql");
		
		String[] arr = display(aList);
		for(String data : arr)
			System.out.println(data);
		
	}//end main()
	
	public static String[] display(ArrayList<String> aList){
		
//		String []stn = new String[aList.size()];
//			for(int i=0; i<aList.size();i++)
//				stn[i]=aList.get(i);
//			
//		return stn;	
	
		
		//컬렉션의 객체타입을 확인한다.
//		String[] arr=new String[aList.size()];
//		return aList.toArray(arr); //alist에 있는 값을 arr에 복사하라는 메소드이다.
		
		Object[] obj=aList.toArray();  //toArray는 object값으로 고정되어 있다.
		String[] stn=new String[obj.length];
		for(int i=0;i<obj.length;i++)
			stn[i]=(String)obj[i];
		return stn;
		
		
		//autoboxing 결국엔 object로 저장이 되니깐.
		
	
	}
	
}//end class
