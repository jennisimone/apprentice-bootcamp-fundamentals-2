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
            total += 50;
            if (++numberOfA % 5 == 0) {
                total -= 30;
            }
            receipt.scannedA();
        } else if ("B".equals(sku)) {
            total += 30;
            if (++numberOfB % 2 == 0) {
                total -= 15;
            }
            receipt.scannedB();
        } else if ("C".equals(sku)) {
            total += 20;
            if (++numberOfC % 4 == 0) {
                total -= 10;
            }
            receipt.scannedC();
        } else if ("D".equals(sku)) {
            total += 15;
            if (++numberOfD % 5 == 0) {
                total -= 15;
            }
            receipt.scannedD();
        }
    }

    int total() {
        return total;
    }

    String receipt() {
        return receipt.text();
    }
}
