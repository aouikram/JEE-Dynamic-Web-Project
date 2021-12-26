package administration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Pizza;
import entity.Stock;


@WebServlet("/Admin_Pizza")
public class Administration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Administration() {
        super();
    }



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 @SuppressWarnings("unchecked")
		List<Pizza> sessionObj =(List<Pizza>) request.getSession().getAttribute( "pizzaList" );
	      List<Pizza>  pizzaList = null;
	   if(sessionObj != null)
	    pizzaList=sessionObj;
				 String type=null;
				 type=request.getParameter("type");
				 if (type!=null) {
						 int prix=0;
						 prix=new Integer(request.getParameter("prix"));
						 int quantite=new Integer(request.getParameter("quantite"));
						 Pizza pizzaBean = new Pizza();
						 pizzaBean.setPizzaId(type);
						 pizzaBean.setPrix(prix);
							if(pizzaList==null)
							{
								pizzaList=new ArrayList<Pizza>();
							    pizzaList.add(pizzaBean);
								
							}
							else
								{pizzaList.add(pizzaBean);}
							request.getSession().setAttribute("pizzaList", pizzaList);
						
						 Stock stockBean = new Stock();
						 stockBean.setPizzaId(type);
						 stockBean.setQuantite(quantite);
						 @SuppressWarnings("unchecked")
						List<Stock> lStock=(List<Stock>) request.getSession().getAttribute("StockList");
							if(lStock==null)
							{
								lStock=new ArrayList<Stock>();
								lStock.add(stockBean);
								
							}
							else
								{lStock.add(stockBean);}
							request.getSession().setAttribute("StockList", lStock);
				 }
	this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
