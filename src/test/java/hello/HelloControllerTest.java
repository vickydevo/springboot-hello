package hello;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HelloControllerTest {

    @Autowired
    private HelloController controller;

    @Test
    public void testIndex() {
        String result = controller.index();
        assertTrue(result.contains("JAVA application deployed on EC2 with the latest code version using Jenkins pipeline – from Vignan.")); // Assuming the static part of the message remains constant
    }
}