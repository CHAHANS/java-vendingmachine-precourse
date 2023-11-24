package vendingmachine.view;

import vendingmachine.Coin;
import vendingmachine.domain.Machine;

import java.util.Map;

public class OutputView {
    private static final String coinFormat = "%d원 - %d개";
    public void printNowCoin(Map<Integer, Integer> nowCoin) {
        System.out.println("자판기가 보유한 동전");
        for (Coin coin : Coin.values()) {
            System.out.printf(coinFormat, coin.getAmount(), nowCoin.get(coin.getAmount()));
            System.out.println();
        }
    }

    public void printChangeCoin(int Wallet, Map<Integer, Integer> nowCoin) {
        System.out.println("투입 금액: "+Wallet+"원");
        System.out.println("잔돈");
        for (Coin coin : Coin.values()) {
            System.out.printf(coinFormat, coin.getAmount(), nowCoin.get(coin.getAmount()));
            System.out.println();
        }
    }
}
