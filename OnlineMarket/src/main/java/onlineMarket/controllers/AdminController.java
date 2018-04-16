package onlineMarket.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import onlineMarket.entities.AdminEntity;
import onlineMarket.entities.BrandEntity;
import onlineMarket.entities.BuyerEntity;
import onlineMarket.entities.ProductEntity;
import onlineMarket.entities.SysProductEntity;
import onlineMarket.entities.UserEntity;
import onlineMarket.repositories.AdminRepository;
import onlineMarket.repositories.BuyerRepository;
import onlineMarket.repositories.ProductRepository;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins="http://localhost:3000",allowedHeaders="*")
public class AdminController {
	
	@Autowired
	AdminRepository AdminRepo;
	@Autowired
	BuyerRepository BuyerRepo;
	@Autowired
	ProductRepository ProductRepo;
	
		
	@RequestMapping("login/{email}/{pass}")
	public boolean Login(@PathVariable String email , @PathVariable String pass)
	{
		UserEntity a = null;
		UserEntity admin = new AdminEntity(email,pass);
		if(email!=null && pass!=null && AdminRepo.exists(admin.getEmail()))
		{
			a= (AdminEntity) AdminRepo.findOne(admin.getEmail());
			if(a.getPassword().equals(admin.getPassword()) )
			{
				return true;
			}
		}
		return false;
	}
	
	@RequestMapping("/userStat/sum")
	public int userSum()
	{
		List<UserEntity> buyer_list= (List<UserEntity>) BuyerRepo.findAll();
		return buyer_list.size();
	}
	
	@RequestMapping("/userStat/avg")
	public double userAvg ()
	{
		List<UserEntity> buyer_list= (List<UserEntity>) BuyerRepo.findAll();
		return buyer_list.size()/2000.0;
	}
	
	@RequestMapping("/ProdStat/sum")
	public double prodSum ()
	{
		List<ProductEntity> Product_list= (List<ProductEntity>) ProductRepo.findAll();
		int cnt=0;
		for(int i=0;i<Product_list.size();i++)
			cnt+=Product_list.get(i).getCounter();
		return cnt;
	}
	
	@RequestMapping("/ProdStat/avg")
	public double prodAvg ()
	{
		List<ProductEntity> Product_list= (List<ProductEntity>) ProductRepo.findAll();
		int cnt=0,cnt2=0;
		for(int i=0;i<Product_list.size();i++) {
			cnt+=Product_list.get(i).getCounter();
			cnt2+=Product_list.get(i).getSoldCounter();
		}
		return cnt/(cnt+cnt2);
	}
	
}
