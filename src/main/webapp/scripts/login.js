function FormValidation() {
    var fname = document.getElementsByName('fname')[0].value.trim();
    var lname = document.getElementsByName('lname')[0].value.trim();
    var password = document.getElementsByName('password')[0].value.trim();
    var confirmPassword = document.getElementsByName('confirm_password')[0].value.trim();
    
    var email = document.getElementsByName('email')[0].value.trim();
    
	

    // Simple validation checks
    if (fname === "" || password === "" || confirmPassword === "" || lname === "" || email === "" ) {
        alert("Please fill in all fields");
        console.log("khfvkfjv");
        return false;
    }

    if (password !== confirmPassword) {
        alert("Passwords do not match");
        return false;
    }

    // Check password strength
    var passwordPattern = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}$/;
    if (!passwordPattern.test(password)) {
        alert("Pease follow the password format");
        return false;
    }

    // Additional validation for email format
    var emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!emailPattern.test(email)) {
        alert("Please enter a valid email address");
        return false;
    }

  
	
	
    // If all validations pass, return true to submit the form
    return true;
}
