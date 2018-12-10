package billing;

import java.util.HashMap;
import java.util.Map;

public class BillingRun {

    Dealer dealer;
    Bill bill;

    public Map<String, Bill> generateBill(Dealer... dealers) {

        Map<String, Bill> getAllBills = new HashMap<>();

        for (Dealer dealer: dealers) {
            getAllBills.put(dealer.name, dealer.billing(dealer));
        }

        return getAllBills;
    }

    public Map<String, Bill> generateBill(PrivateSeller... privateSellers) {
        Map<String, Bill> getAllBills = new HashMap<>();

        for (PrivateSeller privateSeller : privateSellers) {
            getAllBills.put(privateSeller.name, privateSeller.billing(privateSeller));
        }

        return getAllBills;
    }
}
