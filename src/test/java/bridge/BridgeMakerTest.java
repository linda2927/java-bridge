package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BridgeMakerTest {

    @DisplayName("유효한 다리를 생성하는지 확인한다.")
    @Test
    void createBridge() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(4);
        assertTrue(bridge.contains("U") || bridge.contains("D"));
    }
}
