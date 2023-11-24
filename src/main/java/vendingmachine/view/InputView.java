package vendingmachine.view;

import vendingmachine.util.Splitter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private final Splitter splitter;
    public InputView() {
        this.splitter = new Splitter();
    }
    public List<String> userInputProductSetting() {
        String userInput = scanLine();
        List<String> initProducts = new ArrayList<>();
        for (String input : splitter.splitProducts(userInput)) {
            initProducts.add(splitter.productCoverRemove(input));
        }
        return initProducts;
    }

    public String userInputProduct() {
        String userInput = scanLine();
        return userInput;
    }

    public int userInputNumber() {
        String userInput = scanLine();
        return changeTypeNumber(userInput);
    }

    private String scanLine() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().trim();
    }

    private int changeTypeNumber(String input) throws IllegalArgumentException {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 검증되지 않은 수 : "+input, e);
        }
    }

}
