package entity;

public class Stock {
	private Integer quantite;
	private String pizzaId;
	public Stock() {
		}
	public Integer getQuantite() {
		return quantite;
		}
	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}
	public String getPizzaId() {
		return pizzaId;
		}
	public void setPizzaId(String pizzaId) {
		this.pizzaId = pizzaId;
	}

}