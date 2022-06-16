package capstone.fullstack.app.repository;

import capstone.fullstack.app.entity.EquipmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentRepo extends JpaRepository<EquipmentEntity, Long> {
}
