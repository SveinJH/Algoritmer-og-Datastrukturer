public class Main {
    private final static int MOHOLT = 18058;
    private final static int KALVSKINNET = 37774;

    private final static int HELSINKI = 3378527;
    private final static int DRAMMEN = 65205;

    public static void main(String[] args) {
        System.out.println("-----1-----");
        System.out.println("\n--L7g1--");
        BFS l1g1 = new BFS();
        l1g1.createGraph("C:\\Users\\Svein Jakob Høie\\Documents\\NTNU 2018-2021\\H2019\\Algoritmer-og-Datastrukturer\\Øving7\\src\\L7g1");
        l1g1.bfs(5);
        l1g1.printGraph();

        System.out.println("\n--L7g2--");
        BFS l1g2 = new BFS();
        l1g2.createGraph("C:\\Users\\Svein Jakob Høie\\Documents\\NTNU 2018-2021\\H2019\\Algoritmer-og-Datastrukturer\\Øving7\\src\\L7g2");
        l1g2.bfs(5);
        l1g2.printGraph();

        System.out.println("\n--L7g3--");
        BFS l1g3 = new BFS();
        l1g3.createGraph("C:\\Users\\Svein Jakob Høie\\Documents\\NTNU 2018-2021\\H2019\\Algoritmer-og-Datastrukturer\\Øving7\\src\\L7g3");
        l1g3.bfs(5);
        l1g3.printGraph();

        System.out.println("\n--L7g5--");
        BFS l1g5 = new BFS();
        l1g5.createGraph("C:\\Users\\Svein Jakob Høie\\Documents\\NTNU 2018-2021\\H2019\\Algoritmer-og-Datastrukturer\\Øving7\\src\\L7g5");
        l1g5.bfs(5);
        l1g5.printGraph();

        BFS distanse = new BFS();
        distanse.createGraph("C:\\Users\\Svein Jakob Høie\\Documents\\NTNU 2018-2021\\H2019\\Algoritmer-og-Datastrukturer\\Øving7\\src\\L7Skandinavia");
        System.out.println("-----------\n");
        distanse.findDist(MOHOLT, KALVSKINNET);
        System.out.println("\n");

        System.out.println("-----2-----");
        Topologisk topo = new Topologisk();
        topo.createGraph("C:\\Users\\Svein Jakob Høie\\Documents\\NTNU 2018-2021\\H2019\\Algoritmer-og-Datastrukturer\\Øving7\\src\\L7g5");
        topo.ts();
    }
}
