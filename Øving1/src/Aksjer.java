import java.util.Date;

public class Aksjer {
    private static int startverdi = 20;

    public static void main(String[] args){
        tidsmaaling();
    }

    public static int[] genererData(int n){
        int[] aksjeendring = new int[n];
        for(int i = 0; i < aksjeendring.length; i++) {
            aksjeendring[i] = (int) (Math.random() * 14 - 7);
        }

        int[] aksjeverdi = new int[aksjeendring.length];
        aksjeverdi[0] = startverdi + aksjeendring[0];
        for(int i = 1; i < aksjeverdi.length; i++){
            aksjeverdi[i] = aksjeendring[i] + aksjeverdi[i-1];
        }

        return aksjeverdi;
    }

    public static void kjøp(int[] aksjeverdi){
        int kjop = -1;                                                  //1
        int selg = -1;                                                  //1
        int maxDiff = -1;                                               //1

        for(int i = 0; i < aksjeverdi.length; i++){                     //2n + 1
            for(int j = i + 1; j < aksjeverdi.length; j++){             //(2n + 1)*2n
                if((aksjeverdi[i] - aksjeverdi[j]) < maxDiff){          //3
                    maxDiff = aksjeverdi[i] - aksjeverdi[j];            //3
                    kjop = i + 1;                                       //1
                    selg = j + 1;                                       //1
                }
            }
        }

        //4n^2 + 4n + 12 -->   n^2 vil dominere og det er dermed kompleksiteten.

    }


    public static void tidsmaaling(){
        int[] tallSamling = {100, 1000, 10000, 100000};

        for(int i = 0; i < tallSamling.length; i++) {

            int[] testData = genererData(tallSamling[i]);

            Date start = new Date();
            int runder = 0;
            double tid;
            Date slutt;

            do {
                kjøp(testData);
                slutt = new Date();
                runder++;
            } while (slutt.getTime() - start.getTime() < 5000);

            tid = (double) (slutt.getTime() - start.getTime()) / runder;
            System.out.println("Millisekunder pr. runde: " + tid);
        }
    }
}
