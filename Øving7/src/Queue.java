public class Queue {
    private Object[] tab;
    private int start = 0;
    private int slutt = 0;
    private int antall = 0;

    public Queue(int storrelse) {
        tab = new Object[storrelse];
    }

    public boolean empty() {
        return antall == 0;
    }

    public boolean full() {
        return antall == tab.length;
    }

    public void put(Object o) {
        if(full()) {
            return;
        }

        tab[slutt] = o;
        slutt = (slutt + 1) % tab.length;
        antall++;
    }

    public Object next(){
        if(!empty()) {
            Object o = tab[start];
            start = (start + 1) % tab.length;
            antall--;
            return o;
        } else {
            return null;
        }
    }

    public Object check() {
        if(!empty()) {
            return tab[start];
        } else {
            return null;
        }
    }
}
