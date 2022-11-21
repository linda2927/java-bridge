package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자가 입력한 정답과 그 결과를 저장하고 관리한다.
 */
public class Result {
    private List<String> upperResult;
    private List<String> lowerResult;

    public Result() {
        this.upperResult = new ArrayList<>();
        this.lowerResult = new ArrayList<>();
    }

    /**
     * Returns the guess result of upper bridge
     * @return list containing "O" or "X"
     */
    public List<String> getUpperResult() {
        return upperResult;
    }

    /**
     * Returns the guess result of lower bridge
     * @return list containing "O" or "X"
     */
    public List<String> getLowerResult() {
        return lowerResult;
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
     * Add result string "O" or "X" to upper and lower result list
     * @param moveCommand user's move command
     * @param result whether user's guess was correct (in "O" or "X")
     */
    public void addResult(String moveCommand, String result) {
        if (moveCommand.equals("U")) {
            upperResult.add(result);
            lowerResult.add(" ");
        }
        if (moveCommand.equals("D")) {
            lowerResult.add(result);
            upperResult.add(" ");
        }
    }

    /**
     * Clears the result list in case of game retry
     */
    public void clearResult() {
        this.upperResult = new ArrayList<>();
        this.lowerResult = new ArrayList<>();
    }
}
