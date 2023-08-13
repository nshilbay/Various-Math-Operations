/**************************************
Nadeen Shilbayeh
Provides a menu of various math operations and the user decides on which to perform as well as the numbers to use
****************************************/
package Lab6Q;
import java.util.Scanner;
public class MyMethod {

    // power method
    public static double myPow(double x, int y){
        double result = 1;//initializes the result to one since its series multiplication
        if (y>0) //checks if the exponent is negative
        {
            while (y>0){
                result = result*x;//series multiplication
                y--;//decreases value of y by one
            }
            return result;//returns result
        }
        else{
            while (y<0){
                result = result*x;//series multiplication
                y++;//increases value of y by one
            }
            return 1/result;//returns one over the result
        }
    }

    //factorial method
    public static double myFactorial(int n){
        double result = 1;//initializes result to one since its series multiplication
        for (int i = 1; i <= n; i++){//for loop for series multiplication
            result = result * i;
        }
        return result;//returns result
    }

    //sin computation
    public static double mySin(double x){
        double y = 0;//initializes result to 0
        for (int n = 0; n <= 20; n++){
            double p1 = myFactorial(2*n +1);//calls on myFactorial method
            double p2 = myPow(-1,n);//calls on myPow method
            double p3 = myPow(x, 2*n +1);//calls on myPow method
            y = y + (p2/p1) *p3;//calculates the Reimann's sum
        }
        return y;//returns the result
    }

    //cos computation
    public static double myCos(double x){
        double y = 0;//initializes result to 0
        for (int n = 0; n <= 20; n++){
            double p1 = myFactorial(2*n);//calls on myFactorial method
            double p2 = myPow(-1,n);//calls on myPow method
            double p3 = myPow(x, 2*n);//calls  on myPow method
            y = y + (p2/p1) *p3;//calculates the Reimann's sum
        }
        return y;//returns the result
    }

    //degree to radians conversion method
    public static double myDegreeToRadian (double degree){
        return (degree*Math.PI)/180.0;//conversion formula
    }


    public static void main(String[] args){//main method

        //intializes an object called input
        Scanner input = new Scanner(System.in);

        char choice;

        while (true){//an infinite loop

            System.out.printf("\n======================\na: Power Function\nb: Factorial Function\nc: Sine Function\nd: Cosine Function\ne: exit\n======================\n");//output choice menu
            System.out.println("Enter a choice:");//prompt  user to enter a choice
            choice = input.next().charAt(0);
            choice = Character.toUpperCase(choice);//convert all letters to upper case

            switch (choice)
            {
                case 'A':
                    System.out.println("Enter the base:");//prompts user to enter base of exp.
                    double base = input.nextDouble();
                    System.out.println("Enter the exponent");//prompts user to enter exp.
                    int exponent = input.nextInt();
                    System.out.println(myPow(base,exponent));//calls on myPow method
                    break;
                case 'B':
                    System.out.println("Enter a factorial:");//prompts user to enter factorial
                    int factorial = input.nextInt();
                    System.out.println(myFactorial(factorial));//calls ony my factorial method
                    break;
                case 'C':
                    System.out.println("Enter a value in degrees:");//prompts user to enter an angle in degrees
                    double degrees = input.nextDouble();
                    System.out.printf("%.2f",mySin(myDegreeToRadian(degrees)));//calls on mySin and myDegreeToRadian methods
                    break;
                case 'D':
                    System.out.println("Enter a value in degrees:");
                    double angle = input.nextDouble();//prompts user to enter an angle in degrees
                    System.out.printf("%.2f", myCos(myDegreeToRadian(angle)));//calls on myCos and myDegreeToRadian methods
                    break;
                case 'E':
                    break;
                default:
                    System.out.println("Invalid Choice:");
                    break;
            }

            if (choice == 'E'){//break out of loop when user decides to
                break;
            }

        }
    }

}
