package Compressing;

public class Main {

    public static void main(String[] args) {
        LempelZiv lempelZiv = new LempelZiv("Øving12\\src\\Compressing\\problem.txt", "Øving12\\src\\Compressing\\komprimert.lz");
        lempelZiv.compressFile();

    }

}
