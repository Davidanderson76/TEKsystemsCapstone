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

    @GetMapping("/stores")
    public String storesPage() {
        return "stores";
    }

    @GetMapping("/employees")
    public String employeesPage() {
        return "employees";
    }

    @GetMapping("/equipment")
    public String equipmentPage() {
        return "equipment";
    }

    @GetMapping("/vehicles")
    public String vehiclesPage() {
        return "vehicles";
    }
}