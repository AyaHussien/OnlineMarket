package onlineMarket.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import onlineMarket.entities.StoreEntity;

@Repository
public interface StoreRepository extends CrudRepository<StoreEntity,String>{

	public List<StoreEntity> findBySellerNameIn(String sellername);
	public StoreEntity findBySellerNameInAndNameIn(String sellername,String storeName);
}