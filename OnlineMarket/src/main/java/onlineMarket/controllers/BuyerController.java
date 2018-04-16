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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import onlineMarket.entities.BuyerEntity;
import onlineMarket.entities.UserEntity;
import onlineMarket.repositories.BuyerRepository;

@RestController
@RequestMapping("/buyers")
@CrossOrigin(origins="http://localhost:3000",allowedHeaders="*")
public class BuyerController {
	
	
	@Autowired
	BuyerRepository BuyerRepo; 
	 
	@RequestMapping
	public List<UserEntity> s ()
	{
		//md.addAttribute("users",BuyerRepo.findAll());
		return (List<UserEntity>)BuyerRepo.findAll();
	}
	
	@RequestMapping("/{email}")
	public UserEntity getbyid(@PathVariable String email)
	{
		return (UserEntity)BuyerRepo.findOne(email);
	}
	//////////register /////
	@PostMapping("/Bregister/{email}/{pass}")
	public boolean Register(@PathVariable String email,@PathVariable String pass)
	{
		UserEntity buy = new BuyerEntity(email,pass);
		if(buy.getEmail()!=null && buy.getPassword()!=null && !BuyerRepo.exists(buy.getEmail()))
		{
			System.out.println("Hello");
			System.out.println(buy.getEmail()+" "+buy.getPassword());
			BuyerRepo.save(buy);
			return true;
		}
		return false;
	}
	
	
//////////login /////
@GetMapping("login/{email}/{pass}")
public boolean Login(@PathVariable String email , @PathVariable String pass)
{
	UserEntity b = null;
	UserEntity buy = new BuyerEntity(email,pass);
	if(email!=null && pass!=null && BuyerRepo.exists(buy.getEmail()))
	{
		b= (BuyerEntity) BuyerRepo.findOne(buy.getEmail());
		if(b.getPassword().equals(buy.getPassword()) )
		{
			return true;
		}
	}
	return false;
}
//	@RequestMapping("/buyerEntity")
//	public String da(@ModelAttribute BuyerEntity buyer)
//	{
//		System.out.println("hello "+buyer.getEmail());
//		return "try";
//	}
}
