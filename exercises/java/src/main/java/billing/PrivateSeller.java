package billing;

public class PrivateSeller {

    String name;
    int stockLevel;
    String[] product;
    private int price;

    public PrivateSeller(String name, int stockLevel, String[] product) {
        this.name = name;
        this.stockLevel = stockLevel;
        this.product = product;
    }

    Bill billing(PrivateSeller privateSeller) {
        price = (privateSeller.stockLevel * 20) + ((privateSeller.product.length * 10) * privateSeller.stockLevel);
        return new Bill(price);
    }
}
