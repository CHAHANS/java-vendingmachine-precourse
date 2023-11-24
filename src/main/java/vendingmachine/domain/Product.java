package vendingmachine.domain;

public class Product {
    private final String name;
    private final int price;
    private int EA;
    public Product(String name, int price, int EA) {
        this.name = name;
        validatePrice(price);
        this.price = price;
        this.EA = EA;
    }

    public void decreaseProduct(int number){
        this.EA -= number;
    }

    private void validatePrice(int price) {
        if(!(price>=100)) {
            throw new IllegalArgumentException();
        }
        if(price%10!=0) {
            throw new IllegalArgumentException();
        }
    }

    public int getPrice() {
        return price;
    }
}
