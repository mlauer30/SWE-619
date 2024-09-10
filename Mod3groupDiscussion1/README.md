## Module 3 - Group Discussion 1

1. Describe how would the attacker get access.
	- If a hacker passes a `null` value into `allowLogin()` they will be granted access to our system and will bypass the current login.
1. How would you modify `allowLogin()`, in order to prevent such attack?
	- Catching the null pointer exception will handle problems with bad input or with the hacker attempting to break the current method to gain access to our system. Instead of getting access to our system, the Java program will catch the bad input provided by the hacker, next give a message stating a bad input was handled and deny the malicious login request. Initializing `loggedIn` as `false` and fixing the condition statement to return true after checking that `pwd` is equal to `realPwd` will output a safer value as well.

`static boolean allowLogin(String user, String pwd){ 
	`boolean loggedIn = false; 
	`try{ 
		`String realPwd = getRealPwdFromDb(user); 
		`if(pwd.equals(realPwd)){ 
			`loggedIn = true; 
		`} 
	`}catch(NullPointerException e){ 
		`System.out.println("Null pointer handled");
	`} 
	`return loggedIn; 
`}`