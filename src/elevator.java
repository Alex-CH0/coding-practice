import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class elevator {

    private final int MAX_WEIGHT = 100;

    private final int MIN_FLOOR = -3;

    private final int MAX_FLOOR = 10;

    private int[] requestSituation;

    private Queue<Integer> floorQueue;

    public void initSituation() {
        this.requestSituation = new int[Math.abs(MIN_FLOOR) + MAX_FLOOR];
        Arrays.fill(requestSituation, 0);

        this.floorQueue = new LinkedList<>();
    }

    public Queue<Integer> inspectSituation(int[] requestSituation, int currentFloor) {
        int currentIndex = this.convertFloorToIndex(currentFloor);

        // 올라간다.
        for (int i = currentIndex; i < requestSituation.length; i++) {
            if(requestSituation[i] == 1)
                floorQueue.add(i);
        }
    }

    public int convertFloorToIndex(int floor) {
        return floor < 0 ? floor + 3 : floor + 2;
    }

    public void addRequest(int floor, boolean isGoingUp) {
        int floorIndex = this.convertFloorToIndex(floor);
        this.requestSituation[floorIndex] = isGoingUp ? 1 : 2;
    }
}
