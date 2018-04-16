package onlineMarket.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class SysProductEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private String brand;
	private double LowPrice,HighPrice;

	public SysProductEntity() {
		name=null;
		// TODO Auto-generated constructor stub
	}
	public SysProductEntity(String name, String brand, double lowPrice, double highPrice) {
		super();
		this.name = name;
		this.brand = brand;
		LowPrice = lowPrice;
		HighPrice = highPrice;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public double getLowPrice() {
		return LowPrice;
	}
	public void setLowPrice(double lowPrice) {
		LowPrice = lowPrice;
	}
	public double getHighPrice() {
		return HighPrice;
	}
	public void setHighPrice(double highPrice) {
		HighPrice = highPrice;
	}

}
