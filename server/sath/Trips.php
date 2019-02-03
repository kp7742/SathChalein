<?php
	require_once("dbInfo.php");

	function addTrips($dest_st, $dest_ct, $user_id, $date, $days) {
		// Connect to database.
		$conn = mysqli_connect(getServer(), getUserName(), getPassword(), getDatabaseName());
		if(mysqli_connect_error()) {
			die("Could not connect to database. " . mysqli_connect_error());
		}

		// Insert query.
		$sql = "INSERT INTO `trips`
				(
					`dest_st`,
					`dest_ct`,
					`user_id`,
					`date`,
					`days`
				)
				VALUES
				(
					?,
					?,
					?,
					STR_TO_DATE(?, '%m/%d/%Y'),
					?
				);";

		// Prepare statement.
		$stmt = mysqli_prepare($conn, $sql);
		if($stmt === false) {
			die("Invalid SQL specified. " . mysqli_error($conn));
		}

		// Bind parameters.
		mysqli_stmt_bind_param($stmt, 'ssisi', $dest_st, $dest_ct, $user_id, $date, $days);

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

	function updateTrips($trip_id, $dest_st, $dest_ct, $user_id, $date, $days) {
		// Connect to database.
		$conn = mysqli_connect(getServer(), getUserName(), getPassword(), getDatabaseName());
		if(mysqli_connect_error()) {
			die("Could not connect to database. " . mysqli_connect_error());
		}

		// Update query.
		$sql = "UPDATE	`trips`
				SET		`dest_st` = ?,
						`dest_ct` = ?,
						`user_id` = ?,
						`date` = STR_TO_DATE(?, '%m/%d/%Y'),
						`days` = ?
				WHERE	`trip_id` = ?;";

		// Prepare statement.
		$stmt = mysqli_prepare($conn, $sql);
		if($stmt === false) {
			die("Invalid SQL specified. " . mysqli_error($conn));
		}

		// Bind parameters.
		mysqli_stmt_bind_param($stmt, 'ssisii', $dest_st, $dest_ct, $user_id, $date, $days, $trip_id);

		// Execute the statement.
		if(!mysqli_stmt_execute($stmt)) {
			die("Could not execute the statement. " . mysqli_stmt_error($stmt));
		}

		// Close statement and connection.
		mysqli_stmt_close($stmt);
		mysqli_close($conn);
	}

	function deleteTrips($trip_id) {
		// Connect to database.
		$conn = mysqli_connect(getServer(), getUserName(), getPassword(), getDatabaseName());
		if(mysqli_connect_error()) {
			die("Could not connect to database. " . mysqli_connect_error());
		}

		// Delete query.
		$sql = "DELETE	FROM `trips`
				WHERE	`trip_id` = ?;";

		// Prepare statement.
		$stmt = mysqli_prepare($conn, $sql);
		if($stmt === false) {
			die("Invalid SQL specified. " . mysqli_error($conn));
		}

		// Bind parameters.
		mysqli_stmt_bind_param($stmt, 'i', $trip_id);

		// Execute the statement.
		if(!mysqli_stmt_execute($stmt)) {
			die("Could not execute the statement. " . mysqli_stmt_error($stmt));
		}

		// Close statement and connection.
		mysqli_stmt_close($stmt);
		mysqli_close($conn);
	}

	function getTrips($trip_id) {
		// Connect to database.
		$conn = mysqli_connect(getServer(), getUserName(), getPassword(), getDatabaseName());
		if(mysqli_connect_error()) {
			die("Could not connect to database. " . mysqli_connect_error());
		}

		// Select query.
		$sql = "SELECT	`trip_id`,
						`dest_st`,
						`dest_ct`,
						`user_id`,
						DATE_FORMAT(`date`, '%m/%d/%Y') AS date,
						`days`
				FROM	`trips`
				WHERE	`trip_id` = ?;";

		// Prepare statement.
		$stmt = mysqli_prepare($conn, $sql);
		if($stmt === false) {
			die("Invalid SQL specified. " . mysqli_error($conn));
		}

		// Bind parameters.
		mysqli_stmt_bind_param($stmt, 'i', $trip_id);

		// Execute the statement.
		if(!mysqli_stmt_execute($stmt)) {
			die("Could not execute the statement. " . mysqli_stmt_error($stmt));
		}

		// Bind result and fetch the record.
		mysqli_stmt_bind_result($stmt, $trip_id, $dest_st, $dest_ct, $user_id, $date, $days);
		if(mysqli_stmt_fetch($stmt)) {
			$record = Array(
				"trip_id" => $trip_id,
				"dest_st" => $dest_st,
				"dest_ct" => $dest_ct,
				"user_id" => $user_id,
				"date" => $date,
				"days" => $days);
		} else {
			$record = NULL;
		}

		// Close statement and connection.
		mysqli_stmt_close($stmt);
		mysqli_close($conn);

		return $record;
	}
?>