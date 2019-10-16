package Oppgave1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        String namesList = readFromFile("C:\\Users\\Svein Jakob Høie\\Documents\\NTNU 2018-2021\\H2019\\Algoritmer-og-Datastrukturer\\Øving5\\src\\Oppgave1\\personer.txt");
        String[] names = namesList.split("\n");

        int rounds = 200;
        double tid;
        Date start = new Date();
        Date end;

        for(int j = 0; j < rounds; j++) {
            Hashtable myTable = new Hashtable(128);
            for(int i = 0; i < names.length; i++) {
                myTable.put(names[i]);
            }
        }
        end = new Date();
        tid = (double) (end.getTime() - start.getTime()) / rounds;
        System.out.println("Tid pr runde: " + tid);


        /*
        int antKollisjoner = myTable.getCollisionCount();
        System.out.println("Kollisjoner: " + antKollisjoner);
        System.out.println("Lastfaktor: " + myTable.getLastfaktor());

        LinkedList<String>[] test = myTable.getHashtable();

        int antpers = 0;
        for(int i = 0; i < test.length; i++){
            for(int j = 0; j < test[i].size(); j++) {
                antpers++;
            }
        }
        System.out.println("Antall personer: " + antpers);
        System.out.println("Kollisjoner per pers: " + ((double)antKollisjoner/antpers));


        // Oppslag på navn
        String name = "Pickel,Pascal";
        int pos = myTable.findPos(name);
        if(pos != -1) {
            System.out.println("\n" + name + " finnes på posisjon " + pos);
        } else {
            System.out.println("\n" + name + " er ikke registrert");
        }


        //Oppslag på posisjon
        int position = 94;
        String nameGivenPos = myTable.findName(position);
        if(nameGivenPos != null) {
            System.out.println("\n" + nameGivenPos + "finnes på posisjon " + position);
        } else {
            System.out.println("Ingen på den posisjonen!");
        }
        */

    }

    public static String readFromFile(String path) {
        String message = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String linje = br.readLine();

            while(linje != null) {
                message += linje + "\n";
                linje = br.readLine();
            }

            return message;

        } catch(IOException ioe) {
            ioe.printStackTrace();
        }

        return null;
    }
}
