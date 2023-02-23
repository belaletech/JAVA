import java.sql.SQLOutput;

public class basic {
    public static void main(String[]args)
    {
        int j=0;
        int [] ar={20,22,30,15,16,12};
        for (int i=0;i<ar.length-1;i++)
        {
            for( j=j+1; j<ar.length;j++)
            {
                if((ar[i]==ar[j])&&(i !=j))
                {
                    System.out.println("Duplicate Element is "+ar[j]);
                }
            }
        }
        System.out.println("hello world");
    }
}
