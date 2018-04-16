package onlineMarket.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import onlineMarket.entities.CollaboratorEntity;
import onlineMarket.entities.ProductEntity;
import onlineMarket.entities.UserEntity;

@Repository
public interface CollaboratorRepository extends CrudRepository<CollaboratorEntity, Integer> {
	public List<CollaboratorEntity> findByNameIn(String Name);
}
