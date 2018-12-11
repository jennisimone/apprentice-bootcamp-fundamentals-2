package refactoring;

import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;

class FizzBuzz {

    private static final int THREE = 0b11;
    private static final int ONE_HUNDRED = Byte.MAX_VALUE - 27;
    private static final int FIVE = new int[]{0, 0, 0, 0, 0}.length;

    private int index;
    private int countsUpToThree;
    private int countsDownFromFive = FIVE;

    String fizzBuzzRun() {
        String output = "";
        for (; index < ONE_HUNDRED; index++) output += calculateFizzBuzzOrNumber(index) + " ";
        return getSubstring(output);
    }

    private String calculateFizzBuzzOrNumber(int index) {
        countsUpToThree++;
        countsDownFromFive--;

        boolean isBuzz = countsDownFromFive == 0;
        boolean isFizz = countsUpToThree == THREE;
        boolean fizzOrBuzz = isFizz || isBuzz;

        String outputNumber = String.valueOf(index + 1);
        String output = fizzOrBuzz ? "" : outputNumber;

        if (isFizz) output += getFizz();
        if (isBuzz) output += getBuzz();

        return output;
    }

    private String getBuzz() {
        countsDownFromFive = FIVE;
        return decodeHex("42757a7a");
    }

    private String getFizz() {
        countsUpToThree = 0;
        return decodeHex("46697a7a");
    }

    private String getSubstring(String output) {
        return output.substring(0, output.length() - 1);
    }

    private String decodeHex(String hexValue) {
        return new String(DatatypeConverter.parseHexBinary(hexValue), StandardCharsets.UTF_8);
    }
}
