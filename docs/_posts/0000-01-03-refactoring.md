# Boot-camp
## Fundamentals 2
### Day Two

---

# Retro

Note: Retrospect on day one  
  What did you like  
  What didn’t you like?  

---

# Run all tests at each stage

Note: Observation from yesterday  
  Some of you are running one test each time  
  Run all tests to make sure you don’t introduce regressions  

---

# Refactoring

-[+] What is it?

Note:
  Explain we are covering refactoring as it’s part of TDD, and a necessary skill for next exercises 
  Ask for suggestions  

---

> “Code refactoring is the process of restructuring existing computer code—changing the factoring—without changing its external behavior.”—Wikipedia

Note: Highlight ‘without changing its external behaviour’  
  Changing nonfunctional properties of the code

---

# Refactoring vs Rewriting

What is the difference?

---

# Rewriting **can** change functionality

Note:
  Term refactoring often used to mean rewriting  
  Just terminology but important to be intentional  
  Rewriting can break functionality  
  Refactoring does not/should not  

---

# Why Refactor?

-[+] Improve maintainability
-[+] Make code easier to read
-[+] Make code easier to change

Note:
  Arguably readability is about maintainability  

---


# Stay green!

<background>green<background/>

-[+] Compilation errors and failing tests are a distraction
-[+] Generally refactoring doesn’t break tests / syntax
-[+] Less head scratching ten minutes later…

---

# What is a refactor?

Recognised technique by which you change some aspect of the code

---

# For example…

-[+] Rename
-[+] Extract variable
-[+] Extract field
-[+] Extract constant
-[+] Extract method/function
-[+] Inline method/function

---

## You currently do these things manually

(and slowly)

(and the code is broken while you do)

---

# IDE to the rescue

Leverage your IDE (e.g. IntelliJ) to perform the refactor for you
-[+] Safer
-[+] Quicker (once you practice)
-[+] Easier
-[+] Less distracting

Note:
  Explain that the IDE automates manual refactors  
  Renaming a method manually could involve thousands of changes  
  Avoids intermediate compilation failures  
  All this distracts from the functionality you were adding  

---

# Rename

-[+] Your go-to refactor!
-[+] Naming is hard, we get it wrong
-[+] Use it to improve meaning of code
-[+] Rename variables, methods, classes
-[+] Shift + F6 in IntelliJ (your IDE/keymap may vary)

---

# Example

Before:
```java
void scan(String sku) {
    if ("A".equals(sku)) {
```
After:
```java
void scan(String stockKeepingUnit) {
    if ("A".equals(stockKeepingUnit)) {
```

---

# Exercise

Rename all the things

Aim is to get comfortable with the rename refactor

* Do not break ThingyTest
* **ONLY** use rename
  *  Mac & Windows: ‘⇧ F6’
* Try to make it make more sense
* Rename stuff as you try to understand the code

Note:
  More important to get comfortable than finish  
  Ensure screen set up to live code when reviewing  
  IntelliJ in presentation mode on extension display  

---

# Review

* Did you improve the code?
-[+] What did you rename?  
  (live-code the suggestions…)

Note:
  Toggle between extended and mirrored with ‘⌘ F1’  

---

# Extract Variable

Extract part of a line into a variable (and other duplicate code)

-[+] Split long line of code into meaningful chunks
-[+] Can be used to remove duplication
-[+] Can make the variable name descriptive

---

# Example

Before:
```java
if (numberOfA % 3 == 0) {
    total -= 20;
}
```

After:
```java
final boolean numberOfAIsMultipleOf3 = numberOfA % 3 == 0;
if (numberOfAIsMultipleOf3) {
    total -= 20;
}
```

---

# Exercise

Extract all the variables

Aim is to get comfortable with the extract variable refactor

* Do not break ThingyTest
* **ONLY** use extract variable
  *  Mac: ‘⌥ ⌘ V’ (i.e. ‘option command V’)
  * Windows: ‘Ctrl Alt V’
* Try to make it make more sense

---

# Review

* Did you improve the code?
-[+] What variables did you extract?  
  (live-code the suggestions…)

Note:
  Toggle between extended and mirrored with ‘⌘ F1’  
  Apply refactors as suggested  

---

# Extract Constant

-[+] Remove ‘magic numbers’
-[+] Add meaning to values found in the code
-[+] Reduce duplication of values  
  (when they are intended to change at the same time)

---

# Example

Before:
```java
if (numberOfA % 3 == 0) {
    total -= 20;
}
```

After:
```java
if (numberOfA % 3 == 0) {
    total -= DISCOUNT_VALUE_A;
}
```

---

# Exercise

Extract all the constants

Aim is to get comfortable with the extract constant refactor

* Do not break ThingyTest
* **ONLY** use extract constant
  *  Mac: ‘⌥ ⌘ C’ (i.e. ‘option command C’)
  * Windows: ‘Ctrl Alt C’
* Try to make it make more sense

---

# Review

* Did you improve the code?
-[+] What constants did you extract?  
  (live-code the suggestions…)

Note: Toggle between extended and mirrored with ‘⌘ F1’  
  Apply refactors as suggested  
  Make sure you cover the binary / hex numbers,
  booleans for multiples  
  FIZZ, BUZZ etc

---

# Extract Method

-[+] Reduce duplication of blocks of code  

---

# Example

Before:
```java
    if ("A".equals(sku)) {
        numberOfA++;
        if (numberOfA % 3 == 0) {
            total -= 20;
        }
    } else if ("B".equals(sku)) {
        numberOfB++;
        if (numberOfB % 2 == 0) {
            total -= 15;
        }
    }
```

---

# Example

After:
```java
    if ("A".equals(sku)) {
      numberOfA++;
      discount(numberOfA, 3, 20);
    } else if ("B".equals(sku)) {
      numberOfB++;
      discount(numberOfB, 2, 15);
    }
```
```java
  private void discount(int quantity, int offerQuantity, int discount) {
    if (quantity % offerQuantity == 0) {
      total -= discount;
    }
  }

```

---

# Exercise

Extract some methods

Aim is to get comfortable with the extract method refactor

* Do not break ThingyTest
* **ONLY** use extract method
  *  Mac: ‘⌥ ⌘ M’ (i.e. ‘option command M’)
  * Windows: ‘Ctrl Alt M’
* Try to make it make more sense

---

# Review

* Did you improve the code?
-[+] What did you extract?  
  (live-code the suggestions…)

Note: Toggle between extended and mirrored with ‘⌘ F1’  
  Apply refactors as suggested  

---

# Inline

-[+] Replace a method/variable call with equivalent code
-[+] Opposite of extract method/variable
-[+] Use with caution
-[+] Useful when you want to move code between methods

---

# Example

Before:
```java
final boolean fizz = isFizz();
final boolean buzz = isBuzz();
String word = fizz || buzz ?"":String.valueOf(foo + 1);
if (fizz) word += FIZZ();
if (buzz) word += BUZZ();
```

After:
```java
String word = isFizz() || isBuzz() ?"":String.valueOf(foo + 1);
if (isFizz()) word += FIZZ();
if (isBuzz()) word += BUZZ();
```

---

# Uh-oh!

```text
org.junit.ComparisonFailure: 
Expected :"1 2 Fizz 4 Buzz Fizz 7 8 Fizz Buzz 11 Fizz 13 14 FizzBuzz 16 17 Fizz 19 Buzz Fizz 22 23 Fizz Buzz 26 Fizz 28 29 FizzBuzz 31 32 Fizz 34 Buzz Fizz 37 38 Fizz Buzz 41 Fizz 43 44 FizzBuzz 46 47 Fizz 49 Buzz Fizz 52 53 Fizz Buzz 56 Fizz 58 59 FizzBuzz 61 62 Fizz 64 Buzz Fizz 67 68 Fizz Buzz 71 Fizz 73 74 FizzBuzz 76 77 Fizz 79 Buzz Fizz 82 83 Fizz Buzz 86 Fizz 88 89 FizzBuzz 91 92 Fizz 94 Buzz Fizz 97 98 Fizz Buzz"
Actual   :"1  3Buzz 4 5  7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 97 98 99 100"
```
-[+] 🚨 ALERT! Method does two things! 🚨
  ```
  private boolean isFizz() {
      countsUp++;
      countsDown--;
      return 
        countsUp == countsDown;
  }
  ```

Note: This actually broke the tests  
  Careful with your refactors  
  Code can have side effects  
  Need to run tests each time  
  Can fix this but that’s for another time  