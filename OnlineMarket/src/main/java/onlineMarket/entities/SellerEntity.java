package onlineMarket.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class SellerEntity extends UserEntity 
{
	
	public SellerEntity() {}
	public SellerEntity(String email,String pass)
	{
		setEmail(email);
		setPassword(pass);	
	}
}
