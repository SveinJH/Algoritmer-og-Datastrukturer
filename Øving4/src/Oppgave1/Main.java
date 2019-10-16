package Oppgave1;

public class Main {

    private static Liste liste = new Liste();

    public static void main(String[] args) {
        createNodes(41);
        deleteNodes(3);
    }

    // n
    public static Liste createNodes(int antall) {
        for(int i = 1; i < antall+1; i++) {
            liste.putAtBack(i);
        }
        //System.out.println(liste.finnAntall());
        return liste;
    }


    // n^2 + n??
    // f(x) = n + n*k

    public static void deleteNodes(int intervall) {
        Node n = liste.finnHode();
        while(n != null && n.neste != n) {
            for(int i = 0; i < intervall-1; i++) {
                n = n.neste;
            }
            System.out.println("Deleting: " + liste.delete(n.neste).finnElement());
            listNodes();
        }
        if(liste.finnAntall() == 1) {
            System.out.println("Winner: " + n.finnElement());
        }
    }

    public static void listNodes() {
        for(int i = 0; i < liste.finnAntall(); i++) {
            System.out.print(liste.findNumber(i).finnElement() + " ");
        }
        System.out.println();
    }

}
