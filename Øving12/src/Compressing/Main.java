package Compressing;

public class Main {

    public static void main(String[] args) {
        LempelZivKompresjon komprimator = new LempelZivKompresjon("Øving12\\src\\Compressing\\input.txt", "Øving12\\src\\Compressing\\komprimert.lz");
        komprimator.kjorKompresjon();



    }

}
