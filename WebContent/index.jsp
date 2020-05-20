<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BMR and Calorie Calculator</title>
</head>
<body>

<form action="Response" method="post">
Complete your information to get BMR and Calorie Maintenance <br>
<input type = 'radio' name = 'gender' value = 'Men' />Men <br>
<input type = 'radio' name = 'gender' value = 'Women'/>Women <br>
Weight in kg: <input type = 'number' name= 'weight' value = 'weight'/> <br>
Height in cm: <input type = 'number' name= 'height' value = 'height'/> <br>
Age: <input type = 'number' name= 'age' value = 'height'/> <br> 
<br> Choose your activity factor: <br>
<input type = 'radio' name = 'activity' value = 'sedentary' />sedentary <br>
<input type = 'radio' name = 'activity' value = 'lightly active' />light active <br>
<input type = 'radio' name = 'activity' value = 'moderately' />moderately <br>
<input type = 'radio' name = 'activity' value = 'very active' />very active <br>
<input type = 'radio' name = 'activity' value = 'extra active' />extra active <br>

<input type= "submit" value= "submit"/>
</form>



</body>
</html>