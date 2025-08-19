package program4;

public class program4 {
	void sound() {
		System.out.println("animal make a sound ");
	}
}
	class dog extends program4{
		void sound() {
			System.out.println("dog barks");
		}
	
	public static void main(String[] args) {
		dog d=new dog();
		d.sound();
	}
	
}
