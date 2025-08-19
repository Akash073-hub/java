package program3;

public class program3 {
	int add(int a, int b) {
		return a+b;
	}
	int subtarct(int a, int b) {
		return a-b;
	}
	public static void main(String[] agrs) {
		program3 math = new program3();
		System.out.println(" addition " + math.add(11,3));
		System.out.println(" subtraction " + math.subtarct(11,3));
	}

}
