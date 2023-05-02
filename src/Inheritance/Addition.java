package Inheritance;
 class Addition {
    void add()
    {
        int x,y=30,z=40;
        x=y+z;
        System.out.println("Sum of" + y+" and " + z +" is" +x);
    }
 }
 class Subtraction extends  Addition{
     void sub() {
         int x, y = 30, z = 20;
         x = y - z;
         System.out.println(x);
     }

 }
 class easy{
     public static void main(String []args)
     {
         Subtraction sub=new Subtraction();
         sub.add();
         sub.sub();
     }
 }
