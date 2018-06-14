<%-- 
    Document   : index
    Created on : 14-dic-2012, 11:11:09
    Author     : Walter
--%>

<?php

//Get Current User Login
global $current_user;
$current_user = wp_get_current_user();
$ulog = $current_user->user_login;
$tablename_db = "db_".$ulog;

mysql_select_db("data_base_name_here");

//Create Table If It Does Not Exist
$sql = "CREATE TABLE IF NOT EXISTS $tablename_db (
ID int NOT NULL AUTO_INCREMENT,
PRIMARY KEY(ID),
db_num int,
db_amnt int
);";

mysql_query($sql); ?>

<html>
<body>

<form action="DirectBill.php" method="post">
<fieldset>
<legend>Direct Bill Information:</legend>
DB #: <input type="int" name="db_num_1" /> DB Amount: <input type="int" name="db_amnt_1" /> </br>
<!--Above table entries is repeated 10 more times-->
<strong><!--<input type="hidden" name="user_name" value="user_login_ID>--></strong>
</fieldset>
<input type="submit" />
</form>

</body>
</html>