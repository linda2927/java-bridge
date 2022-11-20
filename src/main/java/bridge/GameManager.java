package bridge;

import java.util.List;

/**
 * 게임 진행 시 input 과 output 을 관리하는 클래스
 */
public class GameManager {
    private final InputView inputView;
    private final OutputView outputView;

    public GameManager() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    /**
     * Get user input of bridge size and generate bridge answer
     * @return generated bridge answer
     */
    public List<String> generateBridgeAnswer() {
        int bridgeLength = 0;
        while (bridgeLength == 0) {
            try {
                bridgeLength = inputView.readBridgeSize();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return bridgeMaker.makeBridge(bridgeLength);
    }

    /**
     * Repeats attempt to get move command input until it is valid
     * @return validated move command
     */
    public String getValidatedMoveCommand() {
        String moveCommand = "";
        while (!(moveCommand.equals("U") || moveCommand.equals("D"))) {
            try {
                moveCommand = inputView.readMoving();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return moveCommand;
    }

    /**
     * Repeats attempt to get game command input until it is valid
     * @return validated game command
     */
    public String getValidatedGameCommand() {
        String gameCommand = "";
        while (gameCommand.equals("")) {
            try {
                gameCommand = inputView.readGameCommand();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return gameCommand;
    }

    /**
     * Prints the result of a single guess
     * @param result instance of Answer class which includes
     */
    public void guessResult(Result result) {
        outputView.printMap(result);
    }

    /**
     * Prints the final result of the game
     * @param result instance of Result class which stores the list of single guess results
     * @param isSuccess whether user has succeeded to guess the whole bridge answer
     * @param attempts number of tries
     */
    public void finalResult(Result result, boolean isSuccess, int attempts) {
        outputView.printResult(result);
        String resultStatus = "성공";
        if (!isSuccess) { resultStatus = "실패"; }
        System.out.println("\n게임 성공 여부: " + resultStatus);
        System.out.println("총 시도한 횟수: " + attempts);
    }
}
