package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InputViewTest {

    @DisplayName("입력한 다리 길이가 유효하지 않을 때 예외를 발생시키는지 검사한다.")
    @ParameterizedTest
    @ValueSource(strings = {"a", "1", "21", "ab"})
    void invalidBridgeLengthInput(String bridgeLength) {
        InputView inputView = new InputView();
        assertThatThrownBy(() -> inputView.validateBridgeSizeInput(bridgeLength))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력한 다리 길이가 유효할 때 그 결과값이 3 이상 20 이하의 정수인지 확인한다.")
    @ParameterizedTest
    @ValueSource(strings = {"3", "20", "15"})
    void validBridgeLengthInput(String bridgeLength) {
        InputView inputView = new InputView();
        int validBridgeLength = inputView.validateBridgeSizeInput(bridgeLength);
        assertTrue(validBridgeLength >= 3 || validBridgeLength <= 20);
    }

    @DisplayName("입력한 이동 커맨드가 유효하지 않을 때 예외를 발생시키는지 검사한다.")
    @ParameterizedTest
    @ValueSource(strings = {"u", "d", "3", "a"})
    void invalidMoveCommandInput(String moveCommand) {
        InputView inputView = new InputView();
        assertThatThrownBy(() -> inputView.validateMoveCommand(moveCommand))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력한 이동 커맨드가 유효할 때 그 결과값도 U 혹은 D 인지 확인한다.")
    @ParameterizedTest
    @ValueSource(strings = {"U", "D"})
    void validMoveCommand(String moveCommand) {
        InputView inputView = new InputView();
        String validMoveCommand = inputView.validateMoveCommand(moveCommand);
        assertTrue(validMoveCommand.equals("U")
                || validMoveCommand.equals("D"));
    }

    @DisplayName("입력한 게임 커맨드가 유효하지 않을 때 예외를 발생시키는지 검사한다.")
    @ParameterizedTest
    @ValueSource(strings = {"r", "q", "3", "a"})
    void invalidGameCommandInput(String gameCommand) {
        InputView inputView = new InputView();
        assertThatThrownBy(() -> inputView.validateMoveCommand(gameCommand))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력한 게임 커맨드가 유효할 때 그 결과값도 R 혹은 Q 인지 확인한다.")
    @ParameterizedTest
    @ValueSource(strings = {"R", "Q"})
    void validGameCommand(String gameCommand) {
        InputView inputView = new InputView();
        String validateGameCommand = inputView.validateGameCommand(gameCommand);
        assertTrue(validateGameCommand.equals("R")
                || validateGameCommand.equals("Q"));
    }

}
