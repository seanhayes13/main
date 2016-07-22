<?php
    include ("connect_movieDB.php");
    connectDB();
        $display_block = "<h1>Populate Movie-Actor table</h1></br>
        <p>Select a movie and select the actors</p>";
        $get_movie_sql = "SELECT id , movie_title, movie_releasedate FROM movies WHERE id NOT IN (SELECT movie_id FROM movie_actor) ORDER BY movie_title asc";
        $get_movie_results = mysqli_query($mysqli, $get_movie_sql) or die(mysqli_error($mysqli));
        $get_actor_sql = "SELECT id as actor_id, CONCAT_WS(' ', f_name, l_name) AS display_name FROM actors ORDER BY l_name asc, f_name asc";
        $get_actor_results = mysqli_query($mysqli, $get_actor_sql) or die(mysqli_error($mysqli));
        if ((mysqli_num_rows($get_movie_results) < 1) || (mysqli_num_rows($get_actor_results) < 1)) {
            $display_block .= "<p><em>Did we forget to populate the database?</em></p>";
        } else {
        $display_block .= "
		<form method=\"post\" action=\"".$_SERVER['PHP_SELF']."\">
		<p><label for=\"sel_movie\">Select a movie:</label></br>
		<select id=\"sel_movie\" size=\"10\" name=\"sel_movie[]\" required=\"required\" multiple=\"multiple\">
		<option value=\"\">--Select a Movie--</option>";
		while ($movies = mysqli_fetch_array($get_movie_results)) {
			$movieid = $movies['id'];
			$display_movie_title = stripslashes($movies['movie_title']);
            $display_moviedate = stripslashes($movies['movie_releasedate']);
			$display_block .="<option value=\"".$movieid."\">".$display_movie_title." - (".$display_moviedate.")</option>";
		}
        $display_block .= "
        </select></br>
        <p><label for \"sel_actor\">Select the actors in the movie:</label></br>
        <select id=\"sel_actor\" size=\"10\" name=\"sel_actor[]\" required=\"required\" multiple=\"multiple\">
        <option value=\"\">--Select actor(s)--</option>";
        while ($actors = mysqli_fetch_array($get_actor_results)) {
            $actorid = $actors['actor_id'];
            $display_actor_name = stripslashes($actors['display_name']);
            $display_block .="<option value=\"".$actorid."\">".$display_actor_name."</option>";
        }
		$display_block .="
		</select></p>
        
        <button = type=\"submit\" name=\"submit\" value=\"addtotable\">Add Relationship</button>
        <p><a href=\"\\movieDBmenu.html\">Return to the main menu</a></p>
		</form>";
        }
    if ($_POST) {
        if ((isset($_POST['sel_movie'])=="") || (isset($_POST['sel_actor'])=="")){
            header("location: populatema.php");
            exit;
        }
        connectDB();
        $movie_array = $_POST['sel_movie'];
        $actor_array = $_POST['sel_actor'];
        foreach($movie_array as $m) {
            foreach($actor_array as $a) {
                $check_sql = "SELECT movie_id, actor_id FROM movie_actor WHERE movie_id ='".$m."' AND actor_id ='".$a."'";
                $check_results = mysqli_query($mysqli, $check_sql) or die(mysqli_error($mysqli));
                if (mysqli_num_rows($check_results) >= 1){
                    $display_block = "<p>That combination has already been entered</p>";
                    header("Location: populatema.php");
                    exit;
                } else{
                    $add_info_sql = "INSERT INTO movie_actor (movie_id, actor_id) VALUES ('".$m."', '".$a."')";
                $add_info_results = mysqli_query($mysqli, $add_info_sql) or die(mysqli_error($mysqli));
                header("Location: populatema.php");
                }
             }
        }
        mysqli_close($mysqli);
    }
?>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <title>Populate Data</title>
    </head>
    <body>
        <?php echo $display_block; ?>
        <p>Click <a href="populatemg.php">here</a> to populate Movie-Genre information</p>
    </body>
</html>