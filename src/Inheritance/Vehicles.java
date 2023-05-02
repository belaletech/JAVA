package Inheritance;

public class Vehicles {
    void run()
    {
        System.out.println("Xuv is running");
    }
}
class XUV extends Vehicles
{
    public static void main(String[] args)
    {
        XUV car=new XUV();
        car.run();
    }
}
