
import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a =sc.nextInt();
        int b = String.valueOf(a).length();
        int sum=0;
        for (int i=0;i<=b;i++){
            int the = i%10;
            sum+=the;
        }
        
        
        System.out.print(sum);
    }    
}
