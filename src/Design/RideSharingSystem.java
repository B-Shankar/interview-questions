package Design;

import java.util.*;

public class RideSharingSystem {

    private LinkedHashSet<Integer> riders = new LinkedHashSet<>();
    private Queue<Integer> drivers = new LinkedList<>();

    public RideSharingSystem() {}

    public void addRider(int riderId) {
        riders.add(riderId);
    }

    public void addDriver(int driverId) {
        drivers.offer(driverId);
    }

    public int[] matchDriverWithRider() {

        if (riders.isEmpty() || drivers.isEmpty()) {
            return new int[]{-1, -1};
        }

        int rider = riders.iterator().next(); // earliest rider
        riders.remove(rider);

        int driver = drivers.poll();

        return new int[]{driver, rider};
    }

    public void cancelRider(int riderId) {
        riders.remove(riderId); // only removes if currently waiting
    }
}

/**
 * Your RideSharingSystem object will be instantiated and called as such:
 * RideSharingSystem obj = new RideSharingSystem();
 * obj.addRider(riderId);
 * obj.addDriver(driverId);
 * int[] param_3 = obj.matchDriverWithRider();
 * obj.cancelRider(riderId);
 */
