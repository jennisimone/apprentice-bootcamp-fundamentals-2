package checkout;

class Receipt {

    private String text = "";
    private int numberOfA = 0;
    private int numberOfB = 0;
    private int numberOfC = 0;
    private int numberOfD = 0;
    private int total;

    String text() {
        return text + "Total: " + total;
    }

    void scannedA() {
        scannedItem("A", 50, ++numberOfA, 5, 220);
    }

    void scannedB() {
        scannedItem("B", 30, ++numberOfB, 2, 45);
    }

    void scannedC() {
        scannedItem("C", 20, ++numberOfC, 4, 70);
    }

    void scannedD() {
        scannedItem("D", 15, ++numberOfD, 5, 60);
    }

    private void scannedItem(String itemName, int price, int numberScanned, int numberOfItems, int discountedAmount) {
        int discount =  price * numberOfItems - discountedAmount;
        text += itemName + ": " + price;
        if (numberScanned % numberOfItems == 0) {
            text += " - " + discount + " (" + numberOfItems + " for " + discountedAmount + ")";
            this.total -= discount;
        }
        total += price;
        text += "\n";
    }
}
