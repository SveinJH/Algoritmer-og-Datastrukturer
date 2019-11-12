package Decompressing;

public class Main {
    public static void main(String[] args) {
        LempelZivDekompresjon dekomprimator = new LempelZivDekompresjon(
                "Øving12\\src\\Compressing\\komprimert.lz", "Øving12\\src\\Decompressing\\dekomprimert.txt");
        dekomprimator.kjorDekomprimering();
    }
}
