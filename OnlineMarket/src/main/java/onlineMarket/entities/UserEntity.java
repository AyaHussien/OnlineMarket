package onlineMarket.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserEntity {
	@Id
	private String Email;
	private String Password;
	private boolean flag;
	public UserEntity()
	{
		Email = "";
		Password = "";
		flag=false;
	}
	public UserEntity(String Email, String Password)
	{
		this.Email = Email;
		this.Password = Password;
		flag=false;
		
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String Email) {
		this.Email = Email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String Password) {
		this.Password = Password;
	}
	public boolean getFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	

}
