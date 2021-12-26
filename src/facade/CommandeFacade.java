package facade;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import entity.Commande;
import entity.Pizza;
import entity.Stock;

public class CommandeFacade {
	
	private StockFacade stockFacade = new StockFacade();
	private PizzaFacade pizzaFacade = new PizzaFacade();
	
	public Boolean CheckType( HttpServletRequest request) {
		 String type=request.getParameter("type");

			 Pizza pizza = pizzaFacade.find(type,request);
	          if(pizza!=null) return true;
	          else return false ;

	}

	
	public Boolean Compare(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String type=request.getParameter("type");
		int quantite=new Integer(request.getParameter("quantite"));
		
		@SuppressWarnings("unchecked")
		List<Stock> lStock= (List<Stock>) session.getAttribute("StockList");
		if(lStock!=null)
		{
			 for (@SuppressWarnings("rawtypes")
				Iterator it = lStock.iterator(); it.hasNext();) {
				 Stock stockBean = (Stock) it.next();
					 if(stockBean.getPizzaId().equals(type))
					       { Integer stockQuantite = stockBean.getQuantite();
					         if(stockQuantite==0)
					        	 return false ; 
					         else {
					          if (stockQuantite>=quantite)
					        	  return true ; 
					          else 
					        	  return false ; 
					         }
						 
					       };
		                                                     }
		}
		return false ;
		}
	
	public int create(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		int quantite=new Integer(request.getParameter("quantite"));
		String type=request.getParameter("type");
		Pizza pizza = pizzaFacade.find(type,request);
		 int total = quantite * pizza.getPrix();
         Commande commande = new Commande();
         commande.setTotal(total);
         commande.setPizzaId(type);
         commande.setQuantite(quantite);
         commande.setEmail(request.getParameter("email"));
		@SuppressWarnings("unchecked")
		List<Commande> lCmd=(List<Commande>) session.getAttribute("lCmd");
		
		if(lCmd==null)
		{   
			lCmd=new ArrayList<Commande>();
			lCmd.add(commande);
			stockFacade.updateStock(commande,request);
		
		}
		else
			{lCmd.add(commande);
			stockFacade.updateStock(commande,request);
			
			}
		session.setAttribute("lCmd", lCmd);
		return total;
		
		
	}

}
