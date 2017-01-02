<?php

function connectDB(){
	global $mysqli;
	
	$mysqli = #hidden
	
	if (mysqli_connect_errno()){
		printf("Connection failed: %s\n", mysqli_connect_errno());
		exit();
	}
}

?>
