package onlineMarket.controllers;

import org.apache.coyote.http2.Setting;
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
import org.springframework.web.bind.annotation.SessionAttributes;

import onlineMarket.entities.BuyerEntity;
import onlineMarket.entities.ProductEntity;
import onlineMarket.entities.SellerEntity;
import onlineMarket.entities.StoreEntity;
import onlineMarket.entities.SysProductEntity;
import onlineMarket.entities.UserEntity;
import onlineMarket.repositories.SellerRepository;

@RestController
@RequestMapping("/sellers")
@CrossOrigin(origins="http://localhost:3000",allowedHeaders="*")
public class SellerController {
	public static SellerEntity sell;
	public static SysProductEntity sysProd;
	
	@Autowired
	SellerRepository SellerRepo;
	
	@RequestMapping("/Sregister/{email}/{pass}")
	public boolean Register(@PathVariable String email,@PathVariable String pass)
	{
		//return email;
		UserEntity sellObj= new SellerEntity(email,pass);
		if(email!=null && pass!=null && !SellerRepo.exists(sellObj.getEmail()))
		{
			System.out.println("Hello");
			System.out.println("----"+sellObj.getEmail()+" "+sellObj.getPassword());
			SellerRepo.save(sellObj);
			return true;
		}
		return false;
	}
	
	
	@GetMapping("/login/{email}/{pass}")
	public boolean login(@PathVariable String email, @PathVariable String pass)
	{
		UserEntity s = null;
		UserEntity sellObj= new SellerEntity(email,pass);
		if(email!=null && pass!=null && SellerRepo.exists(sellObj.getEmail()))
		{
			s= (SellerEntity) SellerRepo.findOne(sellObj.getEmail());
			if(s.getPassword().equals(sellObj.getPassword()) )
			{
				return true;
			}
		}
		return false;
	}
//////////////////////////////////////////
	
	/*@GetMapping("/AddStore")
	public String addStore(Model model)
	{
		model.addAttribute("store", new StoreEntity());
		return "AddStore";
	}
	
	@GetMapping("/AddProd")
	public String addProduct(Model model)
	{
		System.out.println("hello");
		model.addAttribute("prod", new ProductEntity());
		return "AddProd";
	}*/
}
