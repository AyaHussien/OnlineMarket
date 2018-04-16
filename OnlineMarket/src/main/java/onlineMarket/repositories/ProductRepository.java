package onlineMarket.repositories;

import java.util.List;
import java.util.Vector;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import onlineMarket.entities.ProductEntity;
@Repository
public interface ProductRepository extends CrudRepository<ProductEntity,Integer> {

	public  ProductEntity  findByNameInAndStoreNameIn(String name,String storeName);
	public List<ProductEntity> findByStoreNameIn(String StoreName);
	@Modifying
	@Query("update ProductEntity p set p.counter = :counter  where p.storeName = :storeName and name= :name")
	int SetCounterForProductEntity(@Param("counter") int counter);
	
	@Modifying
	@Query("update ProductEntity p set p.soldCounter = :soldCounter  where p.storeName = :storeName and name= :name")
	int SetsoldCounterForProductEntity(@Param("soldCounter") int soldCounter);
}
