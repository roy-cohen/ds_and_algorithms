import java.util.HashMap;

public class RedBlueBlueRed {

    public static void main( String[] args ) {
        String pattern = "abba";
        String input = "abcxyzxyzabc";

        int match = wordpattern(pattern, input);
        System.out.println(match);
    }

    static HashMap<Character, String> map = new HashMap<Character, String>();


    static int wordpattern(String pattern, String input) {

        if (pattern.compareTo("") == 0 && input.compareTo("") == 0){
            return 1;
        }else if (pattern.compareTo("") == 0 || input.compareTo("") == 0){
            return 0;
        }
        return wordpattern(pattern, input, 0, 0) == true ? 1 : 0;
    }

    static boolean wordpattern(String pattern, String input, int patternIdx, int inputIdx){

        if (inputIdx == input.length() && patternIdx == pattern.length()){
            return true;
        }else if (inputIdx == input.length() || patternIdx == pattern.length()){
            return false;
        }
        else if (map.containsKey(pattern.charAt(patternIdx))){
            String word = map.get(pattern.charAt(patternIdx));

            if (inputIdx + word.length() > input.length()){
                return false;
            }

            String match = input.substring(inputIdx, inputIdx + word.length());
            if (match.compareTo(word) != 0){
                return false;
            }else{
                return wordpattern(pattern, input, patternIdx + 1, inputIdx + word.length());
            }
        }

        StringBuilder str = new StringBuilder();

        for (int i = inputIdx; i < input.length(); i++){
            str.append(input.charAt(i));

            map.put(pattern.charAt(patternIdx), str.toString());

            if (wordpattern(pattern, input, patternIdx + 1, i + 1) ){
                return true;
            }

            map.remove(pattern.charAt(patternIdx));
        }

        return false;
    }
}
