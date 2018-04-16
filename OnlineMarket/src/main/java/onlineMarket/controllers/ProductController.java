package onlineMarket.controllers;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import onlineMarket.repositories.ActionRepository;
import onlineMarket.repositories.BrandRepository;
import onlineMarket.repositories.BuyerRepository;
import onlineMarket.repositories.ProductRepository;
import onlineMarket.repositories.SellerRepository;
import onlineMarket.repositories.StoreRepository;
import onlineMarket.repositories.SysProductRepository;
import onlineMarket.entities.*;;
@RestController
@RequestMapping("/sellers")
@CrossOrigin(origins="http://localhost:3000",allowedHeaders="*") 
public class ProductController {
	@Autowired
	ProductRepository ProductRepo;
	@Autowired
	SysProductRepository SysProductRepo;
	@Autowired
	 BrandRepository BrandRepo;
	@Autowired
	StoreRepository StoreRepo;
	@Autowired
	ActionRepository ActionRepo;
	@Autowired
	SellerRepository SellerRepo;
	@Autowired
	BuyerRepository BuyerRepo;
	
	/*@RequestMapping("/getProd")
	public String getProd(Model md)
	{
		md.addAttribute("test",ProductRepo.findByName("prod"));
		return "try";
	}*/
	// kont bagrb el update
	/*@RequestMapping("/update")
	public String upd()
	{
		ProductEntity p= ProductRepo.findByStoreNameIn("esm");
		int x=p.getCounter();
		x++;
		p.setCounter(x);
		ProductRepo.save(p);
		return "try";
	}
	*/
	@RequestMapping("/AddProd/{name}/{storeName}/{price}/{brand}/{amount}") ///zwdna amount
	public boolean add(@PathVariable String name ,@PathVariable String storeName,@PathVariable double price,@PathVariable String brand,@PathVariable int amount)
	{
		//ProductEntity prod=new ProductEntity
		ProductEntity prod= ProductRepo.findByNameInAndStoreNameIn(name, storeName);
		SysProductEntity sys=SysProductRepo.findByName(name);
		if(!BrandRepo.exists(brand) || sys==null)
			return false;
		
		if(prod==null)
		{
			prod=new ProductEntity(name,storeName,price,brand);
			prod.setCounter(amount);
			ProductRepo.save(prod);
			return true;
		}
		else
		{
			int x=prod.getCounter();
			prod.setCounter(x+amount);
			ProductRepo.save(prod);
			return true;

		}
		
	}
	
	
	@RequestMapping("/Edit/{prod}/{store}/{price}")
	public boolean Edit(@PathVariable String prod,@PathVariable String store,@PathVariable double price)
	{
		ProductEntity product=ProductRepo.findByNameInAndStoreNameIn(prod, store);
		if(product!=null)
		{
			product.setPrice(price);
			ProductRepo.save(product);
			return true;
		}
		else 
			return false;
	}
	
	@RequestMapping("/Delete/{prod}/{store}/{amount}")
	public boolean Delete(@PathVariable String prod,@PathVariable String store,@PathVariable Integer amount)
	{
		ProductEntity product=ProductRepo.findByNameInAndStoreNameIn(prod, store);
		if(product!=null)
		{
			if(product.getCounter()<amount)
				return false;
			else
				product.setCounter(product.getCounter()-amount);
			
			if(product.getCounter()==0)
				ProductRepo.delete(product.getId());
			else
				ProductRepo.save(product);
			return true;
		}
		else 
			return false;
	}
	
	@RequestMapping("/buy/{name}/{amount}/{store}/{buyer}")
	public double buy(@PathVariable String name ,@PathVariable int amount,@PathVariable String store,@PathVariable String buyer)
	{
		///kan mwgod brand bs 7stha mlhash lzma l2nha kda kda mwgoda f product nfso
		ProductEntity pro = null;
		double degree= 1.0;
		if(name!=null&& store!=null)
		{	
			List<StoreEntity> s=StoreRepo.findBySellerNameIn(buyer);
			if(s!=null)
				degree-=0.15;
			pro=ProductRepo.findByNameInAndStoreNameIn(name, store);
			if(pro!=null  && pro.getCounter()>=amount )
			{
				if(amount>=2)
					degree-=0.1;
				if(s!=null)
				{
					SellerEntity s2=(SellerEntity) SellerRepo.findOne(buyer);
					if(!s2.getFlag()) {
						degree-=0.05;
						s2.setFlag(true);
						SellerRepo.save(s2);
					}
				}
				else
				{
					BuyerEntity s2=(BuyerEntity) BuyerRepo.findOne(buyer);
					if(!s2.getFlag()) {
						degree-=0.05;
						s2.setFlag(true);
						BuyerRepo.save(s2);
					}
				}
				int counter=pro.getCounter()-amount;
				int soldCounter= pro.getSoldCounter()+amount;
				pro.setCounter(counter);
				pro.setSoldCounter(soldCounter+1);
				pro.setBuyerCounter( pro.getBuyerCounter()+1 );
				ProductRepo.save(pro);
				double price=pro.getPrice()*amount*degree;
				
				return price;
			}
		}
		return -1;
	}
	@GetMapping("/listProds")
	public List<ProductEntity> getProds()
	{
		return (List<ProductEntity>) ProductRepo.findAll();
	}
	@GetMapping("listInstore/{name}")
	public List<ProductEntity> getStoreProds(@PathVariable String name)
	{
		return (List<ProductEntity>)ProductRepo.findByStoreNameIn(name);
	}
	@RequestMapping("/view/{name}/{store}")
	public ProductEntity viewedStat(@PathVariable String name,@PathVariable String store)
	{
		ProductEntity pro;
		pro=ProductRepo.findByNameInAndStoreNameIn(name, store);
		pro.setViewedCounter( pro.getViewedCounter()+1 );
		return pro;
	}
	
	
	
	@RequestMapping("/collaEdit/{prod}/{store}/{price}/{colla}")
	public boolean CollaEdit(@PathVariable String prod,@PathVariable String store,@PathVariable double price,@PathVariable String colla)
	{
		StoreEntity stor=StoreRepo.findOne(store);
		String owner=stor.getSellerName();
		ProductEntity product=ProductRepo.findByNameInAndStoreNameIn(prod, store);
		if(product!=null)
		{
			ActionRepo.save(new ActionEntity("Edit",prod,store,owner,1,price,product.getPrice(),colla));
			product.setPrice(price);
			ProductRepo.save(product);
			return true;
		}
		else 
			return false;
	}
	
	@RequestMapping("/collaAdd/{name}/{storeName}/{price}/{brand}/{amount}/{colla}") ///zwdna amount
	public boolean Collaadd(@PathVariable String name ,@PathVariable String storeName,@PathVariable double price,
			@PathVariable String brand,@PathVariable int amount,@PathVariable String colla)
	{
		//ProductEntity prod=new ProductEntity
		StoreEntity store=StoreRepo.findOne(storeName);
		String owner=store.getSellerName();
		ProductEntity prod= ProductRepo.findByNameInAndStoreNameIn(name, storeName);
		SysProductEntity sys=SysProductRepo.findByName(name);
		if(!BrandRepo.exists(brand) || sys==null)
			return false;
		
		if(prod==null)
		{
			ActionRepo.save(new ActionEntity("add", name, storeName, owner, amount, price, 0,colla));
			prod=new ProductEntity(name,storeName,price,brand);
			prod.setCounter(amount);
			ProductRepo.save(prod);
			return true;
		}
		else
		{
			ActionRepo.save(new ActionEntity("add", name, storeName, owner, amount, price, prod.getPrice(),colla));
			
			int x=prod.getCounter();
			prod.setCounter(x+amount);
			ProductRepo.save(prod);
			return true;

		}
		
	}
	
	@RequestMapping("/collaDelete/{prod}/{store}/{amount}/{colla}")
	public boolean CollaDelete(@PathVariable String prod,@PathVariable String store,@PathVariable Integer amount,@PathVariable String colla)
	{
		StoreEntity stor=StoreRepo.findOne(store);
		String owner=stor.getSellerName();
		ProductEntity product=ProductRepo.findByNameInAndStoreNameIn(prod, store);
		if(product!=null)
		{
			if(product.getCounter()<amount)
				return false;
			else
				product.setCounter(product.getCounter()-amount);
	
			
			ActionRepo.save(new ActionEntity("Delete",prod,store,owner,amount,0,product.getPrice(),colla));
			
			ProductRepo.save(product);
			return true;
		}
		else 
			return false;
	}
	
	@GetMapping("/history/{owner}") ///hat3mle ganbo button undo w yb3t kol el attributes w matnse4 el ***id***
	public List<ActionEntity> Actions(@PathVariable String owner)
	{
		return (List<ActionEntity>) ActionRepo.findByFirstOwner(owner); 
	}
	
	@RequestMapping("/undo/{type}/{amount}/{prod}/{store}/{price}/{id}")
	public boolean Undo(@PathVariable String type,@PathVariable Integer amount,@PathVariable String prod,
			@PathVariable String store,@PathVariable double price,@PathVariable Integer id)
	{
		ProductEntity product =ProductRepo.findByNameInAndStoreNameIn(prod, store);
			
		
		if(type.equals("Add"))
		{
			if(product.getCounter()>=amount && product!=null)
			{
				product.setCounter(product.getCounter()-amount);
				ProductRepo.save(product);
				ActionRepo.delete(id);
				return true;
			}
			else 
				return false;
			
		}
		else if(type.equals("Delete"))
		{
			product.setCounter(product.getCounter()+amount);
			ProductRepo.save(product);
			ActionRepo.delete(id);
			return true;
		}
		else
		{
			if(product!=null) {
				product.setPrice(price);
				ProductRepo.save(product);
				ActionRepo.delete(id);
				return true;
			}
			else 
				return false;
		}
	}
	
	
	
	

}
