package Oppgave1;

public class Liste {

    private Node hode;
    private Node hale;
    private int antElementer = 0;

    public int finnAntall() {
        return antElementer;
    }

    public Node finnHode() {
        return hode;
    }

    public Node finnHale() {
        return hale;
    }

    public void settInnFremst(int verdi) {
        hode = new Node(verdi, hode, null);
        if (hale == null) {
            hale = hode;
        } else {
            hode.neste.forrige = hode;
        }
        antElementer++;
    }

    public void putAtBack(int verdi) {
        if (hode == null) {
            hode = new Node(verdi, null, null);
            hode.neste = hode;
            hode.forrige = hode;
            //System.out.println("forste");

        } else {
            hode.forrige = new Node(verdi, hode, hode.forrige);
            hode.forrige.forrige.neste = hode.forrige;
        }
        antElementer++;
    }

    public Node delete(Node n) {
        if(n.forrige != null) {
            n.forrige.neste = n.neste;
        } else {
            hode = n.neste;
        }

        if(n.neste != null) {
            n.neste.forrige = n.forrige;
        } else {
            hale = n.forrige;
        }

        if(n == hode) {
            hode = n.neste;
        } else if(n == hale){
            hale = n.forrige;
        }

        n.neste = null;
        n.forrige = null;

        antElementer--;

        return n;
    }

    public Node findNumber(int nr) {
        Node denne = hode;
        if (nr < antElementer) {
            for (int i = 0; i < nr; i++) {
                denne = denne.neste;
            }
            return denne;
        } else {
            return null;
        }
    }

    public void slettAlle() {
        hode = null;
        hale = null;
        antElementer = 0;
    }

    public String toString() {
        return "Antall noder: " + finnAntall();
    }
}
