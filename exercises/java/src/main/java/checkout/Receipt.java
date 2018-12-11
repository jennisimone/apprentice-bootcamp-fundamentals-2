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
        text += "A: 50";
        if (++numberOfA % 5 == 0) {
            text += " - 30 (5 for 220)";
            total += 20;
        } else {
            total += 50;
        }
        text += "\n";
    }

    void scannedB() {
        text += "B: 30";
        if (++numberOfB % 2 == 0) {
            text += " - 15 (2 for 45)";
            total += 15;
        } else {
            total += 30;
        }
        text += "\n";
    }

    void scannedC() {
        text += "C: 20";
        if (++numberOfC % 4 == 0) {
            text += " - 10 (4 for 70)";
            total += 10;
        } else {
            total += 20;
        }
        text += "\n";
    }

    void scannedD() {
        text += "D: 15";
        if (++numberOfD % 5 == 0) {
            text += " - 15 (5 for 60)";
            total += 0;
        } else {
            total += 15;
        }
        text += "\n";
    }
}
