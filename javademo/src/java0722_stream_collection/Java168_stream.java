package java0722_stream_collection;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

/*
 * 직렬화(serializable) - 아무것도 구현이 안된 interface
 * 1 객체를 연속적인 데이터로 변환하는 것이다.
 *   반대로는 역직렬화이다.
 * 2 객체의 멤버변수들의 값을 일렬로 나열하는 것이다.
 * 3 객체를 저장하기 위해서는 객체를 직렬화해야 한다.
 * 4 객체를 저장한다는 것은 객체의 멤버변수의 값을 저장한다는 것이다.
 * 5 객체를 직렬화하여 입출력할 수 있는 스트림
 *    ObjectInputStream, ObjectOutputStream
 */


class Phone implements Serializable{
	String name;
	transient int price; //직렬화에서 제외하려면
	public Phone(){
		
	}
	public Phone(String name, int price){
		super();
		this.name = name;
		this.price=price;
	}
	
	@Override
	public String toString() {
		return name+"  "+price;
	}
	
	
}//end class

public class Java168_stream {

	public static void main(String[] args) {
		File file=new File("./src/java0722_stream_collection/phone.dat");
		FileOutputStream fs= null;
		FileInputStream fi= null;
		ObjectOutputStream os = null;
		ObjectInputStream oi=null;
		
		try {
			fs=new FileOutputStream(file);
			os=new ObjectOutputStream(fs);
			Phone p=new Phone("android",5000);
			os.writeObject(p);
			
			System.out.println("Phone객체 저장");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				os.close();
				fs.close();
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		System.out.println("///////////////////////////////////");
		
		try{
		fi=new FileInputStream(file);
		oi=new ObjectInputStream(fi);
		Phone p=(Phone)oi.readObject();
		
		} catch(FileNotFoundException e){
			e.printStackTrace();
			
			
		} catch (IOException e){
			e.printStackTrace();
			
		}catch(ClassCastException e){
			e.printStackTrace();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				oi.close();
				fi.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

//너무 길어서 실수 부분이 존재하니 수정요망.		
	}//end main()
	
}//end class
