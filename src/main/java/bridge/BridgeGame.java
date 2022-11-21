package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private List<String> bridgeAnswer;
    private int attempts;
    private final GameManager manager;

    private final Result result;

    public BridgeGame() {
        this.bridgeAnswer = new ArrayList<>();
        this.attempts = 1;
        this.manager = new GameManager();
        this.result = new Result();
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
     * Adds user's guess to result list
     * @param answer actual bridge answer element
     * @param userMoveCommand user's guess (move command)
     * @return "O" or "X" according to the {@link BridgeGame#calculateResult(String, String)}
     */
    public String move(String answer, String userMoveCommand) {
        String result = calculateResult(answer, userMoveCommand);
        this.result.addResult(userMoveCommand, result);
        return result;
    }

    /**
     * Increase attempt count and re-runs the guessing process
     */
    public void retry() {
        attempts++;
        this.result.clearAnswer();
        play();
    }

    /**
     * Prints final result and stops the game
     * @param isSuccess whether user has succeeded in guessing the bridge
     */
    public void quit(boolean isSuccess) {
        manager.finalResult(this.result, isSuccess, attempts);
    }

    public void play() {}
}
