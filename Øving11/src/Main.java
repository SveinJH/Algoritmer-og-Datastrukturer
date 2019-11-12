public class Main {

    public static void main(String[] args) {

        System.out.println("Automat 1:");
        char[] inputAlfabet = {'0', '1'};
        int[] akseptTilstander = {3};
        int[][] nesteTilstand = {{2, 1}, {1, 1}, {2, 3}, {3, 1}};

        Automat automat = new Automat(inputAlfabet, akseptTilstander, nesteTilstand);

        String input = "00000100";
        System.out.println(input + ": " + automat.sjekkInput(lagCharArray(input)));

        String input2 = "1010";
        System.out.println(input2 + ": " + automat.sjekkInput(lagCharArray(input2)));

        String input3 = "010101";
        System.out.println(input3 + ": " + automat.sjekkInput(lagCharArray(input3)));


        System.out.println("Automat 2:");
        char[] inputAlfabet2 = {'a', 'b'};
        int[] akseptTilstander2 = {3};
        int[][] nesteTilstand2 = {{1, 2}, {4, 3}, {3, 4}, {3, 3}, {4, 4}};

        Automat automat2 = new Automat(inputAlfabet2, akseptTilstander2, nesteTilstand2);

        String input4 = "ab";
        System.out.println(input4 + ": " + automat2.sjekkInput(lagCharArray(input4)));

        String input5 = "aaab";
        System.out.println(input5 + ": " + automat2.sjekkInput(lagCharArray(input5)));

        String input6 = "babab";
        System.out.println(input6 + ": " + automat2.sjekkInput(lagCharArray(input6)));

    }

    private static char[] lagCharArray(String input) {
        char[] charArray = new char[input.length()];
        for(int i = 0; i < charArray.length; i++) {
            charArray[i] = input.charAt(i);
        }

        return charArray;
    }

}
