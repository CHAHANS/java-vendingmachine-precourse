package vendingmachine.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import vendingmachine.Coin;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class CoinGeneratorTest {

    @DisplayName("랜덤 코인생성 테스트")
    @ParameterizedTest
    @ValueSource(ints = {450,500,700,800})
    void coinRandomGenerateTest(int userInput) {
        CoinGenerator cg = new CoinGenerator();
        Map<Integer, Integer> newCoins = cg.getRandomCoins(userInput);
        int sum = 0;
        for (Integer nowKey : newCoins.keySet()) {
            sum += nowKey * newCoins.get(nowKey);
        }
        assertThat(sum).isEqualTo(userInput);
    }

}