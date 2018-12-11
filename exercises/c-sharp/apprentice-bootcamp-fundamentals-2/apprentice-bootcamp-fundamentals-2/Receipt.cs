namespace apprentice_bootcamp_fundamentals_2 {
  using System;

  public class Receipt {
    private string _text = String.Empty;
    private int _total;
    private int _numberOfA;
    private int _numberOfB;

    public string Text {
      get => $"{this._text}Total: {this._total}";
    }

    public void ScannedA() {
      this._text = $"{this._text}A: 50";
      this._numberOfA++;
      this._total += 50;
      if (this._numberOfA % 3 == 0) {
        this._text = $"{this._text} - 20 (3 for 130)";
        this._total -= 20;
      }
      this._text = $"{this._text}\n";
    }

    public void ScannedB() {
      this._text = $"{this._text}B: 30";
      this._total += 30;
      this._numberOfB++;
      if (this._numberOfB % 2 == 0) {
        this._text = $"{this._text} - 15 (2 for 45)";
        this._total -= 15;
      }
      this._text = $"{this._text}\n";
    }

    public void ScannedC() {
      this._text = $"{this._text}C: 20\n";
      this._total += 20;
    }

    public void ScannedD() {
      this._text = $"{this._text}D: 15\n";
      this._total += 15;
    }
  }
}