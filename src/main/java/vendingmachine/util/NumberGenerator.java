package vendingmachine.util;

import java.util.Random;

public class NumberGenerator {
    private final Random random;

    public NumberGenerator() {
        this.random = new Random();
    }

    public int getRandomNumber(int Max) {
        return random.nextInt(Max+1);
    }
}