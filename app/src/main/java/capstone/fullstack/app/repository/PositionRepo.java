package capstone.fullstack.app.repository;

import capstone.fullstack.app.entity.PositionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionRepo extends JpaRepository<PositionEntity, Long> {


}
