package capstone.fullstack.app.service;

import capstone.fullstack.app.entity.StoreEntity;
import capstone.fullstack.app.exceptions.ResourceNotFoundException;
import capstone.fullstack.app.repository.StoreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreRepo storeRepo;

    @Override
    public List<StoreEntity> getAllStores() {
        return storeRepo.findAll();
    }

    @Override
    public void saveStore(StoreEntity storeEntity) {
        this.storeRepo.save(storeEntity);
    }

    @Override
    public StoreEntity getStoreById(Long id) {
        Optional<StoreEntity> optional = storeRepo.findById(id);
        StoreEntity storeEntity = null;
        if (optional.isPresent()) {
            storeEntity = optional.get();
        } else {
            throw new ResourceNotFoundException("Store with id: " + id + " not found...");
        }
        return storeEntity;
    }

    @Override
    public StoreEntity updateStore(StoreEntity storeEntity) {
        return storeRepo.save(storeEntity);
    }

    @Override
    public void deleteStoreById(Long id) {
        this.storeRepo.deleteById(id);
    }
}
