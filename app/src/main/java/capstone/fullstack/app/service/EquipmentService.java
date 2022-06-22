package capstone.fullstack.app.service;

import capstone.fullstack.app.entity.EquipmentEntity;

import java.util.List;

public interface EquipmentService {

    List<EquipmentEntity> getAllEquipment();

    void saveEquipment(EquipmentEntity equipmentEntity);

    EquipmentEntity getEquipmentById(Long id);

    EquipmentEntity updateEquipment(EquipmentEntity equipmentEntity);

    void deleteEquipmentById(Long id);

}
