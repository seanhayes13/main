<?php
    //addentry.php
include ("connect_database.php");
connectDB();

if ((!$_POST) || (isset($_GET["master_id"]) != "")) {
	$display_block = "
	<form method=\"post\" action=\"".$_SERVER['PHP_SELF']."\">";
	
	if (isset($_GET['master_id'])) {
		$safe_id = mysqli_real_escape_string($mysqli, $_GET['master_id']);
		
		$get_names_sql = "SELECT concat_ws(' ', f_name, l_name) as display_name
			FROM master_table WHERE id = '".$safe_id."'";
		$get_names_result = mysqli_query($mysqli, $get_names_sql)
			or die(mysqli_error($mysqli));
		
		if (mysqli_num_rows($get_names_result) == 1) {
			while ($name_info = mysqli_fetch_array($get_names_result)) {
				$display_name = stripslashes($name_info['display_name']);
			}
		}
	}
	
	if (isset($display_name)) {
		$display_block .="<p>Adding information for <strong>$display_name</strong>:</p>";
	} else {
		$display_block .= <<<END_OF_TEXT
		<fieldset>
		<legend>Frst/Last Name:</legend><br/>
		<input type="text" name="f_name" size="30" maxlength="75" required="required" />
		<input type="text" name="l_name" size="30" maxlength="75" required="required" />
		</fieldset>
END_OF_TEXT;
	}
	
	$display_block .= <<<END_OF_TEXT
		
	<p><label for="address">Street Address:</label><br/>
	<input type="text" id="address" name="address" size="30"/></p>
	
	<fieldset>
	<legend>City/State/Zip:</legend>
	<input type="text" name="city" size="30" maxlength="50"/>
	<input type="text" name="state" size="2" maxlength="2"/>
	<input type="text" name="zipcode" size="10" maxlength="10"/>
	</fieldset>
	
	<fieldset>
	<legend>Address Type:</legend>
	<input type="radio" id="add_type_h" name="add_type" value="home" checked />
	<label for="add_type_h">Home</label>
	<input type="radio" id="add_type_w" name="add_type" value="work" />
	<label for="add_type_w">Work</label>
	<input type="radio" id="add_type_o" name="add_type" value="other" />
	<label for="add_type_o">Other</label>
	</fieldset>
	
	<fieldset>
	<legend>Telephone Number:</legend><br/>
	<input type="text" name="tel_number" size="30" maxlength="25"/>
	<input type="radio" id="tel_type_h" name="tel_type" value="home" checked />
	<label for="tel_type_h">Home</label>
	<input type="radio" id="tel_type_w" name="tel_type" value="work" />
	<label for="tel_type_w">Work</label>
	<input type="radio" id="tel_type_o" name="tel_type" value="other" />
	<label for="tel_type_o">Other</label>
	</fieldset>
	
	<fieldset>
	<legend>Email Address:</legend><br/>
	<input type="text" name="email" size="30" maxlength="25"/>
	<input type="radio" id="email_type_h" name="email_type" value="home" checked />
	<label for="email_type_h">Home</label>
	<input type="radio" id="email_type_w" name="email_type" value="work" />
	<label for="email_type_w">Work</label>
	<input type="radio" id="email_type_o" name="email_type" value="other" />
	<label for="email_type_o">Other</label>
	</fieldset>
	
	<p><label for="note">Personal Note:</label><br/>
	<textarea id="note" name="note" cols="35" rows="3"></textarea></p>
	
END_OF_TEXT;

    if ($_GET) {
        $display_block .= "<input type=\"hidden\" name=\"master_id\"
           value=\"".$_GET['master_id']."\">";
    }

	$display_block .= <<<END_OF_TEXT
	<button type="submit" name="submit" value="send">Add Entry</button>
	</form>
END_OF_TEXT;

} else if ($_POST) {
	if((((isset($_POST['f_name']) == "")) || (isset($_POST['l_name']) == "")) && (!isset($_POST['master_id']))) {
		header("Location: addentry.php");
		exit;
	}
	
	connectDB();
	
	//Create safe versions of all entries
	if (!empty($_POST['f_name'])){
		$safe_f_name = mysqli_real_escape_string($mysqli, $_POST['f_name']);
	}
	if (!empty($_POST['l_name'])){
		$safe_l_name = mysqli_real_escape_string($mysqli, $_POST['l_name']);
	}	
	$safe_address = mysqli_real_escape_string($mysqli, $_POST['address']);
	$safe_city = mysqli_real_escape_string($mysqli, $_POST['city']);
	$safe_state = mysqli_real_escape_string($mysqli, $_POST['state']);
	$safe_zipcode = mysqli_real_escape_string($mysqli, $_POST['zipcode']);
	$safe_tel_number = mysqli_real_escape_string($mysqli, $_POST['tel_number']);
	$safe_email = mysqli_real_escape_string($mysqli, $_POST['email']);
	$safe_note = mysqli_real_escape_string($mysqli, $_POST['note']);
	
    if (!isset($_POST['master_id'])) {
		//add to the master table
		$add_master_sql = "INSERT INTO master_table (date_added, date_modified, f_name, l_name)
			VALUES (now(), now(), '".$safe_f_name."', '".$safe_l_name."')";
		$add_master_results = mysqli_query($mysqli, $add_master_sql)
			or die(mysqli_error($mysqli));
		
		$master_id = mysqli_insert_id($mysqli);
	} else {
		$master_id = mysqli_real_escape_string($mysqli, $_POST['master_id']);
	}
	
	
	if (($_POST['address']) || ($_POST['city']) || 
	($_POST['state']) || ($_POST['zipcode'])) {
		$add_address_sql = "INSERT INTO address (master_id,
			date_added, date_modified, address, city, state, zipcode, type)
			VALUES ('".$master_id."', now(), now(), '".$safe_address."', '".$safe_city."',
			'".$safe_state."','".$safe_zipcode."', '".$_POST['add_type']."')";
		$add_address_results = mysqli_query($mysqli, $add_address_sql)
			or die(mysqli_error($mysqli));
	}
	
	if ($_POST['tel_number']) {
		$add_tel_sql = "INSERT INTO telephone (master_id,
			date_added, date_modified, tel_number, type) VALUES
			('".$master_id."', now(), now(), '".$safe_tel_number."', '".$_POST['tel_type']."')";
		$add_tel_results = mysqli_query($mysqli, $add_tel_sql)
			or die(mysqli_error($mysqli));
	}
	
	if ($_POST['email']) {
		$add_email_sql = "INSERT INTO email (master_id,
			date_added, date_modified, email, type) VALUES
			('".$master_id."', now(), now(), '".$safe_email."', '".$_POST['email_type']."')";
		$add_email_results = mysqli_query($mysqli, $add_email_sql)
			or die(mysqli_error($mysqli));
	}
	
	if ($_POST['note']) {
		$add_notes_sql = "UPDATE personal_notes set note = '".$safe_note."',
			date_modified = now() WHERE master_id = '".$master_id."'";
	}
	
	mysqli_close($mysqli);
	
	$display_block = "<p>Your entry has been added. Would you like to 
		<a href=\"addentry.php\">add another</a>?</p>";
}

?>

<html>
<head>
	<title>Add an Entry</title>
</head>
<body>
	<h1>Add an Entry</h1>
	<?php echo $display_block; ?>
	<a href="/addressmenu.html">Return to the Main Menu</a>
</body>
</html>
