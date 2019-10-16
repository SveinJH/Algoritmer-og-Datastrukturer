import java.util.Date;
import java.util.Random;

public class Sortering {
    private static Random r = new Random();
    private static int delestr = 56; //Beste delestr...


    public static void main(String[] args){
        //for(int i = 0; i < 100; i++) {
            taTid();
            //x++;
        //}

        //runTests();

        //oppgave3();
    }


    public static int[] genererTabell(int antall, int nextInt){
        int[] tab = new int[antall];

        for(int i = 0; i < tab.length; i++){
            tab[i] = r.nextInt(nextInt) + 1;
        }
        return tab;
    }

    public static void oppgave3(){
        int[] t = genererTabell(1000000, 1000000);
        int v = 0;
        int h = t.length - 1;


        Date start = new Date();
        double tid = 0;
        Date slutt;

        quicksort(t, v, h);

        slutt = new Date();

        tid = (double) (slutt.getTime() - start.getTime());

        System.out.println("Millisekunder på å sortere 1 million tall: " + tid);

        int[] tab1 = new int[t.length];
        for(int i = 0; i < tab1.length; i++){
            tab1[i] = t[i];
        }

        quicksort(t, v, h);

        boolean testOK = true;
        for(int i = 0; i < t.length; i++){
            if(tab1[i] != t[i]){
                testOK = false;
                break;
            }
        }
        if(testOK){
            System.out.println("Sortering av 1 million tall suksess!");
        }

    }

    public static void runTests(){
        int[] t = genererTabell(100000, 100000);
        int v = 0;
        int h = t.length - 1;

        int sumFor = 0;
        int sumEtter = 0;

        for (int i = 0; i < t.length; i++){
            sumFor += t[i];
        }

        quicksort(t, v, h);


        //Test 1 -- Er tallene er riktig sortert?
        if(testSortering(t)){
            System.out.println("Test 1 passert.");
        } else {
            System.out.println("Test 1 failed.");
        }


        for(int i = 0; i < t.length; i++){
            sumEtter += t[i];
        }

        //Test 2 -- Er sum før og etter lik?
        if(sumFor == sumEtter){
            System.out.println("Test 2 passert.");
        } else {
            System.out.println("Test 2 failed.");
        }
    }


    public static boolean testSortering(int[] tab){
        for(int i = 0; i < tab.length-2; i++){
            if(!(tab[i+1] >= tab[i])){
                return false;
            }
        }
        return true;
    }

    public static void taTid(){
        int[] t = genererTabell(100000, 100000);

        int v = 0;
        int h = t.length - 1;
        Date start = new Date();
        int runder = 0;
        double tid;
        Date slutt;

        do {
            quicksort(t, v, h);
            slutt = new Date();
            runder++;
            t = genererTabell(100000, 100000);

        } while(slutt.getTime() - start.getTime() < 1000);
        tid = (double) (slutt.getTime() - start.getTime()) / runder;

        System.out.println("Millisekunder pr. runde: " + tid + ", delestr: " + delestr);
    }


    //-----------------
    //SORTERINGSMETODER
    //-----------------

    public static void quicksort(int[] t, int v, int h){
        if(h - v > delestr){
            int delepos = splitt(t, v, h);
            quicksort(t, v, delepos - 1);
            quicksort(t, delepos + 1, h);
        } else {
            //1. Innsettingssortering
            innsettingssorter(t, v, h);
            //2. Boblesortering
            //3. Velgesortering
            //4. Shellsort
        }
    }


    public static void innsettingssorter(int[] t, int fra, int til){
        for(int j = fra + 1; j < til + 1; j++){
            int bytt = t[j];
            int i = j - 1;
            while(i >= fra && t[i] > bytt){
                t[i + 1] = t[i];
                i--;
            }
            t[i + 1] = bytt;
        }
    }


    private static int splitt(int[] t, int v, int h){
        int iv, ih;
        int m = median3sort(t, v, h);
        int dv = t[m];
        bytt(t, m, h - 1);

        for(iv = v, ih = h - 1;;){
            while(t[++iv] < dv);
            while(t[--ih] > dv);
            if(iv >= ih) break;
            bytt(t, iv, ih);
        }
        bytt(t, iv, h-1);
        return iv;
    }

    public static void bytt(int[] t, int i, int j){
        int k = t[j];
        t[j] = t[i];
        t[i] = k;
    }

    private static int median3sort(int[] t, int v, int h){
        int m = (v + h) / 2;
        if(t[v] > t[m]) {
            bytt(t, v, m);
        }
        if(t[m] > t[h]){
            bytt(t, m, h);
            if(t[v] > t[m]) {
                bytt(t, v, m);
            }
        }
        return m;
    }
}
