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
}
