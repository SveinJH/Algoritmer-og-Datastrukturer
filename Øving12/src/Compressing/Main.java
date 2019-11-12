package Compressing;

public class Main {

    public static void main(String[] args) {
        LempelZivKompresjon komprimator = new LempelZivKompresjon("Øving12\\src\\Filer\\ukomprimert.txt", "Øving12\\src\\Filer\\komprimert.lz");
        komprimator.kjorKompresjon();
    }

}
