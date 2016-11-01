package java0715_abstract_interface;

class ExamA{
	
}

class ExamB extends ExamA{
	
}

class ExamC extends ExamB{
	
}

class Exam extends ExamC{
	
}


public class Java111_instanceof {

	public static void main(String[] args) {
		ExamB bb = new ExamB();
		System.out.println(bb instanceof ExamA); //true
		
		ExamA aa=new ExamA();
		System.out.println(aa instanceof ExamB); //false
	}
	
}


