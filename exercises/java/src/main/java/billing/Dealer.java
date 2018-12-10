package billing;

public class Dealer {
    String name;
    int stockLevel;
    String[] product;
    private int price;

    public Dealer(String name, int stockLevel, String[] product) {
        this.name = name;
        this.stockLevel = stockLevel;
        this.product = product;
    }

    Bill billing(Dealer dealer) {
        price = (dealer.stockLevel * 50) + ((dealer.product.length * 10) * dealer.stockLevel);
        return new Bill(price);
    }
}
