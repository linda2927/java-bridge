package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private List<String> bridgeAnswer;
    private int attempts;
    private final InputView inputView;
    private final OutputView outputView;

    public BridgeGame() {
        this.bridgeAnswer = new ArrayList<>();
        this.attempts = 0;
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    /**
     * Set bridge answer for BridgeGame instance
     */
    public void setBridgeAnswer() {
        int bridgeLength = 0;
        while (bridgeLength == 0) {
            try {
                bridgeLength = inputView.readBridgeSize();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.bridgeAnswer = bridgeMaker.makeBridge(bridgeLength);
    }

    /**
     * Compare user move command input and bridge answer
     * @param answer nth element of bridge answer
     * @param userMoveCommand user input of move command
     */
    public String calculateResult(String answer, String userMoveCommand) {
        if (answer.equals(userMoveCommand)) { return "O"; }
        return "X";
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     * @return "O" or "X" according to the {@link BridgeGame#calculateResult(String, String)}
     */
    public String move(String answer) {
        String moveCommand = "";
        try {
            moveCommand = this.inputView.readMoving();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        String result = calculateResult(answer, moveCommand);
        outputView.addAnswer(moveCommand, result);
        return result;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
