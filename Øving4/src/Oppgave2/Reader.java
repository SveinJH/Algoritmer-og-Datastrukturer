package Oppgave2;

public class Reader {
    private char[] startSymbols = {'(', '[', '{'};
    private char[] endSymbols = {')', ']', '}'};

    public boolean checkParantheses(String code) {
        Stack stack = new Stack(code.length());

        for(int i = 0; i < code.length(); i++) {
            char current = code.charAt(i);

            for(int j = 0; j < startSymbols.length; j++) {
                if(current == startSymbols[j]) {
                    stack.push(current);
                } else if(current == endSymbols[j]) {

                    // Can't start with an ending-parenthesis
                    if(stack.empty()) {
                        return false;
                    } else {
                        switch(current) {

                            case ')':
                                if(stack.pop() != '(') {
                                    return false;
                                }
                                break;
                            case ']':
                                if(stack.pop() != '[') {
                                    return false;
                                }
                                break;
                            case '}':
                                if(stack.pop() != '{') {
                                    return false;
                                }
                                break;
                        }
                    }

                }
            }
        }
        if(stack.empty()) {
            return true;
        }

        return false;
    }
}
