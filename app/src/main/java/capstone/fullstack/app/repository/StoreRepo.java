package capstone.fullstack.app.repository;

import capstone.fullstack.app.entity.StoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreRepo extends JpaRepository<StoreEntity, Long> {

}
