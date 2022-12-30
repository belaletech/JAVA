import java.util.Scanner;
public class Assignment2 {


    public class internshala_assignment_2 {
        static void calculateTax(String name, long income ){
            if (income>=300000 ){
//            20 percent income tax
                float x = (float)(20/100f)*income;
                long tax = (long)x;
                System.out.println( name + " : Rs " + tax);

            }
            else if (income<300000 && income>=100000 ){
//            10% income tax
                float x = (float)(10/100f)*income;
                long tax = (long)x;
                System.out.println( name + " : Rs " + tax);
            } else if (income>=0 && income<100000 ){

                System.out.println( name + " : Rs 0" );
            }

        }
        public static void main(String[] args) {
//        Declaration
            Scanner sc = new Scanner(System.in);
            int count;


//        Program starting
            System.out.println("Tax Calculator App\n" +
                    "----- WELCOME ------");
            System.out.print("Enter total person count: ");
            count = Integer.parseInt(sc.nextLine());

            String[] names = new String[count];
            Long[] income = new Long[count];
            int num = 1;
            for (int i = 0; i<names.length; i++){
                System.out.printf(" Enter name %d : ", num++);
                names[i] = sc.nextLine();
                System.out.printf(" Enter %s's income :  ", names[i]);
                income[i] = sc.nextLong();
                sc.nextLine();
            }
            System.out.println(" ");
            System.out.println("Names with liable taxes\n" +
                    "—————————————");
            for (int i = 0; i<names.length; i++){
                calculateTax(names[i],income[i]);
            }

        }
    }
}
