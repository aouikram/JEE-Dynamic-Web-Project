package facade;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import entity.Pizza;

public class PizzaFacade {

	public void create(Pizza pizzaBean, HttpServletRequest request) {
		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		List<Pizza> lPizza=(List<Pizza>) session.getAttribute("PizzaList");
		if(lPizza==null)
		{
			lPizza=new ArrayList<Pizza>();
			lPizza.add(pizzaBean);
			
		}
		else
			{lPizza.add(pizzaBean);}
		session.setAttribute("PizzaList", lPizza);
	
	}

	@SuppressWarnings({ "unchecked" })
	public List<Pizza> getAllPizzas(HttpServletRequest request) {
		HttpSession session = request.getSession();
		return (List<Pizza>) session.getAttribute("PizzaList");

}
	
	public Pizza find(String type, HttpServletRequest request) {
		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		List<Pizza> lPizza= (List<Pizza>) session.getAttribute("pizzaList");
		if(lPizza!=null)
		{
			 for (@SuppressWarnings("rawtypes")
				Iterator it = lPizza.iterator(); it.hasNext();) {
					 Pizza pizzaBean = (Pizza) it.next();
					 if(pizzaBean.getPizzaId().equals(type))
					       return pizzaBean;
		                                                     }
		}
		return null ;
	}
	
}
