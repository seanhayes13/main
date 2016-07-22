<?php

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
			value=\"delete\">Delete Selected Entry</button>
		</form>";
	}
	
	mysqli_free_result($get_list_results);
} else if ($_POST) {
	if ($_POST['sel_id'] == "") {
		header("Location:delentry.php");
		exit;
	}
	
	$safe_id = mysqli_real_escape_string($mysqli, $_POST['sel_id']);
	
	$del_master_sql = "DELETE FROM master_table WHERE id = '".$safe_id."'";
	$del_master_results = mysqli_query($mysqli, $del_master_sql)
		or die(mysqli_error($mysqli));
		
	$del_address_sql = "DELETE FROM address WHERE id = '".$safe_id."'";
	$del_address_results = mysqli_query($mysqli, $del_address_sql)
		or die(mysqli_error($mysqli));
		
	$del_telephone_sql = "DELETE FROM telephone WHERE id = '".$safe_id."'";
	$del_telephone_results = mysqli_query($mysqli, $del_telephone_sql)
		or die(mysqli_error($mysqli));
		
	$del_email_sql = "DELETE FROM email WHERE id = '".$safe_id."'";
	$del_email_results = mysqli_query($mysqli, $del_email_sql)
		or die(mysqli_error($mysqli));
		
	$del_note_sql = "DELETE FROM personal_notes WHERE id = '".$safe_id."'";
	$del_note_results = mysqli_query($mysqli, $del_note_sql)
		or die(mysqli_error($mysqli));
		
	mysqli_close($mysqli);
	
	$display_block ="<h1>Record(s) deleted</h1><br/>
	<p>Would you like to
	<a href=\"".$_SERVER['PHP_SELF']."\">delete another</a>?</p>";
}



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
