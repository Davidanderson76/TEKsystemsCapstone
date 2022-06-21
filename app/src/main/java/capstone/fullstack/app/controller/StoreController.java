package capstone.fullstack.app.controller;

import capstone.fullstack.app.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class StoreController {

    @Autowired
    private StoreService storeService;

    // display list of stores
    @GetMapping("/stores")
    public String viewStorePage(Model model){
        model.addAttribute("listStores",storeService.getAllStores());
        return "stores";
    }

}
