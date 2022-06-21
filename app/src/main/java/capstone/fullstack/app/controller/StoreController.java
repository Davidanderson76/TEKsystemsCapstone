package capstone.fullstack.app.controller;

import capstone.fullstack.app.entity.StoreEntity;
import capstone.fullstack.app.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")
public class StoreController {

    @Autowired
    private StoreService storeService;

    // display list of stores
    @GetMapping("/stores")
    public String viewStorePage(Model model) {
        model.addAttribute("listStores", storeService.getAllStores());
        return "stores";
    }

    @GetMapping("/showNewStoreForm")
    public String showNewStoreForm(Model model) {
        StoreEntity storeEntity = new StoreEntity();
        model.addAttribute("store", storeEntity);
        return "new_store";
    }

    @PostMapping("/saveStore")
    public String saveStore(@ModelAttribute("store") StoreEntity storeEntity) {
        // save store to db
        storeService.saveStore(storeEntity);
        return "redirect:/api/stores";
    }

    @GetMapping("/formForUpdateStore/{id}")
    public String formForUpdateStore(@PathVariable(value = "id") long id, Model model) {
        // get store from the service
        StoreEntity storeEntity = storeService.getStoreById(id);
        // set store as a model attribute to pre-populate the form
        model.addAttribute("store", storeEntity);
        return "update_store";
    }

    @PostMapping("/store/{id}")
    public String updateEmployee(@PathVariable Long id, @ModelAttribute("store") StoreEntity storeEntity, Model model) {
        // get student from database by id
        StoreEntity existingStore = storeService.getStoreById(id);

        existingStore.setName(storeEntity.getName());
        existingStore.setAddress(storeEntity.getAddress());

        // save updated student object
        storeService.updateStore(existingStore);
        return "redirect:/api/stores";
    }

    @GetMapping("/deleteStore/{id}")
    public String deleteStore(@PathVariable(value = "id") Long id) {
        // call delete from service
        this.storeService.deleteStoreById(id);
        return "redirect:/api/stores";
    }


}
