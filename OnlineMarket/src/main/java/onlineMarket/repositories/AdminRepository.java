package onlineMarket.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import onlineMarket.entities.BuyerEntity;
import onlineMarket.entities.UserEntity;

@Repository
public interface  AdminRepository extends CrudRepository<UserEntity, String>{

}
