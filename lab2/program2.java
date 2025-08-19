package program2;

public class program2 {
	String brand;
	int year;
	
	program2(String a,int b){
		brand =a;
		year = b;
		
	}
	
	void display() {
		System.out.println(" Car "+ brand +" \n "+ " year " + year );
	}
	
	public static void main(String[] args) {
		program2 p1= new program2("bmw",2010);
		program2 p2=new program2("nissan gtr",2006);
		
		p1.display();
		p2.display();
	}

}

