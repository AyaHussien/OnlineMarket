package onlineMarket.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import onlineMarket.entities.ActionEntity;

public interface ActionRepository extends CrudRepository<ActionEntity,Integer> {
	public List<ActionEntity> findByFirstOwner(String name);
}
