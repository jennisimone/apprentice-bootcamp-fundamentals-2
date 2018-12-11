package refactoring;

import org.junit.Test;

import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.*;

public class FizzBuzzTest {

    @Test
    public void itWorks() {
        assertThat(new FizzBuzz().fizzBuzzRun()).isEqualTo(new String(
                DatatypeConverter.parseHexBinary(
                        "3120322046697a7a20342042757a7a2046697a7a203720382046697a7a2042757a7a203131" +
                                "2046697a7a2031332031342046697a7a42757a7a2031362031372046697a7a2031392042757a7a204669" +
                                "7a7a2032322032332046697a7a2042757a7a2032362046697a7a2032382032392046697a7a42757a7a20" +
                                "33312033322046697a7a2033342042757a7a2046697a7a2033372033382046697a7a2042757a7a203431" +
                                "2046697a7a2034332034342046697a7a42757a7a2034362034372046697a7a2034392042757a7a204669" +
                                "7a7a2035322035332046697a7a2042757a7a2035362046697a7a2035382035392046697a7a42757a7a20" +
                                "36312036322046697a7a2036342042757a7a2046697a7a2036372036382046697a7a2042757a7a203731" +
                                "2046697a7a2037332037342046697a7a42757a7a2037362037372046697a7a2037392042757a7a204669" +
                                "7a7a2038322038332046697a7a2042757a7a2038362046697a7a2038382038392046697a7a42757a7a20" +
                                "39312039322046697a7a2039342042757a7a2046697a7a2039372039382046697a7a2042757a7a"
                ), StandardCharsets.UTF_8));
    }
}
