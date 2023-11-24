package vendingmachine.domain;

import vendingmachine.Coin;
import vendingmachine.util.NumberGenerator;

import java.util.HashMap;
import java.util.Map;


public class Machine {
    private Map<Integer, Integer> nowCoin;
    private Map<String, Product> nowProduct;
    private int wallet;

    public Machine() {
        this.nowCoin = new HashMap<>();
        this.nowProduct = new HashMap<>();
    }

    public void addProduct(String productsName, int price, int EA) {
        Product newProduct = new Product(productsName, price, EA);
        nowProduct.put(productsName, newProduct);
    }

    public void sellProduct(String product, int EA) {
        this.nowProduct.get(product).decreaseProduct(EA);
        this.wallet -= this.nowProduct.get(product).getPrice();
    }

    public void insertWallet(int number) {
        this.wallet += number;
    }

    public void setCoin(Map<Integer, Integer> newCoin) {
        this.nowCoin = newCoin;
    }

    public boolean buyAnyChecker() {
        int checker = 0;
        for (String productName : nowProduct.keySet()){
            int price = nowProduct.get(productName).getPrice();
            checker += wallet/price;
            }
        return checker!=0;
    }

    public void decreaseCoin(int coin, int number) {
        int value = nowCoin.get(coin) - number;
        nowCoin.put(coin, value);
    }

    public int getWallet() {
        return wallet;
    }

    public Map<Integer, Integer> getNowCoin() {
        return nowCoin;
    }
}
