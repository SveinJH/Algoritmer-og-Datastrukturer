import java.util.Date;

public class Rek {
    public static void main(String[] args){
        //System.out.println(oppgave1(3, 4.5));
        //System.out.println(oppgave2(3, 4.5));

        runTest();
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
            return x*oppgave2((n-1)/2, x*x); //Her halveres problemet --> raskere algoritme
        } else {
            return oppgave2(n/2, x*x); //Problemet halveres --> raskere algoritme
        }
    }

    public static void runTest(){
        Date start = new Date();
        int runder = 0;
        double tid;
        double svar = 0.0;
        Date slutt;

        do {
            svar = oppgave2(1023, 2.0);
            slutt = new Date();
            runder++;
        } while ((slutt.getTime() - start.getTime()) < 1000);
        tid = (double) (slutt.getTime() - start.getTime()) / runder;
        System.out.println("Test 1: Millisekunder per runde: " + tid);
        System.out.println("" + svar);
    }
}
