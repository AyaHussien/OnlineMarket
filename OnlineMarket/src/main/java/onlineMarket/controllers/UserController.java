package onlineMarket.controllers;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
////import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
////import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
////import org.springframework.web.bind.annotation.RequestParam;
////import org.springframework.web.bind.annotation.ResponseBody;
////import org.springframework.web.servlet.ModelAndView;
//
//import onlineMarket.entities.BuyerEntity;
//
//import onlineMarket.repositories.BuyerRepository;
//@Controller
//@Configuration
//@ComponentScan(value = "org.foo.path.baseFolder")
//public class UserController {
//	@Autowired
//	private BuyerRepository buyerRepo; 
////	@RequestMapping("/")
////	public String index1(Model model)
////	{
////		//model.addAttribute("user", new UserEntity());
////		return "Register";
////	}
//	
//	
//	
//	@GetMapping("/Register")
//	public String Register(Model model)
//	{
//		System.out.println("help");
//		model.addAttribute("user", new BuyerEntity());
//		return "Register";
//	}
//	
//	@RequestMapping("/Register")
//	public String RegisterSubmit(@ModelAttribute BuyerEntity user,Model model)
//	{
//		
//		model.addAttribute("user", new BuyerEntity());
//		buyerRepo.save(user);
//		System.out.println(user.getEmail());
//		return "Register";
//	}
//	
//}
