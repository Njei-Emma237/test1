<?php
// Check if the user is already logged in
if (isset($_SESSION['username'])) {
// The user is already logged in, redirect them to the home page
header("Location: /");
}

// Check if the form has been submitted
if ($_SERVER['REQUEST_METHOD'] == "POST") {
// Get the username and password from the form
$username = $_POST['username'];
$password = $_POST['password'];

// Check if the username and password are correct
$sql = "SELECT * FROM users WHERE username = '$username' AND password = '$password'";
$result = mysqli_query($conn, $sql);

if (mysqli_num_rows($result) > 0) {
// The username and password are correct, log the user in
$_SESSION['username'] = $username;
header("Location: /");
} else {
// The username and password are incorrect, show an error message
echo "Invalid username or password";
}
}
?>