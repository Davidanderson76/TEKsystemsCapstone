package capstone.fullstack.app.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }




    @GetMapping("/vehicles")
    public String vehiclesPage() {
        return "vehicles";
    }

    @GetMapping("/about")
    public String aboutPage() {
        return "about";
    }
}