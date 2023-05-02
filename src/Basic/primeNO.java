package Basic;
import  java.util.Scanner;

public class primeNO {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your number:");
        int no = sc.nextInt(),count=0;
        for (int i = 1; i <= no; i++)
        {
        if(no%i==0)

         count++;

        }
        if(count==2)
        {
            System.out.println("Number is prime");
        }
        else
        {
            System.out.println("Number is not prime");
        }
    }
}
