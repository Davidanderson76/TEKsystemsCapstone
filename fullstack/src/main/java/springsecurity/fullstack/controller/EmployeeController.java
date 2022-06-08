package springsecurity.fullstack.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import springsecurity.fullstack.domain.entities.EmployeeInfo;
import springsecurity.fullstack.service.EmployeeService;

import java.util.List;

@Controller
public class EmployeeController {


    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public String getUsers(Model model) {
        List<EmployeeInfo> users = employeeService.getUsers();
        model.addAttribute("users", users);
        model.addAttribute("userInfo", new EmployeeInfo());
        return "employees";
    }

    @RequestMapping(path = "/all", method = RequestMethod.POST)
    public RedirectView createUser(RedirectAttributes redirectAttributes, @ModelAttribute EmployeeInfo employeeInfo) {
        employeeService.createUser(employeeInfo);
        String message = "Created user <b>" + employeeInfo.getFirstName() + " " + employeeInfo.getLastName() + "</b> ✨.";
        RedirectView redirectView = new RedirectView("/", true);
        redirectAttributes.addFlashAttribute("userMessage", message);
        return redirectView;
    }

    @RequestMapping(path = "all/{id}", method = RequestMethod.GET)
    public String getUser(Model model, @PathVariable("id") Integer id) {
        EmployeeInfo employeeInfo = employeeService.getUser(id);
        model.addAttribute("userInfo", employeeInfo);
        return "edit";
    }

    @RequestMapping(path = "all/{id}", method = RequestMethod.POST)
    public RedirectView updateUser(RedirectAttributes redirectAttributes, @PathVariable("id") Integer id, @ModelAttribute EmployeeInfo userInfo) {
        employeeService.updateUser(id, userInfo);
        String message = (userInfo.isActive() ? "Updated " : "Deleted ") + " user <b>" + userInfo.getFirstName() + " " + userInfo.getLastName() + "</b> ✨.";
        RedirectView redirectView = new RedirectView("/", true);
        redirectAttributes.addFlashAttribute("userMessage", message);
        return redirectView;
    }

}
