package Decompressing;

public class Main {
    public static void main(String[] args) {
        LempelZivDekompresjon dekomprimator = new LempelZivDekompresjon(
                "Øving12\\src\\Filer\\komprimert.lz", "Øving12\\src\\Filer\\dekomprimert.txt");
        dekomprimator.kjorDekomprimering();
    }
}
