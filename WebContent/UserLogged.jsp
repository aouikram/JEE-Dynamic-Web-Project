   <%@ page language="java" 
         contentType="text/html; charset=windows-1256"
         pageEncoding="windows-1256"
         import="entity.UserBean"
   %>

<!DOCTYPE html>
 
<html>
<head>
        	<link rel="stylesheet" href="css/LoggedStyle.css"/>       	
      </head>
      
     
    <section class="services" id="services">
     <body>
        <div class="max-width">
            <h2 class="title"><% UserBean currentUser = (UserBean) (session.getAttribute("currentSessionUser"));%>
		Welcome	<%= currentUser.getFirstName() + " " + currentUser.getLastName() %></h2>
            <div class="serv-content">
              
                <div class="card">
                    <a href="index.jsp">
                    <div class="box">
                        <i class="fas fa-paint-brush"></i>
                        <div class="text">Administration</div>
                    </div>
                    </a>
                </div>
                <div class="card">
                <a href="index2.jsp">
                    <div class="box">
                        <i class="fas fa-chart-line"></i>
                        <div class="text">Order</div>
                    </div>
                     </a>
               </div>
            </div>
        </div>
        	</body>
    </section>

</html>