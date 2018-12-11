package checkout;

class Checkout {
    private int total;
    private int numberOfA = 0;
    private int numberOfB = 0;
    private int numberOfC = 0;
    private int numberOfD = 0;
    private Receipt receipt = new Receipt();

    void scan(String sku) {
        if ("A".equals(sku)) {
            scanItem(50, ++numberOfA, 5, 30);
            receipt.scannedA();
        } else if ("B".equals(sku)) {
            scanItem(30, ++numberOfB, 2, 15);
            receipt.scannedB();
        } else if ("C".equals(sku)) {
            scanItem(20, ++numberOfC, 4, 10);
            receipt.scannedC();
        } else if ("D".equals(sku)) {
            scanItem(15, ++numberOfD, 5, 15);
            receipt.scannedD();
        }
    }

    int total() {
        return total;
    }

    String receipt() {
        return receipt.text();
    }

    private void scanItem(int price, int numberScanned, int discountQuantity, int discountValue) {
        total += price;
        if (numberScanned % discountQuantity == 0) {
            total -= discountValue;
        }
    }
}
