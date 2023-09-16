import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Plus_Minus {
    class Result {

        /*
         * Complete the 'plusMinus' function below.
         *
         * The function accepts INTEGER_ARRAY arr as parameter.
         */

        public static void plusMinus(List<Integer> arr) {
            // Write your code here
            int n = arr.size();
            int pos = 0;
            int neg = 0;
            int zr = 0;
            for (int i = 0; i < n; i++) {
                if (arr.get(i) > 0) {
                    pos++;
                }
                else if (arr.get(i) < 0) {
                    neg++;
                }
                else {
                    zr++;
                }
            }

            float posFraction = (float) pos/ (float) n;
            float negFraction = (float) neg/ (float) n;
            float zrFraction = (float) zr / (float) n;

            DecimalFormat decimalFormat = new DecimalFormat("#.######");
            String formatPosFraction = decimalFormat.format(posFraction);
            String formatNegFraction = decimalFormat.format(negFraction);
            String formatZrFraction = decimalFormat.format(zrFraction);

            System.out.println(formatPosFraction);
            System.out.println(formatNegFraction);
            System.out.println(formatZrFraction);
        }

    }

    public class Solution {
        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            int n = Integer.parseInt(bufferedReader.readLine().trim());

            List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

            Result.plusMinus(arr);

            bufferedReader.close();
        }
    }
}
