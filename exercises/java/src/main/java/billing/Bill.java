package billing;

public class Bill {

    private int price;

    public Bill(int price) {
        this.price = price;
    }

    public int getAmount() {
        return price;
    }
}
