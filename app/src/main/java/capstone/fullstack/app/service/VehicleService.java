package capstone.fullstack.app.service;

import capstone.fullstack.app.entity.VehicleEntity;

import java.util.List;

public interface VehicleService {

    List<VehicleEntity> getAllVehicles();

    VehicleEntity getVehicleById(Long id);

    VehicleEntity updateVehicle(VehicleEntity vehicleEntity);

    void saveVehicle(VehicleEntity vehicleEntity);

    void deleteVehicleById(Long id);

}
