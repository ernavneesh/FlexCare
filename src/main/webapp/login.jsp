<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="css/login.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<input type="hidden" id="status" value="<%= request.getAttribute("status") %>">
<div class="col-md-12 root">
    <div class="col-md-8 container" id="container">
        <div class="form-container sign-up-container">
            <form action="register" method="post" id="signup-form" onsubmit="return FormValidation();">
                <h1>Create Account</h1>
                
                <div class="form-group">
                    <label for="fname">First Name:</label>
                    <input type="text" name="fname" class="form-control" placeholder="Enter your first name" />
                </div>
                <div class="form-group">
                    <label for="lname">Last Name:</label>
                    <input type="text" name="lname" class="form-control" placeholder="Enter your last name" />
                </div>
                <div class="form-group">
                    <label for="email">Email:</label>
                    <input type="email" name="email" class="form-control" placeholder="abc123@gmail.com" />
                </div>
                
                
                
                <div class="form-group">
                    <label for="password">Password:</label>
                    <input type="password" name="password" class="form-control" placeholder="Enter your password" title=" Contains at least one digit, 
                    one lowercase letter, one uppercase letters and 8 characters long." />
                </div>
                <div class="form-group">
                    <label for="confirm_password">Confirm Password:</label>
                    <input type="password" name="confirm_password" class="form-control" placeholder="Confirm your password" title=" Contains at least one digit, 
                    one lowercase letter, one uppercase letters and 8 characters long." />
                </div>
                <input type="submit" value="SUBMIT">
            </form>
            
            
        </div>
        <div class="form-container sign-in-container">
            <form action="Signin" method="post">
                <h1>Sign in</h1>
                <div class="form-group">
                    <label for="email">Email:</label>
                    <input type="email" name="uemail" class="form-control" placeholder="Your email id" />
                </div>
                <div class="form-group">
                    <label for="password">Password:</label>
                    <input type="password" name="upassword" class="form-control" placeholder="Your password" />
                </div>
                <button type="submit" class="btn btn-primary">Sign In</button>
            </form>
        </div>
        <div class="overlay-container">
            <div class="overlay">
                <div class="overlay-panel overlay-left">
                    <h1>Welcome Back!</h1>
                    <p>To keep connected with us please login with your personal info</p>
                    <button class="ghost" id="signIn">Sign In</button>
                </div>
                <div class="overlay-panel overlay-right">
                    <h1>Hello, Friend!</h1>
                    <p>Enter your personal details and start journey with us</p>
                    <button class="ghost" id="signUp">Sign Up</button>
                </div>
            </div>
        </div>
    </div>
</div>   
</body>

<script src="scripts/login.js"></script>	
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script type="text/javascript">
const signUpButton = document.getElementById('signUp');
const signInButton = document.getElementById('signIn');
const container = document.getElementById('container');

signUpButton.addEventListener('click', () => {
	container.classList.add("right-panel-active");
});

signInButton.addEventListener('click', () => {
	container.classList.remove("right-panel-active");
});
var status=document.getElementById("status").value;
console.log(status);
if(status == "success")
{
	Swal.fire({
		  title: "Good job!",
		  text: "You successfully created an account!",
		  icon: "success"
		});
	
}

if(status=="failed"){		
		Swal.fire({
			  title: "Sorry!",
			  text: "Try it again",
			  icon: "error"
			});
	

}

</script>

</html>