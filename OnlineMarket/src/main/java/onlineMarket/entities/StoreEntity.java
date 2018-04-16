package onlineMarket.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class StoreEntity 
{
	@Id
	private String name;
	private String sellerName;
	private String location;
	private String type;
	public StoreEntity() {}
	public StoreEntity(String N,String S,String L,String T)
	{
		name=N;
		sellerName=S;
		location=L;
		type=T;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSellerName() {
		return sellerName;
	}
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
