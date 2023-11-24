package vendingmachine.util;

public class Splitter {
    private static final String productSplitter = ";";
    private static final String productCoverRemover = "[\\[\\]]";
    private static final String valueSplitter = ",";
    public String[] splitProducts(String input) {
        return input.split(productSplitter);
    }

    public String[] splitValues(String input) {
        return input.split(valueSplitter);
    }

    public String productCoverRemove (String input) {
        return input.replaceAll(productCoverRemover, "");
    }

}
