package capstone.fullstack.app.service;

import capstone.fullstack.app.entity.StoreEntity;
import capstone.fullstack.app.repository.StoreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreServiceImpl implements StoreService{

    @Autowired
    private StoreRepo storeRepo;

    @Override
    public List<StoreEntity> getAllStores() {
        return storeRepo.findAll();
    }
}
