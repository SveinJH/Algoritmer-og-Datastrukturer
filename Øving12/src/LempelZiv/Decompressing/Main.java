package LempelZiv.Decompressing;

public class Main {
    public static void main(String[] args) {
        LempelZivDekompresjon dekomprimator = new LempelZivDekompresjon(
                "Øving12\\src\\LempelZiv\\Filer\\komprimert.lz", "Øving12\\src\\LempelZiv\\Filer\\dekomprimert.txt");
        dekomprimator.kjorDekomprimering();
    }
}
