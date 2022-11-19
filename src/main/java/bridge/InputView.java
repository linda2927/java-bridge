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
        String bridgeLengthInput = Console.readLine();
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
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
