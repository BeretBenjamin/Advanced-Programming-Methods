import java.util.Scanner;

public class paritate1 {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        //System.out.println("Enter N");

        int N = myObj.nextInt();
        int n;
        int nrpar = 0, nrimpar=0;
        for (int i = 0; i < N; i++) {
            //System.out.println("Enter n");
            n = myObj.nextInt();
            if(n%2==0)
            {
                nrpar++;
            }
            else
            {
                nrimpar++;
            }
        }
        System.out.println("Sum is : " + (nrimpar - nrpar));
    }
}