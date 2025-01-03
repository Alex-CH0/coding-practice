import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class StringManipulation {


    class Result {


        public static String biggerIsGreater(String w) {
            // Write your code here
            if (w.length() == 1) {
                return "no answer";
            }
            List<Integer> indexList = new ArrayList<>();


            loop:
            for (int i = w.length() - 1; i > 0; i--) {
                int current = (int) w.charAt(i);
                for (int j = i - 1; j >= 0; j--) {
                    int next = (int) w.charAt(j);
                    if (next < current) {
                        indexList.add(i);
                        indexList.add(j);
                        break loop;
                    }
                }
            }
            System.out.println(indexList);
            if (indexList.isEmpty())
                return "no answer";
            char target1 = w.charAt(indexList.get(0));
            char target2 = w.charAt(indexList.get(1));
            char[] charArray = w.toCharArray();

            charArray[indexList.get(0)] = target2;
            charArray[indexList.get(1)] = target1;

            return String.valueOf(charArray);

        }

    }

    public class Solution {
        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            int T = Integer.parseInt(bufferedReader.readLine().trim());

            IntStream.range(0, T).forEach(TItr -> {
                try {
                    String w = bufferedReader.readLine();

                    String result = Result.biggerIsGreater(w);

                    bufferedWriter.write(result);
                    bufferedWriter.newLine();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });

            bufferedReader.close();
            bufferedWriter.close();
        }
    }

}
