public class Main {

    public static void main(String[] args) {
        String flytgraf1 = "C:\\Users\\Svein Jakob Høie\\Documents\\NTNU 2018-2021\\H2019\\Algoritmer-og-Datastrukturer\\Øving8\\src\\flytgraf1.txt";
        String flytgraf2 = "C:\\Users\\Svein Jakob Høie\\Documents\\NTNU 2018-2021\\H2019\\Algoritmer-og-Datastrukturer\\Øving8\\src\\flytgraf2.txt";
        String flytgraf3 = "C:\\Users\\Svein Jakob Høie\\Documents\\NTNU 2018-2021\\H2019\\Algoritmer-og-Datastrukturer\\Øving8\\src\\flytgraf3.txt";


        // Flytgraf 1
        System.out.println("\n------ FLYTGRAF 1 ------");
        EdmondKarp ek = new EdmondKarp();
        ek.edmondKarp(flytgraf1);

        // Flytgraf 2
        System.out.println("\n------ FLYTGRAF 2 ------");
        ek = new EdmondKarp();
        ek.edmondKarp(flytgraf2);

        // Flytgraf 3
        System.out.println("\n------ FLYTGRAF 3 ------");
        ek = new EdmondKarp();
        ek.edmondKarp(flytgraf3);
    }
}

