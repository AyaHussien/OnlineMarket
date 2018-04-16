package onlineMarket.entities;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
public class ProductEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Id;
	private String name;
	private String storeName;
	private int counter, soldCounter, buyerCounter ,viewedCounter;
	private double price;
	private String brand;
	
	public int getViewedCounter() {
		return viewedCounter;
	}

	public void setViewedCounter(int viewedCounter) {
		this.viewedCounter = viewedCounter;
	}

	public int getBuyerCounter() {
		return buyerCounter;
	}

	public void setBuyerCounter(int buyerCounter) {
		this.buyerCounter = buyerCounter;
	}
	public int getSoldCounter() {
		return soldCounter;
	}

	public void setSoldCounter(int soldCounter) {
		this.soldCounter = soldCounter;
	}

	public ProductEntity(String name,String store,double price,String brand)
	{
		this.name=name;
		this.storeName=store;
		this.price=price;
		this.brand=brand;
		counter=1;
	}
	
	public String getBrand() {
		return brand;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}
	
	public ProductEntity() {counter=1;}
	
	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	/*public String getBrand() {
		return Brand;
	}
	public void setBrand(String brand) {
		Brand = brand;
	}*/
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}	
