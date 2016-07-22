<?php

function connectDB(){
	global $mysqli;
	
	$mysqli = mysqli_connect("localhost", "root", "TWinOAks1#", "general_Info");
	
	if (mysqli_connect_errno()){
		printf("Connection failed: %s\n", mysqli_connect_errno());
		exit();
	}
}

?>