package facade;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import entity.Commande;
import entity.Stock;

public class StockFacade {
	public void createStock(Stock stockBean, HttpServletRequest request) {
		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		List<Stock> lStock=(List<Stock>) session.getAttribute("StockList");
		if(lStock==null)
		{
			lStock=new ArrayList<Stock>();
			lStock.add(stockBean);
			
		}
		else
			{lStock.add(stockBean);}
		session.setAttribute("StockList", lStock);
		
	}
	
	public Integer updateStock(Commande commande, HttpServletRequest request) {
		 
		HttpSession session = request.getSession();
		
		@SuppressWarnings("unchecked")
		List<Stock> lStock=(List<Stock>) session.getAttribute("StockList");
		if(lStock!=null)
		{
			for(Iterator<Stock> it = lStock.iterator(); it.hasNext();) {
				 Stock stockBean = (Stock) it.next();
				 String stockId=stockBean.getPizzaId();
				 if(stockId.equals(commande.getPizzaId())) 
				 { Integer stockQuantite=stockBean.getQuantite();
				     lStock.remove(stockBean);
				     Stock newStockBean = new Stock();
				     newStockBean.setPizzaId(stockId);
				    newStockBean.setQuantite(stockQuantite-commande.getQuantite());
				       createStock(newStockBean,request);
				    return 1 ; 
				    }		 
		       }return 0 ;
		
	   }
		else 
		     return 0;

	}
}
