package capstone.fullstack.app.controller;

import capstone.fullstack.app.entity.EquipmentEntity;
import capstone.fullstack.app.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")
public class EquipmentController {

    @Autowired
    private EquipmentService equipmentService;

    // List all pieces of equipment
    @GetMapping("/equipment")
    public String viewEquipmentPage(Model model) {
        model.addAttribute("listEquipment", equipmentService.getAllEquipment());
        return "equipment";
    }

    @GetMapping("/showNewEquipmentForm")
    public String showNewEquipmentForm(Model model) {
        EquipmentEntity equipmentEntity = new EquipmentEntity();
        model.addAttribute("equipment", equipmentEntity);
        return "new_equipment";
    }

    @PostMapping("/saveEquipment")
    public String saveEquipment(@ModelAttribute("equipment") EquipmentEntity equipmentEntity) {
        equipmentService.saveEquipment(equipmentEntity);
        return "redirect:/api/equipment";
    }

    @GetMapping("/formForUpdateEquipment/{id}")
    public String formForUpdateEquipment(@PathVariable(value = "id") long id, Model model) {
        EquipmentEntity equipmentEntity = equipmentService.getEquipmentById(id);
        model.addAttribute("equipment", equipmentEntity);
        return "update_equipment";
    }

    @PostMapping("/equipment/{id}")
    public String updateEquipment(@PathVariable Long id, @ModelAttribute("equipment") EquipmentEntity equipmentEntity, Model model) {
        // get each piece of equipment by id
        EquipmentEntity existingEquipment = equipmentService.getEquipmentById(id);

        existingEquipment.setName(equipmentEntity.getName());
        existingEquipment.setCost(equipmentEntity.getCost());
        existingEquipment.setStatus(equipmentEntity.getStatus());

        equipmentService.updateEquipment(existingEquipment);
        return "redirect:/api/equipment";
    }

    @GetMapping("/deleteEquipment/{id}")
    public String deleteEquipment(@PathVariable(value = "id") Long id) {
        this.equipmentService.deleteEquipmentById(id);
        return "redirect:/api/equipment";
    }


}
