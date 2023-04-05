//Method Overloading

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
}
