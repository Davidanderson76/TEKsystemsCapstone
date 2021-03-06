package capstone.fullstack.app.service;

import capstone.fullstack.app.entity.StoreEntity;

import java.util.List;

public interface StoreService {
    List<StoreEntity> getAllStores();
//    List<StoreEntity> findByName(String name);
    void saveStore(StoreEntity storeEntity);

    StoreEntity getStoreById(Long id);

    StoreEntity updateStore(StoreEntity storeEntity);

    void deleteStoreById(Long id);
}
