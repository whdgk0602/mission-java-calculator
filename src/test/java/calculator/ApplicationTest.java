package calculator;

import calculator.model.calclulatorModel;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ApplicationTest extends NsTest {

    private final calclulatorModel model = new calclulatorModel();

    @Test
    void testBasicDelimiters() {
        assertEquals(6, model.calculator("1,2:3"));
    }

    @Test
    void testSingleNumber() {
        assertEquals(5, model.calculator("5"));
    }

    @Test
    void testCustomDelimiterSemicolon() {
        assertEquals(12, model.calculator("//;\n3;4:5"));
    }

    @Test
    void testCustomDelimiterSymbols() {
        assertEquals(12, model.calculator("//^&\n3^4&5"));
    }

    @Test
    void testCustomDelimiterBackslash() {
        assertEquals(12, model.calculator("//\\\n3\\4\\5"));
    }
    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
