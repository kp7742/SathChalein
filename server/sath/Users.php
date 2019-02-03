<?php
	require_once("dbInfo.php");

	function addUsers($name, $email, $password, $mobile, $trip_id, $companion_user_id, $guide_id) {
		// Connect to database.
		$conn = mysqli_connect(getServer(), getUserName(), getPassword(), getDatabaseName());
		if(mysqli_connect_error()) {
			die("Could not connect to database. " . mysqli_connect_error());
		}

		// Insert query.
		$sql = "INSERT INTO `users`
				(
					`Name`,
					`Email`,
					`Password`,
					`Mobile`,
					`trip_id`,
					`companion_user_id`,
					`guide_id`
				)
				VALUES
				(
					?,
					?,
					?,
					?,
					?,
					?,
					?
				);";

		// Prepare statement.
		$stmt = mysqli_prepare($conn, $sql);
		if($stmt === false) {
			die("Invalid SQL specified. " . mysqli_error($conn));
		}

		// Bind parameters.
		mysqli_stmt_bind_param($stmt, 'ssssiii', $name, $email, $password, $mobile, $trip_id, $companion_user_id, $guide_id);

		// Execute the statement.
		if(!mysqli_stmt_execute($stmt)) {
			die("Could not execute the statement. " . mysqli_stmt_error($stmt));
		}

		// Get value of the auto increment column.
		$newId = mysqli_insert_id($conn);

		// Close statement and connection.
		mysqli_stmt_close($stmt);
		mysqli_close($conn);

		// Return the id.
		return $newId;
	}

	function updateUsers($id, $name, $email, $password, $mobile, $trip_id, $companion_user_id, $guide_id) {
		// Connect to database.
		$conn = mysqli_connect(getServer(), getUserName(), getPassword(), getDatabaseName());
		if(mysqli_connect_error()) {
			die("Could not connect to database. " . mysqli_connect_error());
		}

		// Update query.
		$sql = "UPDATE	`users`
				SET		`Name` = ?,
						`Password` = ?,
						`Mobile` = ?,
						`trip_id` = ?,
						`companion_user_id` = ?,
						`guide_id` = ?
				WHERE	`Id` = ?
				AND		`Email` = ?;";

		// Prepare statement.
		$stmt = mysqli_prepare($conn, $sql);
		if($stmt === false) {
			die("Invalid SQL specified. " . mysqli_error($conn));
		}

		// Bind parameters.
		mysqli_stmt_bind_param($stmt, 'sssiiiis', $name, $password, $mobile, $trip_id, $companion_user_id, $guide_id, $id, $email);

		// Execute the statement.
		if(!mysqli_stmt_execute($stmt)) {
			die("Could not execute the statement. " . mysqli_stmt_error($stmt));
		}

		// Close statement and connection.
		mysqli_stmt_close($stmt);
		mysqli_close($conn);
	}

	function getUsers($id, $email) {
		// Connect to database.
		$conn = mysqli_connect(getServer(), getUserName(), getPassword(), getDatabaseName());
		if(mysqli_connect_error()) {
			die("Could not connect to database. " . mysqli_connect_error());
		}

		// Select query.
		$sql = "SELECT	`Id`,
						`Name`,
						`Email`,
						`Password`,
						`Mobile`,
						`trip_id`,
						`companion_user_id`,
						`guide_id`
				FROM	`users`
				WHERE	`Id` = ?
				AND		`Email` = ?;";

		// Prepare statement.
		$stmt = mysqli_prepare($conn, $sql);
		if($stmt === false) {
			die("Invalid SQL specified. " . mysqli_error($conn));
		}

		// Bind parameters.
		mysqli_stmt_bind_param($stmt, 'is', $id, $email);

		// Execute the statement.
		if(!mysqli_stmt_execute($stmt)) {
			die("Could not execute the statement. " . mysqli_stmt_error($stmt));
		}

		// Bind result and fetch the record.
		mysqli_stmt_bind_result($stmt, $id, $name, $email, $password, $mobile, $trip_id, $companion_user_id, $guide_id);
		if(mysqli_stmt_fetch($stmt)) {
			$record = Array(
				"Id" => $id,
				"Name" => $name,
				"Email" => $email,
				"Password" => $password,
				"Mobile" => $mobile,
				"trip_id" => $trip_id,
				"companion_user_id" => $companion_user_id,
				"guide_id" => $guide_id);
		} else {
			$record = NULL;
		}

		// Close statement and connection.
		mysqli_stmt_close($stmt);
		mysqli_close($conn);

		return $record;
	}

	function getData($email) {
		// Connect to database.
		$conn = mysqli_connect(getServer(), getUserName(), getPassword(), getDatabaseName());
		if(mysqli_connect_error()) {
			die("Could not connect to database. " . mysqli_connect_error());
		}

		// Select query.
		$sql = "SELECT	`Id`,
						`Name`,
						`Email`,
						`Password`,
						`Mobile`,
						`trip_id`,
						`companion_user_id`,
						`guide_id`
				FROM	`users`
				WHERE	`Email` = ?;";

		// Prepare statement.
		$stmt = mysqli_prepare($conn, $sql);
		if($stmt === false) {
			die("Invalid SQL specified. " . mysqli_error($conn));
		}

		// Bind parameters.
		mysqli_stmt_bind_param($stmt, 's', $email);

		// Execute the statement.
		if(!mysqli_stmt_execute($stmt)) {
			die("Could not execute the statement. " . mysqli_stmt_error($stmt));
		}

		// Bind result and fetch records.
		mysqli_stmt_bind_result($stmt, $id, $name, $email, $password, $mobile, $trip_id, $companion_user_id, $guide_id);
		$list = Array();
		while(mysqli_stmt_fetch($stmt)) {
			$record = Array(
				"Id" => $id,
				"Name" => $name,
				"Email" => $email,
				"Password" => $password,
				"Mobile" => $mobile,
				"trip_id" => $trip_id,
				"companion_user_id" => $companion_user_id,
				"guide_id" => $guide_id);

			array_push($list, $record);
		}

		// Close statement and connection.
		mysqli_stmt_close($stmt);
		mysqli_close($conn);

		return $list;
	}

	function getPass($email) {
		// Connect to database.
		$conn = mysqli_connect(getServer(), getUserName(), getPassword(), getDatabaseName());
		if(mysqli_connect_error()) {
			die("Could not connect to database. " . mysqli_connect_error());
		}

		// Select query.
		$sql = "SELECT	`Password`
				FROM	`users`
				WHERE	`Email` = ?;";

		// Prepare statement.
		$stmt = mysqli_prepare($conn, $sql);
		if($stmt === false) {
			die("Invalid SQL specified. " . mysqli_error($conn));
		}

		// Bind parameters.
		mysqli_stmt_bind_param($stmt, 's', $email);

		// Execute the statement.
		if(!mysqli_stmt_execute($stmt)) {
			die("Could not execute the statement. " . mysqli_stmt_error($stmt));
		}

		// Bind result and fetch records.
		mysqli_stmt_bind_result($stmt, $password);
		$list = Array();
		while(mysqli_stmt_fetch($stmt)) {
			$record = Array(
				"Password" => $password);

			array_push($list, $record);
		}

		// Close statement and connection.
		mysqli_stmt_close($stmt);
		mysqli_close($conn);

		return $list;
	}

	function isExist($email) {
		// Connect to database.
		$conn = mysqli_connect(getServer(), getUserName(), getPassword(), getDatabaseName());
		if(mysqli_connect_error()) {
			die("Could not connect to database. " . mysqli_connect_error());
		}

		// Select query.
		$sql = "SELECT	`Id`
				FROM	`users`
				WHERE	`Email` = ?;";

		// Prepare statement.
		$stmt = mysqli_prepare($conn, $sql);
		if($stmt === false) {
			die("Invalid SQL specified. " . mysqli_error($conn));
		}

		// Bind parameters.
		mysqli_stmt_bind_param($stmt, 's', $email);

		// Execute the statement.
		if(!mysqli_stmt_execute($stmt)) {
			die("Could not execute the statement. " . mysqli_stmt_error($stmt));
		}

		// Bind result and fetch records.
		mysqli_stmt_bind_result($stmt, $id);
		$list = Array();
		while(mysqli_stmt_fetch($stmt)) {
			$record = Array(
				"Id" => $id);

			array_push($list, $record);
		}

		// Close statement and connection.
		mysqli_stmt_close($stmt);
		mysqli_close($conn);

		return $list;
	}
?>