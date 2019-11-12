package Compressing;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class LempelZivKompresjon {
    private final int REFERENCE_BYTES = 3;
    private String filInn;
    private String filUt;

    public boolean debug = true;

    public LempelZivKompresjon(String filInn, String filUt) {
        this.filInn = filInn;
        this.filUt = filUt;
    }

    public byte[] compress(byte[] data) {
        ArrayList<Byte> out = new ArrayList<Byte>();

        byte unreplaced = REFERENCE_BYTES;
        int i;
        for (i = REFERENCE_BYTES; i < data.length; i++) {
            boolean found = false;
            short distance = 0;
            byte lengthFound = 0;
            for (short d = 3; d <= i && d < 32767; d++) {
                if (data[i - d] == data[i]) {
                    int find;
                    for (find = 1; find < d && find < 127 && i + find < data.length;) {	// Poor search algorithm.
                        if (data[i + find] == data[i - d + find]) {find++;}
                        else {break;}
                    }
                    if (find > REFERENCE_BYTES && find > lengthFound) {
                        found = true;
                        lengthFound = (byte)find;
                        distance = d;
                        if (lengthFound == 127) {break;}
                    }
                }
            }
            if (found) {
                if (debug) System.out.println(i + " Distance: " + distance + ", length: " + lengthFound);
                if (unreplaced != 0) {
                    out.add(unreplaced);
                    //System.out.println(i + " Add: " + (i - unreplaced) + " < " + i);
                    //System.out.println("Unreplaced: " + unreplaced);
                    for (int j = i - unreplaced; j < i; j++) {out.add(data[j]);}
                    unreplaced = 0;
                }
                out.add((byte)(-lengthFound));	// REFERENCE_BYTES.
                out.add((byte)(distance & 0xff));
                out.add((byte)((distance >> 8) & 0xff));

                byte x0 = (byte)(distance & 0xff), x1 = (byte)((distance >> 8) & 0xff);

                if (debug) System.out.println(i + " Byte data: " + -lengthFound + ", calculated distance: " + ((x0 & 0xff) | ((x1 & 0xff) << 8)) + ", from: " + x0+ "," + x1);
                i += ((int)(lengthFound) - 1);
            }
            else {unreplaced++;}
            if (unreplaced == 127) {
                //System.out.println(i + " Add: " + (i - unreplaced + 1) + " <= " + i);
                out.add(unreplaced);
                //System.out.println("Unreplaced: " + unreplaced);
                for (int j = i - unreplaced + 1; j <= i; j++) {out.add(data[j]);}
                unreplaced = 0;
            }
        }
        out.add(unreplaced);
        //System.out.println("Unreplaced: " + unreplaced);
        for (int j = i - unreplaced; j < i; j++) {out.add(data[j]);}
        return listToArray(out);
    }

    private byte[] listToArray(ArrayList<Byte> out) {
        int length = out.size();
        byte[] result = new byte[length];
        for (int i = 0; i < length; i++) {result[i] = out.get(i);}
        return result;
    }

    private byte[] readBytesFromFile() {
        try {
            return Files.readAllBytes(Paths.get("Øving12\\src\\Compressing\\input.txt"));
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
        return null;
    }

    private void writeDataToFile(byte[] output, String path) {
        try(DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(path)))){
            dos.write(output);
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void kjorKompresjon() {
        byte[] lestData = readBytesFromFile();
        byte[] komprimert = compress(lestData);
        writeDataToFile(komprimert, "Øving12\\src\\Compressing\\komprimert.lz");

    }
}