package onlineMarket.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BrandEntity {
	@Id
	private String name;
	private String descreption;
	
	public String getName() {
		return name;
	}

	public BrandEntity(String name, String descreption) {
		super();
		this.name = name;
		this.descreption = descreption;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescreption() {
		return descreption;
	}

	public void setDescreption(String descreption) {
		this.descreption = descreption;
	}

	public BrandEntity() {}
	
}
