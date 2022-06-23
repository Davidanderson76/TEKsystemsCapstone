package capstone.fullstack.app.service;

import capstone.fullstack.app.entity.VehicleEntity;
import capstone.fullstack.app.exceptions.ResourceNotFoundException;
import capstone.fullstack.app.repository.VehicleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepo vehicleRepo;

    @Override
    public List<VehicleEntity> getAllVehicles() {
        return vehicleRepo.findAll();
    }

    @Override
    public VehicleEntity getVehicleById(Long id) {
        Optional<VehicleEntity> optional = vehicleRepo.findById(id);
        VehicleEntity vehicleEntity = null;
        if (optional.isPresent()) {
            vehicleEntity = optional.get();
        } else {
            throw new ResourceNotFoundException("Vehicle with id: " + id + " not found...");
        }
        return vehicleEntity;
    }

    @Override
    public VehicleEntity updateVehicle(VehicleEntity vehicleEntity) {
        return vehicleRepo.save(vehicleEntity);
    }

    @Override
    public void saveVehicle(VehicleEntity vehicleEntity) {
        this.vehicleRepo.save(vehicleEntity);
    }

    @Override
    public void deleteVehicleById(Long id) {
        this.vehicleRepo.deleteById(id);
    }
}
