namespace McrDigital.Bootcamp1.Checkout.Tests {
using System;
using apprentice_bootcamp_fundamentals_2;
using NUnit.Framework;
  
  
  [TestFixture]
  public class ReceiptTests {
    [Test]
    public void SingleItem() {
      var checkout = new Checkout();
      checkout.Scan("A");
      Assert.That(checkout.Receipt.Split("\n"), Is.EqualTo(new string[] {
        "A: 50",
        "Total: 50"
      }) );
    }

    [Test]
    public void OneOfEach() {
      var checkout = new Checkout();

      checkout.Scan("A");
      checkout.Scan("B");
      checkout.Scan("C");
      checkout.Scan("D");

      Assert.That(checkout.Receipt.Split("\n"), Is.EqualTo(new string[] {
        "A: 50",
        "B: 30",
        "C: 20",
        "D: 15",
        "Total: 115"
      } ));
    }

    [Test]
    public void Offers() {
      var checkout = new Checkout();

      checkout.Scan("A");
      checkout.Scan("A");
      checkout.Scan("B");
      checkout.Scan("A");
      checkout.Scan("C");
      checkout.Scan("D");
      checkout.Scan("B");

      Assert.That( checkout.Receipt.Split("\n"), Is.EqualTo(new string[] {
        "A: 50",
        "A: 50",
        "B: 30",
        "A: 50 - 20 (3 for 130)",
        "C: 20",
        "D: 15",
        "B: 30 - 15 (2 for 45)",
        "Total: 210"
      }));
    }
  }
}