package bridge;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public String readBridgeSize() {
        System.out.println("다리 길이를 입력해주세요.");
        String bridgeLengthInput = Console.readLine().trim();
        return bridgeLengthInput;
    }

    /**
     * Validates user input of bridge length
     * @param userInput string format of user input
     * @return int format of valid bridge length
     */
    public int validateBridgeSizeInput(String userInput) throws IllegalArgumentException{
        int bridgeLength;
        try {
            bridgeLength = Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 다리의 길이는 숫자여야 합니다.");
        }
        if (bridgeLength < 3 || bridgeLength > 20) {
            throw new IllegalArgumentException("[ERROR] 다리의 길이는 3과 20 사이의 정수여야 합니다.");
        }
        return bridgeLength;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String moveCommand = Console.readLine().trim();
        return moveCommand;
    }

    /**
     * Validates user input of move commands
     * @param moveCommand String format of user command input to move
     */
    public void validateMoveCommand(String moveCommand) {
        if (!(moveCommand.equals("U") || moveCommand.equals("D"))) {
            throw new IllegalArgumentException("[ERROR] 이동을 위한 명령어는 'U' 나 'D' 입니다.");
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String gameCommand = Console.readLine().trim();
        return gameCommand;
    }

    /**
     * Validates user input of game commands
     * @param gameCommand String format of user command input to retry or quit
     */
    public void validateGameCommand(String gameCommand) {
        if (!(gameCommand.equals("R") || gameCommand.equals("Q"))) {
            throw new IllegalArgumentException("[ERROR] 재시도하려면 'R' 을 게임을 종료하려면 'Q' 를 정확하게 입력해주세요.");
        }
    }
}
