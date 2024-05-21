package roomescape.member.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MemberEmailTest {
    @DisplayName("이메일 형식이 일치하지 않으면, 예외를 던진다.")
    @ParameterizedTest
    @CsvSource({"abc@acac", "acac.com", "avd@@ac.com"})
    void validateTest_whenFormatNotMatch(String email) {
        assertThatThrownBy(() -> new MemberEmail(email))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이메일 형식이 일치하지 않습니다.");
    }

    @DisplayName("이메일 형식이 일치하지 않으면, 예외를 던진다.")
    @ParameterizedTest
    @CsvSource({"abc@acac.com", "ac@ac.com", "asd@kw.ac.kr"})
    void validateTest(String email) {
        assertThatCode(() -> new MemberEmail(email))
                .doesNotThrowAnyException();
    }
}
