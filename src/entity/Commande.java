package entity;

import java.io.Serializable;

public class Commande implements Serializable {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer commandeId;
	 private Integer quantite;
	 private Integer total;
	 private String email;
	 private String pizzaId;
	 public Commande() {
	 }
		public Integer commandeId() {
			return commandeId;
		}
		public void setPrix(Integer commandeId) {
			this.commandeId=commandeId;
		}
		public Integer getQuantite() {
			return quantite;
		}
		public void setQuantite(Integer quantite) {
			this.quantite=quantite;
		}
		public Integer getTotal() {
			return total;
		}
		public void setTotal(Integer total) {
			this.total=total;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email=email;
		}
		public String getPizzaId() {
			return pizzaId;
		}
		public void setPizzaId(String pizzaId) {
			this.pizzaId=pizzaId;
		}

	}

