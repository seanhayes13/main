<?php
//selentry.php
include 'connect_database.php';

connectDB();

if (!$_POST) {
	$display_block = "<h1>Select and Entry</h1>";
	
	$get_list_sql = "SELECT id, CONCAT_WS(', ', l_name, f_name) AS display_name
		FROM master_table ORDER by l_name, f_name";
	$get_list_results = mysqli_query($mysqli, $get_list_sql)
		or die(mysqli_error($mysqli));
		
	if (mysqli_num_rows($get_list_results) < 1) {
		$display_block .="<p><em>No results found</em></p>";
	} else {
		$display_block .="
		<form method=\"post\" action=\"".$_SERVER['PHP_SELF']."\">
		<p><label for=\"sel_id\">Select a Record:</label><br/>
		<select id=\"sel_id\" name=\"sel_id\" required=\"required\">
		<option value=\"\">-- Select One --</option>";
		
		while ($records = mysqli_fetch_array($get_list_results)) {
			$id = $records['id'];
			$display_name = stripslashes($records['display_name']);
			$display_block .="<option value=\"".$id."\">".$display_name."</option>";
		}
		
		$display_block.="
		</select>
		<button type=\"submit\" name=\"submit\"
			value=\"view\">View Selected Entry</button>
		</form>";
	}
	
	mysqli_free_result($get_list_results);
} else if ($_POST) {
	if ($_POST['sel_id'] == "") {
		header("Location: selentry.php");
		exit;
	}
	
	$safe_id = mysqli_real_escape_string($mysqli, $_POST['sel_id']);
	
	$get_master_sql = "SELECT concat_ws(' ', f_name, l_name) as display_name 
		FROM master_table WHERE id = '".$safe_id."'";
	$get_master_results = mysqli_query($mysqli, $get_master_sql)
		or die(mysqli_error($mysqli));
	
	while ($name_info = mysqli_fetch_array($get_master_results)) {
		$display_name = stripslashes($name_info['display_name']);
	}
	
	$display_block = "<h1>Showing Record for ".$display_name."</h1>";
	
	mysqli_free_result($get_master_results);
	
	$get_addresses_sql = "SELECT address, city, state, zipcode, type FROM address
		WHERE master_id = '".$safe_id."'";
	$get_addresses_results = mysqli_query($mysqli, $get_addresses_sql)
		or die(mysqli_error($mysqli));
		
	if (mysqli_num_rows($get_addresses_results) > 0) {
		$display_block .= "<p><strong>Address:</strong><br/>
		<ul>";
		
		while ($add_info = mysqli_fetch_array($get_addresses_results)) {
			$address = stripslashes($add_info['address']);
			$city = stripslashes($add_info['city']);
			$state = stripslashes($add_info['state']);
			$zipcode = stripslashes($add_info['zipcode']);
			$address_type = $add_info['type'];
			
			$display_block .="<li>$address $city $state $zipcode ($address_type)</li>";
		}
		$display_block .="</ul>";
	}
	
	mysqli_free_result($get_addresses_results);
	
	$get_tel_sql = "SELECT tel_number, type FROM telephone WHERE master_id = '".$safe_id."'";
	$get_tel_results = mysqli_query($mysqli, $get_tel_sql)
		or die(mysqli_error($mysqli));
		
	if (mysqli_num_rows($get_tel_results) > 0) {
		$display_block .="<p><strong>Telephone:</strong><br/>
		<ul>";
		
		while ($tel_info = mysqli_fetch_array($get_tel_results)) {
			$tel_number = stripslashes($tel_info['tel_number']);
			$tel_type = $tel_info['type'];
			
			$display_block .= "<li>$tel_number ($tel_type)</li>";
		}
		$display_block .= "</ul>";
	}
	
	mysqli_free_result($get_tel_results);
	
	$get_email_sql = "SELECT email, type FROM email WHERE master_id = '".$safe_id."'";
	$get_email_results = mysqli_query($mysqli, $get_email_sql)
		or die(mysqli_error($mysqli));
		
	if (mysqli_num_rows($get_email_results) > 0) {
		$display_block .="<p><strong>Email:</strong><br/>
		<ul>";
		
		while ($email_info = mysqli_fetch_array($get_email_results)) {
			$email = stripslashes($email_info['email']);
			$email_type = $email_info['type'];
			
			$display_block .= "<li>$email ($email_type)</li>";
		}
		$display_block .= "</ul>";
	}
	
	mysqli_free_result($get_email_results);
	
	$get_notes_sql = "SELECT note FROM personal_notes WHERE master_id = '".$safe_id."'";
	$get_notes_results = mysqli_query($mysqli, $get_notes_sql)
		or die(mysqli_error($mysqli));
		
	if (mysqli_num_rows($get_notes_results) == 1) {
		while ($note_info = mysqli_fetch_array($get_notes_results)) {
			$note = nl2br(stripslashes($note_info['note']));
		}
		$display_block .="<p><strong>Personal Notes:</strong><br/>$note</p>";
	}
	
	mysqli_free_result($get_notes_results);
	
	$display_block .= "<br/>
	<p style=\"text-align: center\"><a href=\"addentry.php?master_id=".$_POST['sel_id']."\">add info</a> ...
	<a href=\"".$_SERVER['PHP_SELF']."\">select another</a></p>";
}

mysqli_close($mysqli);

?>

<html>
<head>
	<title>My Address Book</title>
</head>
<body>
	<?php echo $display_block; ?>
	<a href="/addressmenu.html">Return to the Main Menu</a>
</body>
</html>
