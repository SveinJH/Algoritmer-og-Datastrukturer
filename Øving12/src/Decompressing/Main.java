package Decompressing;

public class Main {
    public static void main(String[] args) {
        LempelZivDekompresjon lzDekompresjon = new LempelZivDekompresjon(
                "Øving12\\src\\Compressing\\komprimert.lz", "Øving12\\src\\Decompressing\\dekomprimert.txt");
        lzDekompresjon.kjorDekomprimering();
    }
}
