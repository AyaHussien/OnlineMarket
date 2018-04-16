package onlineMarket.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import onlineMarket.entities.SysProductEntity;
@Repository
public interface SysProductRepository extends CrudRepository<SysProductEntity,String>{

	public SysProductEntity findByNameInAndBrandIn(String name,String brand);
	public SysProductEntity findByName(String name);
}
