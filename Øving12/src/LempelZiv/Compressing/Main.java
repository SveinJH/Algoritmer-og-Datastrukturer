package LempelZiv.Compressing;

import java.io.File;

public class Main {

    public static void main(String[] args) {


        LempelZivKompresjon komprimator = new LempelZivKompresjon("Øving12\\src\\LempelZiv\\Filer\\ukomprimert.txt", "Øving12\\src\\LempelZiv\\Filer\\komprimert.lz");
        komprimator.kjorKompresjon();

        double størrelseFør = new File("Øving12\\src\\LempelZiv\\Filer\\ukomprimert.txt").length();
        double størrelseEtter = new File("Øving12\\src\\LempelZiv\\Filer\\komprimert.lz").length();

        System.out.println("|--------------------------------------|");
        System.out.println("Størrelse før komprimering:   | " + størrelseFør);
        System.out.println("Størrelse etter komprimering: | " + størrelseEtter);
        System.out.println("Endring i prosent:            | " + (-100+((størrelseEtter/størrelseFør))*100) + "%");

    }
}
