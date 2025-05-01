package hello;

import java.net.InetAddress;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String index() {
        // Get the host machine's IPv4 address
        String ipAddress = "Unknown IP Address";  // Default value in case of an error
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            ipAddress = inetAddress.getHostAddress();
        } catch (java.net.UnknownHostException e) {
            e.printStackTrace();
        }

        // Return the greeting message with the IPv4 address
        return "JAVA application deployed on EC2 with the latest code version using Jenkins pipeline... from Vignan. IP Address: " + ipAddress;
    }
}
