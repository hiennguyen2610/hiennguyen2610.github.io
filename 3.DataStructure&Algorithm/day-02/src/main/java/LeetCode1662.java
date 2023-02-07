public class LeetCode1662 {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
       // Cach 1
//        String s1 = "";
//        String s2 = "";
//        for (int i = 0; i < word1.length; i++) {
//            s1 += word1[i];
//        }
//        for (int i = 0; i < word2.length; i++) {
//            s2 += word2[i];
//        }
//        return s1.equals(s2);

        // Cach 2
//        StringBuilder s1 = new StringBuilder();
//        StringBuilder s2 = new StringBuilder();
//        for (int i = 0; i < word1.length; i++) {
//            s1.append(word1[i]);
//        }
//        for (int i = 0; i < word2.length; i++) {
//            s2.append(word2[i]);
//        }
//        return s1.toString().equals(s2.toString());

        // Cach 3
        String s1 = String.join("",word1);
        String s2 = String.join("",word2);
        return s1.equals(s2);
    }
}
