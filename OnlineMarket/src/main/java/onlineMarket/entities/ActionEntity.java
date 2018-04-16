package onlineMarket.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ActionEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String type;
	private String prodName;
	private String storeName;	
	private String firstOwner,colla;
	private Integer amount;
	private double price,oldPrice;
	
	
	public ActionEntity() {
		
	}

	public ActionEntity( String type, String prodName, String storeName, String firstOwner, Integer amount,double price,double old,String colla) {
		this.type = type;
		this.prodName = prodName;
		this.storeName = storeName;
		this.firstOwner = firstOwner;
		this.amount = amount;
		this.price = price;
		this.oldPrice=old;
		this.colla=colla;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getFirstOwner() {
		return firstOwner;
	}
	public void setFirstOwner(String firstOwner) {
		this.firstOwner = firstOwner;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	public double getOldPrice() {
		return oldPrice;
	}

	public void setOldPrice(double oldPrice) {
		this.oldPrice = oldPrice;
	}

	public String getColla() {
		return colla;
	}

	public void setColla(String colla) {
		this.colla = colla;
	}
}
