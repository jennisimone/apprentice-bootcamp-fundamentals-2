namespace UnitTests {
using System;
using apprentice_bootcamp_fundamentals_2;
using NUnit.Framework;
  
  [TestFixture]
  public class CheckoutTests {
    [Test]
    public void OneA() {
      var checkout = new Checkout();

      checkout.Scan("A");

      Assert.That(checkout.Total, Is.EqualTo(50));
    }

    [Test]
    public void TwoA() {
      var checkout = new Checkout();

      checkout.Scan("A");
      checkout.Scan("A");

      Assert.That(checkout.Total, Is.EqualTo(100));
    }

    [Test]
    public void ThreeA() {
      var checkout = new Checkout();

      checkout.Scan("A");
      checkout.Scan("A");
      checkout.Scan("A");

      Assert.That(checkout.Total, Is.EqualTo(130));
    }

    [Test]
    public void SixA() {
      var checkout = new Checkout();

      checkout.Scan("A");
      checkout.Scan("A");
      checkout.Scan("A");
      checkout.Scan("A");
      checkout.Scan("A");
      checkout.Scan("A");

      Assert.That(checkout.Total, Is.EqualTo(260));
    }
    [Test]
    public void OneB() {
      var checkout = new Checkout();

      checkout.Scan("B");

      Assert.That(checkout.Total, Is.EqualTo(30));
    }

    [Test]
    public void TwoB() {
      var checkout = new Checkout();

      checkout.Scan("B");
      checkout.Scan("B");

      Assert.That(checkout.Total, Is.EqualTo(45));
    }

    [Test]
    public void FourB() {
      var checkout = new Checkout();

      checkout.Scan("B");
      checkout.Scan("B");
      checkout.Scan("B");
      checkout.Scan("B");

      Assert.That(checkout.Total, Is.EqualTo(90));
    }

    [Test]
    public void Simple() {
      var checkout = new Checkout();

      checkout.Scan("A");
      Assert.That(checkout.Total, Is.EqualTo(50));

      checkout.Scan("B");
      Assert.That(checkout.Total, Is.EqualTo(80));

      checkout.Scan("C");
      Assert.That(checkout.Total, Is.EqualTo(100));

      checkout.Scan("D");
      Assert.That(checkout.Total, Is.EqualTo(115));
    }

    [Test]
    public void Incremental() {
      var checkout = new Checkout();

      checkout.Scan("A");
      Assert.That(checkout.Total, Is.EqualTo(50));
      
      checkout.Scan("B");
      Assert.That(checkout.Total, Is.EqualTo(80));
      
      checkout.Scan("A");
      Assert.That(checkout.Total, Is.EqualTo(130));
      
      checkout.Scan("A");
      Assert.That(checkout.Total, Is.EqualTo(160));
      
      checkout.Scan("B");
      Assert.That(checkout.Total, Is.EqualTo(175));
      
      checkout.Scan("C");
      Assert.That(checkout.Total, Is.EqualTo(195));
      
      checkout.Scan("B");
      Assert.That(checkout.Total, Is.EqualTo(225));
      
      checkout.Scan("C");
      Assert.That(checkout.Total, Is.EqualTo(245));
      
      checkout.Scan("D");
      Assert.That(checkout.Total, Is.EqualTo(260));
      
      checkout.Scan("D");
      Assert.That(checkout.Total, Is.EqualTo(275));
      
      checkout.Scan("D");
      Assert.That(checkout.Total, Is.EqualTo(290));
      
      checkout.Scan("C");
      Assert.That(checkout.Total, Is.EqualTo(310));
    }
  }
}
