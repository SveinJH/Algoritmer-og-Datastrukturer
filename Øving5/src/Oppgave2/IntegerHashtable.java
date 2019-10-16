package Oppgave2;

public class IntegerHashtable {
    private final int TABELL_STR;
    private int[] hashtable;
    private int collisionCount = 0;
    private int usedCount = 0;

    public IntegerHashtable(int TABELL_STR) {
        this.TABELL_STR = TABELL_STR;
        hashtable = new int[TABELL_STR];
    }

    public int getHashtableSize() { return TABELL_STR; }
    public int getCollisionCount() {return collisionCount; }
    public int getUsedCount() { return usedCount; }

    private int divhash(int k) { return k % (TABELL_STR - 1) + 1; }

    private int anotherDivhash(int k) { return k % (TABELL_STR); }

    private int probe(int h1, int h2, int i) {
        return (i + h2 + h1) % TABELL_STR;
    }

    public void putv1(int key) {
        int hashVal1 = anotherDivhash(key);
        int hashVal2 = divhash(key);

        while(hashtable[hashVal1] != 0) {
            hashVal1 = hashVal1 + hashVal2;
            hashVal1 = hashVal1 % TABELL_STR;
            collisionCount++;
        }

        hashtable[hashVal1] = key;
        usedCount++;
    }

    public int putv2(int key) {
        int h1 = divhash(key);
        int h2 = anotherDivhash(key);

        for(int i = 0; i < TABELL_STR; i++) {
            int j = probe(h1, h2, i);

            if(j > 0) {
                if(hashtable[j] == 0) {
                    hashtable[j] = key;
                    usedCount++;
                    return j;
                } else {
                    collisionCount++;
                }
            }
        }
        return -1;
    }
}
