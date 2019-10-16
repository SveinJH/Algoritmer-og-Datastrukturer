package Oppgave1;

import java.util.LinkedList;

public class Hashtable {
    private final int TABELL_STR;
    @SuppressWarnings("unchecked")
    private LinkedList<String>[] hashtable;
    private int collisionCount = 0;
    private int usedCount = 0;

    public Hashtable(int TABELL_STR) {
        this.TABELL_STR = TABELL_STR;
        hashtable = new LinkedList[TABELL_STR];
        for(int i = 0; i < TABELL_STR; i++) {
            hashtable[i] = new LinkedList<String>();
        }
    }

    public LinkedList<String>[] getHashtable() { return hashtable; }
    public int getCollisionCount() { return collisionCount; }
    public int getUsedCount() { return usedCount; }
    public double getLastfaktor() { return (double) usedCount / TABELL_STR; }


    public int convertString(String string) {
        int sum = 0;

        for(int i = string.length()-1; i >= 0; i--) {
            int ascii = string.charAt(i) * (11 * (i + i + 1));
            sum += ascii;
        }
        return sum;
    }

    //Hashfunksjon basert på restdivisjon
    public int divhash(int k) {
        return k % (TABELL_STR);
    }


    //
    public int put(String name) {
        int key = convertString(name);
        int h = divhash(key);
        if(hashtable[h].size() == 0) {
            hashtable[h].add(name);
            System.out.println(name + " added.");
            usedCount++;
        } else {
            collisionCount++;
            hashtable[h].addFirst(name);
            System.out.println(name + " collided with " + hashtable[h].getFirst());
            System.out.println(name + " added after collision.");
            usedCount++;


            /*int size = hashtable[h].size();
            for(int i = 0; i < size; i++) {
                collisionCount++;
                System.out.println(name + " collided with " + hashtable[h].get(i));
                if(i+1 == hashtable[h].size()) {
                    hashtable[h].add(name);
                    System.out.println(name + " added after collision.");
                    usedCount++;
                }
            }

             */


        }
        return -1; //Full
    }

    //Oppslag gitt navn
    public int findPos(String name) {
        int key = convertString(name);
        int h = divhash(key);

        for(int i = 0; i < hashtable[h].size(); i++){
            if(name.equals(hashtable[h].get(i))) {
                return h;
            }
        }
        return -1; //Non-existent
    }

    //Oppslag gitt posisjon
    public String findName(int pos) {
        String name = "";
        for(int i = 0; i < hashtable[pos].size(); i++) {
            name += hashtable[pos].get(i) + ",\n";
        }
        if(name.equals("")){
            return null;
        }

        return name;
    }
}
