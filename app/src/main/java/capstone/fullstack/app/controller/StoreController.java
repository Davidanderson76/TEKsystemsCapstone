package capstone.fullstack.app.controller;

import capstone.fullstack.app.entity.StoreEntity;
import capstone.fullstack.app.service.StoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")
@Slf4j
public class StoreController {

    @Autowired
    private StoreService storeService;

    // display list of stores
    @GetMapping("/stores")
    public String viewStorePage(Model model) {
        model.addAttribute("listStores", storeService.getAllStores());
        log.info("Viewing stores page");
        return "stores";
    }

    @GetMapping("/showNewStoreForm")
    public String showNewStoreForm(Model model) {
        StoreEntity storeEntity = new StoreEntity();
        model.addAttribute("store", storeEntity);
        log.info("Viewing new store page");
        return "new_store";
    }

    @PostMapping("/saveStore")
    public String saveStore(@ModelAttribute("store") StoreEntity storeEntity) {
        // save store to db
        storeService.saveStore(storeEntity);
        log.info("Saved store to db");
        return "redirect:/api/stores";
    }

    @GetMapping("/formForUpdateStore/{id}")
    public String formForUpdateStore(@PathVariable(value = "id") long id, Model model) {
        // get store from the service
        StoreEntity storeEntity = storeService.getStoreById(id);
        // set store as a model attribute to pre-populate the form
        model.addAttribute("store", storeEntity);
        log.info("update store page by store ID");
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
        log.info("Update store by ID");
        return "redirect:/api/stores";
    }

    @GetMapping("/deleteStore/{id}")
    public String deleteStore(@PathVariable(value = "id") Long id) {
        // call delete from service
        this.storeService.deleteStoreById(id);
        log.info("delete store by id");
        return "redirect:/api/stores";
    }


}
