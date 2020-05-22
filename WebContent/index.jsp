<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BMR and Calorie Calculator</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
	integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
	crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
	integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
	crossorigin="anonymous"></script>

</head>
<body>

	<script>
		if ("${success}" == "false") {

			alert("${msg}");
		}
	</script>

	<h1>Complete your information to get BMR and Calorie
		Maintenance</h1>
	
	<br>
	<form action="Response" method="post">

		<div class="form-group">
			<label for="">Gender </label>
			<div class="custom-control custom-radio custom-control-inline">
				<input type="radio" name="gender" value="Men"
					class="custom-control-input" id="man"> <label
					class="custom-control-label" for="man">Male</label>
			</div>
			<div class="custom-control custom-radio custom-control-inline">
				<input type="radio" name="gender" value="Women"
					class="custom-control-input" id="woman"> <label
					class="custom-control-label" for="woman">Female</label>
			</div>

		</div>

		<div class="form-group">
			<label for="">Weight in kg:</label> <input type='number' min=1
				name='weight' class="form-control">
		</div>

		<div class="form-group">
			<label for="">Height in cm:</label> <input type='number' min=1
				name='height' class="form-control">
		</div>

		<div class="form-group">
			<label for="">Age:</label> <input type='number' min=1
				name='age' class="form-control">
		</div>


		<label for=""> Choose your activity level </label> <br>
		<div class="custom-control custom-radio">
			<input type="radio" name='activity' value='sedentary'
				class="custom-control-input" id="sedentary"> <label
				class="custom-control-label" for="sedentary">sedentary</label>
		</div>

		<div class="custom-control custom-radio">
			<input type="radio" name='activity' value='light active'
				class="custom-control-input" id="light active"> <label
				class="custom-control-label" for="light active">light active</label>
		</div>

		<div class="custom-control custom-radio">
			<input type='radio' name='activity' value='moderately'
				class="custom-control-input" id="moderately"> <label
				class="custom-control-label" for="moderately">moderately</label>
		</div>

		<div class="custom-control custom-radio">
			<input type="radio" name='activity' value='very active'
				class="custom-control-input" id="" very active> <label
				class="custom-control-label" for="very active">very active</label>
		</div>

		<div class="custom-control custom-radio">
			<input type="radio" name='activity' value='extra active'
				class="custom-control-input" id="extra active"> <label
				class="custom-control-label" for="extra active">extra active</label>
		</div>



		<div class="form-group">
			<input type="submit" class="btn btn-primary" value="submit" />
		</div>
	</form>




	<h1>Result</h1>
	<p style="color:red">BMR:${bmr}</p>
	
	<p style="color:blue">Calorie Maintenance:${calorie}</p>
	
	<br> 
	<br>


</body>
</html>