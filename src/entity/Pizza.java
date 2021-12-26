package entity;
import java.io.Serializable;

public class Pizza implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String pizzaId;
	private Integer prix;
	public Pizza() {
		
	}
	public String getPizzaId() {
		return pizzaId;
	}
	public void setPizzaId(String pizzaId) {
		this.pizzaId=pizzaId;
	}
	public Integer getPrix() {
		return prix;
	}
	public void setPrix(Integer prix) {
		this.prix=prix;
	}

}
