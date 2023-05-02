package Basic;
import java.util.*;
public class factor {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter your number");
        int n=sc.nextInt(),fact=1;

        for(int i=1;i<=n;i++)
        {
            fact=fact*i;
        }
        System.out.println("factorial of "+n+" is "+fact);


    }
}
