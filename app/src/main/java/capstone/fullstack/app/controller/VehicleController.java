package capstone.fullstack.app.controller;

import capstone.fullstack.app.entity.EmployeeEntity;
import capstone.fullstack.app.entity.VehicleEntity;
import capstone.fullstack.app.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/vehicles")
    public String viewVehiclePage(Model model) {
        model.addAttribute("listVehicles", vehicleService.getAllVehicles());
        return "vehicles";
    }

    @GetMapping("/newVehicleForm")
    public String newVehicleForm(Model model) {
        VehicleEntity vehicleEntity = new VehicleEntity();
        model.addAttribute("vehicle", vehicleEntity);
        return "new_vehicle";
    }

    @PostMapping("/saveVehicle")
    public String saveVehicle(@ModelAttribute("vehicle") VehicleEntity vehicleEntity) {
        // save vehicle to db
        vehicleService.saveVehicle(vehicleEntity);
        return "redirect:/api/vehicles";
    }

    @GetMapping("/formForUpdateVehicles/{id}")
    public String formForUpdateVehicles(@PathVariable(value = "id") long id, Model model) {

        // get vehicle from the service
        VehicleEntity vehicleEntity = vehicleService.getVehicleById(id);
        // set vehicle as a model attribute to pre-populate the form
        model.addAttribute("vehicle", vehicleEntity);
        return "update_vehicle";
    }

    @PostMapping("/vehicle/{id}")
    public String updateVehicle(@PathVariable Long id, @ModelAttribute("vehicle") VehicleEntity vehicleEntity, Model model) {
        // get vehicle from database by id
        VehicleEntity existingVehicle = vehicleService.getVehicleById(id);
        existingVehicle.setModel(vehicleEntity.getModel());
        existingVehicle.setMake(vehicleEntity.getMake());
        existingVehicle.setYear(vehicleEntity.getYear());
        existingVehicle.setColor(vehicleEntity.getColor());
        existingVehicle.setInsured(vehicleEntity.isInsured());
        // save vehicle student object
        vehicleService.updateVehicle(existingVehicle);
        return "redirect:/api/vehicles";
    }

    @GetMapping("/deleteVehicle/{id}")
    public String deleteVehicle(@PathVariable(value = "id") Long id) {
        // call delete from service
        this.vehicleService.deleteVehicleById(id);
        return "redirect:/api/vehicles";
    }


}
