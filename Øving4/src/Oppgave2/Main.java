package Oppgave2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Reader reader = new Reader();

        System.out.println(reader.checkParantheses("{th((ii)s is a test}"));
        System.out.println(reader.checkParantheses("th{is[is()]a tes}ttt"));
        System.out.println(reader.checkParantheses(readFromFile("C:\\Users\\Svein Jakob Høie\\Documents\\Strings\\code.txt")));
    }

    private static String readFromFile(String path) {
        String code = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line = br.readLine();

            while(line != null) {
                code += line + "/n";

                line = br.readLine();
            }

            return code;

        } catch(IOException IOE) {
            IOE.printStackTrace();
        }

        return code;
    }

}
