package vendingmachine.domain;

import vendingmachine.Coin;
import vendingmachine.util.NumberGenerator;

import java.util.HashMap;
import java.util.Map;

public class CoinGenerator {
    private NumberGenerator numberGenerator;
    private Map<Integer, Integer> newCoins;

    public CoinGenerator() {
        this.numberGenerator = new NumberGenerator();
        this.newCoins = new HashMap<>();
        for (Coin coin : Coin.values()) {
            newCoins.put(coin.getAmount(), 0);
        }
    }

    public Map<Integer, Integer> getRandomCoins(int number) {
        boolean isValid = false;

        while (!isValid) {
            for (Coin coin : Coin.values()) {
                int nowAmount = coin.getAmount();
                int result = 0;
                if (number >= nowAmount) {
                    int max = number / nowAmount;
                    result = numberGenerator.getRandomNumber(max);
                    number -= result * nowAmount;
                }
                newCoins.put(nowAmount, newCoins.get(nowAmount) + result);
            }
            if (number == 0) {
                isValid = true;
            }
        }

        return newCoins;
    }
}
