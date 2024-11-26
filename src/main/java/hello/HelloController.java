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
<<<<<<< HEAD
        return "Greetings from  'vignan' deployed JAVA app in ELASTICBEANSTALK with SINGLE running new version of code 2" + ipAddress;
        
=======
        return "Greetings from  'vignan' deployed JAVA app in virtual Machine..!!!Introduced LOADBALANCER Host private IPv4 Address: " + ipAddress;
>>>>>>> 2ff2d5d1abf4e475d0d813dff6230cce8cdf374f
    }
    
}
