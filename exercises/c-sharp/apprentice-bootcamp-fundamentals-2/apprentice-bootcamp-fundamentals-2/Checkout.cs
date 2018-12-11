namespace apprentice_bootcamp_fundamentals_2 {
  public class Checkout {
    private int _total;
    private int _numberOfA;
    private int _numberOfB;
    private Receipt _receipt = new Receipt();

    public string Receipt {
      get => this._receipt.Text;
    }

    public int Total {
      get => this._total;
    }

    public void Scan(string sku) {
      if ("A".Equals(sku)) {
        this._total += 50;
        this._receipt.ScannedA();
        this._numberOfA++;
        if (this._numberOfA % 3 == 0) {
          this._total -= 20;
        }
      } else if ("B".Equals(sku)) {
        this._total += 30;
        this._receipt.ScannedB();
        this._numberOfB++;
        if (this._numberOfB % 2 == 0) {
          this._total -= 15;
        }
      } else if ("C".Equals(sku)) {
        this._total += 20;
        this._receipt.ScannedC();
      } else if ("D".Equals(sku)) {
        this._total += 15;
        this._receipt.ScannedD();
      }

    }
  }
}