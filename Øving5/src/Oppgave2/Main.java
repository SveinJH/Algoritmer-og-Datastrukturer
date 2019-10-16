package Oppgave2;

import java.util.Date;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        int[] randomNumbs = generateNumbers(5000000);
        int runCount = 5;
        IntegerHashtable hashtable;

        Date start = new Date();
        Date end;

        for(int i = 0; i < runCount; i++) {
             hashtable = new IntegerHashtable(6249989);
            for (int j = 0; j < randomNumbs.length; j++) {
                hashtable.putv2(randomNumbs[j]);
            }
            //System.out.println(hashtable.getCollisionCount());
        }
        end = new Date();
        System.out.println("My hashfunction: " + (end.getTime() - start.getTime())/(double)runCount);


        start = new Date();
        for(int i = 0; i < runCount; i++) {
            HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
            for(int j = 0; j < randomNumbs.length; j++) {
                hashMap.put(j, randomNumbs[j]);
            }
        }
        end = new Date();
        System.out.println("Java hashfunction: " + (end.getTime() - start.getTime()) / (double)runCount);



        //int collisions = hashtable.getCollisionCount();
        //int used = hashtable.getUsedCount();

        //System.out.println("Number of collisions: " + collisions);
        //double lastfaktor = (double) used / hashtable.getHashtableSize();
        //System.out.println("Lastfaktor: " + lastfaktor);
    }

    public static int[] generateNumbers(int size) {
        java.util.Random rand = new java.util.Random();

        int[] randomNumbs = new int[size];
        for(int i = 0; i < randomNumbs.length; i++) {
            randomNumbs[i] = Math.abs(rand.nextInt());
        }
        return randomNumbs;
    }
}
