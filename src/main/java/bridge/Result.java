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
}
