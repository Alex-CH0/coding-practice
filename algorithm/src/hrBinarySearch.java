import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class hrBinarySearch {

    class NewResult {

        // 근데 이래도 Time out.
        // 해결법은 기존 Rank의 저장해두고 가까운 index에서 +-1

        private static Integer calculateRank(List<Integer> points, Integer playerPoint) {
            TreeSet<Integer> treeSet = new TreeSet<>(points);
            treeSet.add(playerPoint);
            List<Integer> newPoints = new ArrayList<>(treeSet.descendingSet());

            return newPoints.indexOf(playerPoint) + 1;

        }

        public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
            // Write your code here

            List<Integer> result = new ArrayList<>();

            for (Integer ind : player) {
                result.add(calculateRank(ranked, ind));

            }
            return result;

        }

    }


    class Result {

        // 이진 탐색으로 실시
        // 하지만 타임아웃으로  에러

        private static Integer calculateRank(List<Integer> points, Integer playerPoint) {
            List<Integer> newPoints = new ArrayList<>(new LinkedHashSet<>(points));

            return newPoints.indexOf(playerPoint) + 1;

        }

        public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {

            List<Integer> result = new ArrayList<>();
            // Write your code here
            for (Integer individual : player) {
                int leftIndex = 0;
                int rightIndex = ranked.size();
                int middleIndex = (leftIndex + rightIndex) / 2;
                int individualIndex;

                while (leftIndex < rightIndex) {
                    middleIndex = (leftIndex + rightIndex) / 2;
                    if (individual > ranked.get(middleIndex)) {
                        rightIndex = middleIndex;

                    } else {
                        leftIndex = middleIndex + 1;
                    }
                }
                if (individual > ranked.get(middleIndex)) {
                    if (middleIndex < 1) {
                        individualIndex = 0;
                    } else {
                        individualIndex = middleIndex;
                    }

                } else {
                    individualIndex = middleIndex + 1;
                }

                List<Integer> rankedCopy = new ArrayList<>(ranked);
                rankedCopy.add(individualIndex, individual);
                result.add(calculateRank(rankedCopy, individual));

            }

            return result;

        }

    }

    public class Solution {
        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            int rankedCount = Integer.parseInt(bufferedReader.readLine().trim());

            List<Integer> ranked = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

            int playerCount = Integer.parseInt(bufferedReader.readLine().trim());

            List<Integer> player = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

            List<Integer> result = Result.climbingLeaderboard(ranked, player);

            bufferedWriter.write(
                    result.stream()
                            .map(Object::toString)
                            .collect(joining("\n"))
                            + "\n"
            );

            bufferedReader.close();
            bufferedWriter.close();
        }
    }


}
