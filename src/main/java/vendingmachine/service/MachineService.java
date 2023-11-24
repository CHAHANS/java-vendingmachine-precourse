package vendingmachine.service;

import vendingmachine.Coin;
import vendingmachine.domain.CoinGenerator;
import vendingmachine.domain.Machine;
import vendingmachine.util.Splitter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MachineService {
    private Machine machine;
    public MachineService() {
        this.machine = new Machine();
    }

    public void initMachine(int coin) {
        CoinGenerator coinGenerator = new CoinGenerator();
        machine.setCoin(coinGenerator.getRandomCoins(coin));
    }

    public void addProducts(List<String> products ) {
        Splitter splitter = new Splitter();
        // 콜라,1500,20
        for (String input : products) {
            String[] values = splitter.splitValues(input);
            String name = values[0];
            int price = Integer.parseInt(values[1]);
            int EA = Integer.parseInt(values[2]);
            machine.addProduct(name, price, EA);
        }
    }

    public void addPay(int pay) {
        machine.insertWallet(pay);
    }

    public void selling(String productName) {
        machine.sellProduct(productName, 1);
    }

    public Map<Integer,Integer> giveChange() {
        Map<Integer,Integer> nowCoins = machine.getNowCoin();
        Map<Integer,Integer> ChangeCoins = new HashMap<>();
        int nowWallet = machine.getWallet();
        for (Coin coin : Coin.values()) {
            //enum 순서상 500부터임
            int thisCoin = coin.getAmount();
            int result = nowWallet/thisCoin;
            if (result!=0) {
                ChangeCoins.put(thisCoin,result);
                machine.decreaseCoin(thisCoin, result);
            }
        }
        return ChangeCoins;
    }

    public Machine getMachine() {
        return machine;
    }

    public Map<Integer,Integer> getMachineCoin() {
        return machine.getNowCoin();
    }
}