package billing;

import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class BillingRunTest {

    private BillingRun billingRun;

    @Before
    public void setUp() {
        billingRun = new BillingRun();
    }

    @Test
    public void arthursCarsWithNoProducts() {
        String[] products = {};
        Dealer dealer = new Dealer("Arthur's Cars", 20, products);

        Map<String, Bill> bills = billingRun.generateBill(dealer);
        Bill arthursBill = bills.get(dealer.name);

        assertThat(bills).containsKey("Arthur's Cars");
        assertThat(arthursBill.getAmount()).isEqualTo(1000);
    }

    @Test
    public void superCarMarketWithNoProducts() {
        String[] products = {};
        Dealer dealer = new Dealer("Super Car Market", 1000, products);

        Map<String, Bill> bills = billingRun.generateBill(dealer);
        Bill superCarMarketBill = bills.get(dealer.name);

        assertThat(bills).containsKey("Super Car Market");
        assertThat(superCarMarketBill.getAmount()).isEqualTo(50000);
    }

    @Test
    public void arthursCarsWithProducts() {
        String[] products = {"Advert Promotions"};
        Dealer dealer = new Dealer("Arthur's cars", 20, products);

        Map<String, Bill> bills = billingRun.generateBill(dealer);
        Bill arthursBill = bills.get(dealer.name);

        assertThat(bills).containsKey("Arthur's cars");
        assertThat(arthursBill.getAmount()).isEqualTo(1200);
    }

    @Test
    public void superCarMarketWithProducts() {
        String[] products = {"Finance", "valuations"};
        Dealer dealer = new Dealer("Super Car Market", 1000, products);

        Map<String, Bill> bills = billingRun.generateBill(dealer);
        Bill superCarMarketBill = bills.get(dealer.name);

        assertThat(bills).containsKey("Super Car Market");
        assertThat(superCarMarketBill.getAmount()).isEqualTo(70000);
    }

    @Test
    public void derekWithNoProducts() {
        String[] products = {};
        PrivateSeller privateSeller = new PrivateSeller("Derek", 3, products);

        Map<String, Bill> bills = billingRun.generateBill(privateSeller);

        Bill derekBill = bills.get(privateSeller.name);

        assertThat(derekBill.getAmount()).isEqualTo(60);
    }

    @Test
    public void sarahWithProducts() {
        String[] products = {"100 images"};
        PrivateSeller privateSeller = new PrivateSeller("Sarah", 1, products);

        Map<String, Bill> bills = billingRun.generateBill(privateSeller);

        Bill sarahBill = bills.get(privateSeller.name);

        assertThat(sarahBill.getAmount()).isEqualTo(30);
    }
}