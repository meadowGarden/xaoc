package playground;

import java.util.Random;

public class PlaygroundMain {
    public static void main(String[] args) {
        final Random random = new Random();
        final int r = random.nextInt(255, 256);
        final int g = random.nextInt(255, 256);
        final int b = random.nextInt(254, 256);
        System.out.printf("red: %d, greed: %d, blue: %d%n", r, g, b);
    }
}
