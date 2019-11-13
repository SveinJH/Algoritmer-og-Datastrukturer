package LempelZiv.Decompressing;

import LempelZiv.FilAdmin;

import java.util.ArrayList;


public class LempelZivDekompresjon {

    private final int MIN_LENGDE = 3;
    private String filInn;
    private String filUt;

    public LempelZivDekompresjon(String filInn, String filUt) {
        this.filInn = filInn;
        this.filUt = filUt;
    }

    public void kjorDekomprimering() {
        byte[] lesteBytes = FilAdmin.lesBytesFraFil(this.filInn);
        FilAdmin.skrivBytestilFil(dekomprimer(lesteBytes), this.filUt);
    }

    public byte[] dekomprimer(byte[] data) {
        ArrayList<Byte> dekomprimert = new ArrayList<Byte>();
        for (int i = 0, indeksUt = 0; i < data.length; i++) {
            byte x = data[i];
            if (x < 0) {
                short avstand = (short)((data[i + 1] & 0xff) | ((data[i + 2] & 0xff) << 8));
                int start = indeksUt;
                for (int j = start - avstand; j < start - avstand - x; j++) {
                    dekomprimert.add(dekomprimert.get(j));
                    indeksUt++;
                }
                i += (MIN_LENGDE - 1);
            }
            else {
                for (int j = i + 1; j <= i + x && j < data.length; j++) {
                    dekomprimert.add(data[j]);
                    indeksUt++;
                }
                i += (int)x;
            }
        }
        return FilAdmin.listeTilArray(dekomprimert);
    }
}