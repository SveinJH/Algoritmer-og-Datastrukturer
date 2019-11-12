public class Automat {
    private char[] inputAlfabet;
    private int[] akseptTilstander;
    private int[][] nesteTilstand;

    public Automat(char[] inputAlfabet, int[] akseptTilstander, int[][] nesteTilstand) {
        this.inputAlfabet = inputAlfabet;
        this.akseptTilstander = akseptTilstander;
        this.nesteTilstand = nesteTilstand;
    }

    private boolean iAlfabet(char[] input) {
        for(int i = 0; i < input.length; i++) {
            boolean inkludert = false;
            for(int j = 0; j < inputAlfabet.length; j++) {
                if(input[i] == inputAlfabet[j]) {
                    inkludert = true;
                    j = inputAlfabet.length;
                }
            }
            if(!inkludert) {
                return false;
            }
        }
        return true;
    }

    private boolean iAkseptTilstand(int pos) {
        boolean ok = false;
        for(int i = 0; i < akseptTilstander.length; i++) {
            if(pos == akseptTilstander[i]) {
                ok = true;
            }
        }
        return ok;
    }

    private int alfabetIndeks(char c) {
        for(int i = 0; i < inputAlfabet.length; i++) {
            if (c == inputAlfabet[i]) {
                return i;
            }
        }
        return -1;
    }

    public boolean sjekkInput(char[] input) {
        if(!iAlfabet(input)) {
            return false;
        }

        int pos = 0;

        for(int i = 0; i < input.length; i++) {
            boolean funnet = false;
            for(int j = 0; j < nesteTilstand[pos].length; j++) {
                if(alfabetIndeks(input[i]) == j && !funnet) {
                    pos = nesteTilstand[pos][j];
                    funnet = true;
                }
            }
        }
        return iAkseptTilstand(pos);
    }

}
