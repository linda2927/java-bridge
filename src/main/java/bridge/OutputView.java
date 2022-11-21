package bridge;

import java.util.List;
/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * Prints the result of guessing so far line by line
     * @param result instance of Result class which contains the result of guessing
     */
    public void printMap(Result result) {
        printLine(result.getUpperResult());
        printLine(result.getLowerResult());
    }

    /**
     * Prints upper or lower bridge answer
     * @param partialBridge upper or lower bridge answer
     */
    private void printLine(List<String> partialBridge) {
        StringBuilder lineStr = new StringBuilder("[ ");
        for (int i = 0; i < partialBridge.size(); i++) {
            if (i == partialBridge.size() - 1) {
                lineStr.append(partialBridge.get(i)).append(" ]");
                break;
            }
            lineStr.append(partialBridge.get(i)).append(" | ");
        }

        System.out.println(lineStr);
    }

    /**
     * Prints the final result
     * @param result instance of Result class which contains the result of guessing
     */
    public void printResult(Result result) {
        System.out.println("\n최종 게임 결과");
        printMap(result);
    }
}
