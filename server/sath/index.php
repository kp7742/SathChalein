<?php
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "sath";

// Create connection
$conn = mysqli_connect($servername, $username, $password, $dbname);

// Check connection
if (!$conn) {
    die("Connection failed: " . mysqli_connect_error());
}

$someJSON = [
    "msg"   => "You Are not Registered Yet",
    "statuscode" => "-1"
  ];

echo json_encode($someJSON);
?>