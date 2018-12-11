# DRY

AKA Don’t Repeat Yourself
AKA Duplication / Repetition

Note: DRY is a principle telling us to avoid duplication in code  

---

“Every piece of knowledge must have a single, unambiguous, authoritative representation within a system.”
	-- The Pragmatic Programmer

---

# Duplication can be…

-[+] The exact same code in more than one place
-[+] Almost identical code in more than one place
-[+] The same String / Number in more than one place
-[+] Conditionals (ifs) using the same value in multiple places
-[+] Code represents knowledge—**repeated knowledge is duplication**

---

# Duplication is (usually) bad

It makes it hard to change code safely

-[+] Have to change tests in more than one place
-[+] Worse… you probably don’t have test coverage
-[+] May not realise you have to change something in many places

Note: Sometimes okay temporarily…  
  because in progress of refactoring  
  getting something working before you understand it  
  in tests?  

---

# Removing duplication can introduce coupling

Takes careful design to reduce duplication while avoiding coupling

---

# Can inheritance help?

-[+] Usually no
-[+] Certainly not until you have learned when not to
-[+] Inheritance by nature is highly coupled
-[+] Overuse is counter-productive to SOLID principles

Note: Discuss Inheritance vs. Composition (Boot camp 3)  
  Danger of Inheritance for code re-use  

---

# How to fix?

-[+] Values are easy
  -[+] Extract variable/field/constant
  -[+] Use caution not to break encapsulation/introduce coupling
  -[+] Sometimes duplicated values hide shared behaviour

---

# Continued…

-[+] De-duplicate behaviour by extracting and centralising methods
  -[+] Extract one method
  -[+] Move method to the correct location
    -[+] Might involve creating previously missing class
  -[+] Introduce parameters to facilitate other usages

---

# Alert: Some duplication is worse…

Duplication gets worse with distance

Note: Duplication better when code is cohesive  
  When code further apart hard to spot code that needs to change together 

---

# Why does duplication happen?

-[+] Copy & paste
-[+] Accidental duplication
-[+] Comments
-[+] Test names
-[+] Independent invention
-[+] Impatience

Note: It is usually unintentional  

---

# Exercise (20–30 mins)

Aim is to experience problems of duplication.  

Rules:

* Only change functionality with a failing test
* Run **all** tests after each change

-[+] Change Checkout so that 5 ‘A’ now cost 220  
  Be sure to check and update ReceiptTest.offers()
-[+] Extension: 4 ‘C’ for 70, 5 ‘D’ for 60

Note: Make sure they pair up  
  Ask them to note down duplication they find  
  No need to remove duplication this time  
  Consider skipping to review after 20 minutes  

---

# Review

-[+] What made that harder?
-[+] Did you change the amount of duplication?

Note: 
  Had to change 21 lines to make the change to A’s offer  
  First offer impacts three tests  
  Change to tests harder due to multiple assertions  
  Show them the change?  

---

```java
    void scannedA() {
        text += "A: 50";
        if (--aCountdown == 0) {
            text += " - 20 (3 for 130)";
            total += 30;
        }
        else {
            total += 50;
        }
        text += "\n";
    }
```
What duplication did we find?
-[+] Product names
-[+] Costs
-[+] Offer trigger & configuration
-[+] Formatting

Note: Names in methods, Strings, variables  
  Costs in text and also as part of offer  
  Offers algorithm duplicated within class and variant of it exists in Checkout (violates SRP)  

---

```java
    @Test
    public void offers() {
        Checkout checkout = new Checkout();
        checkout.scan("A");
        …
        checkout.scan("B");
        assertThat(checkout.receipt()).containsSequence(
                …
                "B: 30 - 15 (2 for 45)\n",
                "Total: 210");
    }
```

## What about in the tests?

-[+] Is the format of receipt duplicated?
-[+] Tests not necessarily duplication
-[+] Offers were tested twice

Note: Mention that tests are declarative, explain declarative  

---

# Exercise

Remove the duplication of the receipt format. You are free to improve the format, but remember that changes to the format will need to be reflected in the tests.

---

# Review

Before:
```java
            text += " - 20 (3 for 130)";
…
            text += " - 15 (2 for 45)";
```

After:
```java
  void printDiscount(int discountAmount, int numberOfItems, int priceOfItems) {
      this.text += String.format(
                      " - %s (%s for %s)",
                      discountAmount,
                      numberOfItems,
                      priceOfItems);
  }
```

Note: Demonstrate refactor if there’s time?  