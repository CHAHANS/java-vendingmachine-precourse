package vendingmachine.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SplitterTest {
    private static Splitter splitter;


    @BeforeEach
    void setUp() {
        this.splitter = new Splitter();
    }

    @Test
    void splitProducts() {
        String inputs = "[콜라,1500,20];[사이다,1000,10]";
        List<String> expect = new ArrayList<>();
        expect.add("[콜라,1500,20]");
        expect.add("[사이다,1000,10]");
        String[] actual = splitter.splitProducts(inputs);
        for (int i = 0; i<expect.size(); i++) {
            assertThat(actual[i].toString()).isEqualTo(expect.get(i).toString());
        }

    }

    @Test
    void splitValues() {
    }

    @Test
    void productCoverRemove() {
        List<String> expect = new ArrayList<>();
        expect.add("[콜라,1500,20]");
        expect.add("[사이다,1000,10]");
        for (int i = 0; i<expect.size(); i++) {
            String actual = splitter.productCoverRemove(expect.get(i));
            assertThat(actual).doesNotContain("[","]");
        }



    }
}