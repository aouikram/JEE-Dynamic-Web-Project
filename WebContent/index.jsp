<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="entity.Pizza"%>
<%@ page import="entity.Stock"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Administration Pizza</title>
<head>
	<link rel="stylesheet" href="css/AdminStyle.css"/>
</head>
<body>

  <div class="mainscreen">
    <!-- <img src="https://image.freepik.com/free-vector/purple-background-with-neon-frame_52683-34124.jpg"  class="bgimg " alt="">--> 
      <div class="card">
        <div class="leftside">

		
		<div class='order-info'>
          <div class='order-info-content'>
            <h2>Products in stock</h2>
             
				<% 
				List<Pizza> sessionObj =(List<Pizza>) request.getSession().getAttribute( "pizzaList" );
			      List<Pizza>  pizzaList = null;
				   if(sessionObj != null)
				    pizzaList=sessionObj;
				if (pizzaList !=null) {
				 for ( Pizza pizza : pizzaList ) { 
				 %>
				 <div class='line'></div>
                   <table class='order-table'>
                 <tbody>
				      <tr>
					<td>
                <br> <span class='thin'><%=pizza.getPizzaId()%></span> </td> </tr>
                <tr> <td>  <div class='price'><%=pizza.getPrix()%>DH</div>
              </td>
            </tr>
          </tbody>
           </table>
				<% }} %>
				
	
		</div>
        </div>
        </div>
        
        
        <div class="rightside">
          <form action="Admin_Pizza" method="POST">
            <h1>Enter new product</h1>
            <h2>Product Information</h2>
            
            <p>Name</p>
            <input type="text" class="inputbox" name="type" required />
            <p>Price</p>
            <input type="number" class="inputbox" name="prix" id="card_number" required />

            <p>Quantity</p>
            <input type="number" class="inputbox" name="quantite" id="card_number" required />

            <p></p>
            <button type="submit" class="button">Submit</button>
          </form>
          <h3>   </h3>
	<a href="index2.jsp">Make an order</a>
        </div>
      </div>
    </div>
  

	
</body>
</html>