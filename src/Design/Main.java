package Design;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        RideSharingSystem system = new RideSharingSystem();

        system.addRider(3);
        system.addDriver(2);
        system.addRider(1);

        System.out.println(Arrays.toString(system.matchDriverWithRider())); // [2,3]

        system.addDriver(5);
        system.cancelRider(3);

        System.out.println(Arrays.toString(system.matchDriverWithRider())); // [5,1]
        System.out.println(Arrays.toString(system.matchDriverWithRider())); // [-1,-1]
    }
}
