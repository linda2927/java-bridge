package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class ResultTest {

    @DisplayName("유저가 입력한 정답과 실제 정답을 비교하여 그 결과를 제대로 저장하는지 검사한다.")
    @Test
    void addGuessResult() {

        List<String> mockBridgeAnswer = new ArrayList<>(List.of("U", "D", "U"));
        List<String> userMoveCommand = new ArrayList<>(List.of("U", "D", "U"));
        Result result = new Result();
        for (int i = 0; i < mockBridgeAnswer.size(); i++) {
            String calculatedResult = result.calculateResult(mockBridgeAnswer.get(i), userMoveCommand.get(i));
            result.addResult(userMoveCommand.get(i), calculatedResult);
        }

        assertThat(result.getUpperResult()).isEqualTo(new ArrayList<>(List.of("O", " ", "O")));
        assertThat(result.getLowerResult()).isEqualTo(new ArrayList<>(List.of(" ", "O", " ")));
    }
}
