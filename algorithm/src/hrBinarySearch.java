import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class hrBinarySearch {


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


}
