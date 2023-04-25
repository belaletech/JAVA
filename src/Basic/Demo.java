package Basic;//Method Overloading

public class Demo {
    String name,city;
    int age;
    public void show(String n,String c)
    {
        name=n;
        city=c;
        System.out.println(" "+name+"and"+city);
    }
    public void show (String n,String c,int age)
    {
        name=n;
        city=c;
        age=age;
        System.out.println(" "+name+" "+city+"and"+age);
    }

    public class OverloadExample
    {
       public static void main(String[]args)
       {
           Demo obj=new Demo();
           obj.show("manish","noida");
           obj.show("belal","Siwan",22);
       }
    }

    public static class basic {
        public static void main(String[]args)
        {
            int [] ar={20,22,30,15,16,20,12};
            for (int i=0;i<ar.length-1;i++)
            {
                for( int j=1; j<ar.length;j++)
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
}
