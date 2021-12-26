<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>

	<link rel="preconnect" href="https://fonts.gstatic.com">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;500;600&display=swap" rel="stylesheet">
	<link rel="stylesheet" href="css/loginStyle.css"/>
    <title>Login Page</title>
    
	</head>

	<body>
	 <div class="background">
	     <div class="shape"></div>
         <div class="shape"></div>
         </div>
    
		<form action="LoginServlet">
		<h3>Login Here</h3>
            
      
   
        <label for="username">Username</label>
        <input placeholder="Username" type="text" name="un" id="username">
	
		  
		  
        <label for="password">Password:</label>			
        <input placeholder="Password" type="password" name="pw" id="password">
	
        <button type="submit">Log In </button>		
		
		</form>
	</body>
</html>