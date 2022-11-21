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
     * Adds user's guess to result list
     * @param answer actual bridge answer element
     * @param userMoveCommand user's guess (move command)
     * @return "O" or "X" according to the {@link Result#calculateResult(String, String)}
     */
    public String move(String answer, String userMoveCommand) {
        String result = this.result.calculateResult(answer, userMoveCommand);
        this.result.addResult(userMoveCommand, result);
        return result;
    }

    /**
     * Increase attempt count and re-runs the guessing process
     */
    public void retry() {
        attempts++;
        this.result.clearResult();
        play();
    }

    /**
     * Prints final result and stops the game
     * @param isSuccess whether user has succeeded in guessing the bridge
     */
    public void quit(boolean isSuccess) {
        manager.finalResult(this.result, isSuccess, attempts);
    }

    /**
     * Generates bridge answer and starts the game
     */
    public void start() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
        this.bridgeAnswer = manager.generateBridgeAnswer();
        play();
    }

    /**
     * In case of wrong guess, retries or quits the game according to user's game command
     */
    private void wrongGuess() {
        if (manager.getValidatedGameCommand().equals("R")) {
            retry();
            return;
        }
        quit(false);
    }

    /**
     * Plays the game
     * <p>
     * Repeats getting move command input and printing results
     */
    public void play() {
        for (String answer : bridgeAnswer) {
            String moveCommand = manager.getValidatedMoveCommand();
            String result = move(answer, moveCommand);
            manager.guessResult(this.result);

            if (result.equals("X")) {
                wrongGuess();
                return;
            }
        }
        quit(true);
    }
}
