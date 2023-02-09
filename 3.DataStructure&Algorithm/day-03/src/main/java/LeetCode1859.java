import java.util.Arrays;

public class LeetCode1859 {
    public static String sortSentence(String s) {
// "is2 sentence4 This1 a3"
        String[] words = s.split(" ");
        String[] newS = new String[words.length];
        for (String word : words) {
            int k = word.charAt(word.length()-1 - '0');
            newS[k-1] = word.substring(0,word.length()-1);
        }
        return String.join(" ",newS);
    }
}


