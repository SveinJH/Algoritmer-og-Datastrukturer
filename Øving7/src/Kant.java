public class Kant {
    Kant neste;
    Node til;

    public Kant(Node til, Kant neste) {
        this.til = til;
        this.neste = neste;
    }
}
