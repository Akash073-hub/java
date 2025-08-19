package program1;

public class program1 {
	String name;
	int age;
	
	void displayinfo() {
		System.out.println("Name "+ name +"\n"  + " Age " +age);
	}
	public static void main(String[] args) {
		 program1 s1=new program1();
		 s1.name ="john";
		 s1.age = 10;
		 s1.displayinfo();
	}
}

