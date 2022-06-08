package springsecurity.fullstack.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String root() {
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/user")
    public String userIndex() {
        return "user/index";
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

