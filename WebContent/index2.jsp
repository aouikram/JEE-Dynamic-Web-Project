<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*"%>
<%@ page import="entity.Pizza"%>
<%@ page import="entity.Stock"%>
<%@ page import="entity.Commande"%>
<%@ page import="facade.CommandeFacade"%>
<%@ page import="facade.PizzaFacade"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/AdminStyle.css"/>
<meta charset="UTF-8">
<title>Make an order</title>
</head>
<body>

  <div class="mainscreen">
    <!-- <img src="https://image.freepik.com/free-vector/purple-background-with-neon-frame_52683-34124.jpg"  class="bgimg " alt="">--> 
      <div class="card">
        <div class="leftside">

		
		<div class='order-info'>
		 <div class='order-info-content'>
		 

 <%
     PizzaFacade pizzaFacade = new PizzaFacade();
     CommandeFacade commandeFacade = new CommandeFacade();
        
     List<Stock> sessionObj2 =(List<Stock>) request.getSession().getAttribute( "StockList" );
     List<Stock>  stockList = null;
     
         if(sessionObj2 != null)
	        stockList=sessionObj2;
         
        if(request.getParameter("type")!=null) {
        	
        if (commandeFacade.CheckType(request) == false) {
             %>
                  <h2>type inexistant</h2>
                  <br/>
            <% 
             } 
        else {
        	if (commandeFacade.Compare(request)==false) { %>
                      <h2>stock insufisant</h2>
                <% 
                }
        	else {   int total = commandeFacade.create(request);
                   %>
                          <h2>commande effectuée</h2>
                          <h4>Prix total : <%=total%></h4>
 
                   <%
                        }
                }
        }  %>
 

	   <h2>Available Products </h2>

				<% if (stockList !=null) {
				 for (  Stock stock : stockList ) { %>
				 <div class='line'> </div>
                   <table class='order-table'>
                 <tbody>
				      <tr>
					<td>
                <br> <span class='thin'><%=stock.getPizzaId()%></span> </td> </tr>
                <tr> <td>  <div class='price'> Stock : <%=stock.getQuantite()%></div>
              </td>
            </tr>
          </tbody>
           </table>
				<% } } %>
				
		</div>
        </div>
        </div>
				
	        <div class="rightside">
		<form action="index2.jsp" method="POST">
            <h1>Enter Product</h1>

            <p>Type</p>
            <input type="text" class="inputbox" name="type" required />


            <p>Quantity</p>
            <input type="number" class="inputbox" name="quantite" id="card_number" required />

            <p></p>
            <button type="submit" class="button">Submit</button>
			
         <br />


		
	</form>
	 </div>
      </div>
    </div>
  
</body>
</html>