import java.util.Date;

public class Rek {
    public static void main(String[] args){
        System.out.println(oppgave1(3, 4.5));
    }

    public static double oppgave1(int n, double x){
        if(n <= 0){
            return 1;
        } else {
            return x*oppgave1(n-1, x);
        }
    }

    public static double oppgave2(int n, double x){
        if(n <= 0){
            return 1;
        } else if(n % 2 == 1){
            return x*oppgave2()
        } else {

        }
    }
}
