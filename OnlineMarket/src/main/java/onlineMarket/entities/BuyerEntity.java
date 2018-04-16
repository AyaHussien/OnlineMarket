package onlineMarket.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BuyerEntity extends UserEntity 
{
	public BuyerEntity() {}
	public BuyerEntity(String email,String pass)
	{
		setEmail(email);
		setPassword(pass);
		
	}

}
