package bridge;

import java.util.ArrayList;
import java.util.List;

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
    public void clearAnswer() {
        this.upperResult = new ArrayList<>();
        this.lowerResult = new ArrayList<>();
    }
}
