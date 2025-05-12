package calculator.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorModelTest  {
    private final calclulatorModel model = new calclulatorModel();

    @Test
    @DisplayName("기본 구분자로 계산")
    void calculateWithDefaultDelimiters() {
        assertEquals(6, model.calculator("1,2:3"));
    }

    @Test
    @DisplayName("커스텀 구분자로 계산")
    void calculateWithCustomSemicolon() {
        assertEquals(6, model.calculator("//;\n1;2;3"));
    }

    @Test
    @DisplayName("커스텀 구분자로 계산")
    void calculateWithCustomDot() {
        assertEquals(15, model.calculator("//.\n4.5:6"));
    }

    @Test
    @DisplayName("커스텀 + 기본")
    void calculateWithCustomAndDefaultMix() {
        assertEquals(34, model.calculator("//|\n7|8,9:10"));
    }

    @Test
    @DisplayName("중복된 구분자")
    void throwExceptionForDuplicateSeparators() {
        assertThrows(IllegalArgumentException.class, () -> {
            model.calculator("1,,2:3");
        });
    }

    @Test
    @DisplayName("숫자가 아닌 문자 예외 발생")
    void throwExceptionForNonNumericInput() {
        assertThrows(IllegalArgumentException.class, () -> {
            model.calculator("1,a:3");
        });
    }
}
