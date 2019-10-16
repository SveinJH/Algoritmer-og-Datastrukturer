package Oppgave2;

public class Stack {
    private char[] tab;
    private int count;

    public Stack(int size) {
        tab = new char[size];
    }

    public boolean empty() {
        return (count == 0);
    }

    public boolean full() {
        return (count == tab.length);
    }

    public void push(char c) {
        if(!full()) {
            tab[count++] = c;
        }
    }

    public char pop() {
        if(!empty()) {
            return tab[--count];
        } else {
            return '-';
        }
    }

    public char checkStack() {
        if(!empty()) {
            return tab[count-1];
        } else {
            return '-';
        }
    }
}
