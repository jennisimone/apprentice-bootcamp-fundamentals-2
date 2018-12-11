package checkout;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class CheckoutTests {

    @Test
    public void oneA() {
        Checkout checkout = new Checkout();

        checkout.scan("A");
        assertThat(checkout.total()).isEqualTo(50);
    }

    @Test
    public void twoA() {
        Checkout checkout = new Checkout();

        checkout.scan("A");
        checkout.scan("A");
        assertThat(checkout.total()).isEqualTo(100);
    }

    @Test
    public void threeA() {
        Checkout checkout = new Checkout();

        checkout.scan("A");
        checkout.scan("A");
        checkout.scan("A");
        assertThat(checkout.total()).isEqualTo(150);
    }

    @Test
    public void fiveA() {
        Checkout checkout = new Checkout();

        checkout.scan("A");
        checkout.scan("A");
        checkout.scan("A");
        checkout.scan("A");
        checkout.scan("A");
        assertThat(checkout.total()).isEqualTo(220);
    }


    @Test
    public void sixA() {
        Checkout checkout = new Checkout();

        checkout.scan("A");
        checkout.scan("A");
        checkout.scan("A");
        checkout.scan("A");
        checkout.scan("A");
        checkout.scan("A");
        assertThat(checkout.total()).isEqualTo(270);
    }

    @Test
    public void oneB() {
        Checkout checkout = new Checkout();

        checkout.scan("B");
        assertThat(checkout.total()).isEqualTo(30);
    }

    @Test
    public void twoB() {
        Checkout checkout = new Checkout();

        checkout.scan("B");
        checkout.scan("B");
        assertThat(checkout.total()).isEqualTo(45);
    }

    @Test
    public void fourB() {
        Checkout checkout = new Checkout();

        checkout.scan("B");
        checkout.scan("B");
        checkout.scan("B");
        checkout.scan("B");
        assertThat(checkout.total()).isEqualTo(90);
    }

    @Test
    public void fourC() {
        Checkout checkout = new Checkout();

        checkout.scan("C");
        checkout.scan("C");
        checkout.scan("C");
        checkout.scan("C");
        assertThat(checkout.total()).isEqualTo(70);
    }

    @Test
    public void fiveD() {
        Checkout checkout = new Checkout();

        checkout.scan("D");
        checkout.scan("D");
        checkout.scan("D");
        checkout.scan("D");
        checkout.scan("D");
        assertThat(checkout.total()).isEqualTo(60);
    }

    @Test
    public void simple() {
        Checkout checkout = new Checkout();
        
        checkout.scan("A");
        assertThat(checkout.total()).isEqualTo( 50);
        
        checkout.scan("B");
        assertThat(checkout.total()).isEqualTo( 80);
        
        checkout.scan("C");
        assertThat(checkout.total()).isEqualTo(100);
        
        checkout.scan("D");
        assertThat(checkout.total()).isEqualTo(115);
    }

    @Test
    public void incremental() {
        Checkout checkout = new Checkout();
        
        checkout.scan("A");
        assertThat(checkout.total()).isEqualTo( 50);
        
        checkout.scan("B");
        assertThat(checkout.total()).isEqualTo( 80);
        
        checkout.scan("A");
        assertThat(checkout.total()).isEqualTo(130);
        
        checkout.scan("A");
        assertThat(checkout.total()).isEqualTo(180);
        
        checkout.scan("B");
        assertThat(checkout.total()).isEqualTo(195);
        
        checkout.scan("C");
        assertThat(checkout.total()).isEqualTo(215);
        
        checkout.scan("B");
        assertThat(checkout.total()).isEqualTo(245);
        
        checkout.scan("C");
        assertThat(checkout.total()).isEqualTo(265);
        
        checkout.scan("D");
        assertThat(checkout.total()).isEqualTo(280);
        
        checkout.scan("D");
        assertThat(checkout.total()).isEqualTo(295);
        
        checkout.scan("D");
        assertThat(checkout.total()).isEqualTo(310);
        
        checkout.scan("C");
        assertThat(checkout.total()).isEqualTo(330);
    }
}
