package onlineMarket.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import onlineMarket.entities.CollaboratorEntity;
import onlineMarket.repositories.CollaboratorRepository;
import onlineMarket.repositories.SellerRepository;
import onlineMarket.repositories.StoreRepository;

@RestController
@RequestMapping("/sellers")
@CrossOrigin(origins="http://localhost:3000",allowedHeaders="*")

public class CollaboratorController {

	@Autowired
	CollaboratorRepository CollaRepo;
	@Autowired
	StoreRepository StoreRepo;
	@Autowired
	SellerRepository SellerRepo;
	
	@RequestMapping("addColla/{name}/{store}/{StoreOwner}") ///storeOwner httb3t m3 l button ya 7e7eeeees
	public boolean addColla(@PathVariable String name ,@PathVariable String store,@PathVariable String StoreOwner)
	{
		if( SellerRepo.exists(name) && StoreRepo.findBySellerNameInAndNameIn(StoreOwner, store)!=null )
		{
			CollaRepo.save(new CollaboratorEntity(name,store));
			return true;
		}
		else
			return false;
	}
}
