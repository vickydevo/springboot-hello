package hello;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {
    
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
        return "Greetings from  'vignan' deployed JAVA app in ELASTICBEANSTALK with SINGLE running new version of code "   + ipAddress;
        

    }
    
}
