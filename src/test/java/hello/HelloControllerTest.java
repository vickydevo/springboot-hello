package hello;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HelloControllerTest {

    @Test
    public void testIndex() {
        HelloController controller = new HelloController();
        String result = controller.index();
        assertTrue(result.contains("JAVA application deployed on EC2 with the latest code version using Jenkins pipeline – from Vignan."));
    }
}