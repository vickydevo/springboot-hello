package hello;

import java.net.InetAddress;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    
    @RequestMapping("/")
    public String index() {
        // Get the host machine's IPv4 address
        String ipAddress = "";
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            ipAddress = inetAddress.getHostAddress();
        } catch (java.net.UnknownHostException e) {
            e.printStackTrace();
        }

        // Return the greeting message with the IPv4 address
        return "JAVA application deployed on EC2 with the latest code version using Jenkins pipeline – from Vignan."   + ipAddress;
        

    }
    
    @Test
    public void testIndex() {
        HelloController controller = new HelloController();
        String result = controller.index();
        assertTrue(result.contains("JAVA application deployed on EC2 with the latest code version using Jenkins pipeline – from Vignan."));
    }
    
}
    
    @RequestMapping("/")
    public String index() {
        // Get the host machine's IPv4 address
        String ipAddress = "";
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            ipAddress = inetAddress.getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        // Return the greeting message with the IPv4 address
        return "JAVA application deployed on EC2 with the latest code version using Jenkins pipeline – from Vignan."   + ipAddress;
        

    }
    
}
