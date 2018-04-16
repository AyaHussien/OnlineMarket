package onlineMarket.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import onlineMarket.entities.BuyerEntity;
import onlineMarket.entities.UserEntity;

@Repository
public interface  BuyerRepository extends CrudRepository<UserEntity, String>{
	//List<BuyerEntity> findByDtype(String type);
}
