public class Aksjer {

    public static void main(String[] args){
        aksjer(6, 20);

    }

    public static void aksjer(int n, int startverdi){

        //Beregne endringen per dag
        int[] aksjeendring = new int[n];
        for(int i = 0; i < aksjeendring.length; i++){
            aksjeendring[i] = (int)(Math.random()*14 - 7);
        }


        //Beregne aksjens verdi til hver dag
        int[] aksjeverdi = new int[aksjeendring.length];
        aksjeverdi[0] = startverdi + aksjeendring[0];
        for(int i = 1; i < n; i++){
            aksjeverdi[i] = aksjeendring[i] + aksjeverdi[i-1];
        }


        //Finne høyest fortjeneste

        //Finne beste kjøpsdag
        int minste = aksjeverdi[0];
        int minsteDag = -1;
        for(int i = 0; i < aksjeverdi.length; i++){
            if(aksjeverdi[i] < minste){
                minste = aksjeverdi[i];
                minsteDag = i;
            }
        }

        //Finne beste salgsdag
        int hoyeste = aksjeverdi[minsteDag];
        for(int i = 0; i < n; i++){

        }


        //Testing
        for (int i = 0; i < aksjeendring.length; i++){
            System.out.println(aksjeendring[i]);
        }
        System.out.println("-------");
        for (int i = 0; i < aksjeendring.length; i++){
            System.out.println(aksjeverdi[i]);
        }
        System.out.println("-------");
        System.out.println(minste + " // " + (minsteDag+1));

    }
}
