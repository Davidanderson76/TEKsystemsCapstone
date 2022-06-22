package capstone.fullstack.app.service;

import capstone.fullstack.app.entity.EquipmentEntity;
import capstone.fullstack.app.exceptions.ResourceNotFoundException;
import capstone.fullstack.app.repository.EquipmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipmentServiceImpl implements EquipmentService {

    @Autowired
    private EquipmentRepo equipmentRepo;

    @Override
    public List<EquipmentEntity> getAllEquipment() {
        return this.equipmentRepo.findAll();
    }

    @Override
    public void saveEquipment(EquipmentEntity equipmentEntity) {
        this.equipmentRepo.save(equipmentEntity);
    }

    @Override
    public EquipmentEntity getEquipmentById(Long id) {
        Optional<EquipmentEntity> optional = equipmentRepo.findById(id);
        EquipmentEntity equipmentEntity = null;
        if (optional.isPresent()) {
            equipmentEntity = optional.get();
        } else {
            throw new ResourceNotFoundException("Equipment with id: " + id + " not found...");
        }
        return equipmentEntity;
    }

    @Override
    public EquipmentEntity updateEquipment(EquipmentEntity equipmentEntity) {
        return equipmentRepo.save(equipmentEntity);
    }

    @Override
    public void deleteEquipmentById(Long id) {
        this.equipmentRepo.deleteById(id);
    }
}
