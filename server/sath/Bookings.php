<?php
	require_once("dbInfo.php");

	function addBookings($dest_st, $dest_ct, $date, $days, $user_id) {
		// Connect to database.
		$conn = mysqli_connect(getServer(), getUserName(), getPassword(), getDatabaseName());
		if(mysqli_connect_error()) {
			die("Could not connect to database. " . mysqli_connect_error());
		}

		// Insert query.
		$sql = "INSERT INTO `bookings`
				(
					`dest_st`,
					`dest_ct`,
					`date`,
					`days`,
					`user_id`
				)
				VALUES
				(
					?,
					?,
					STR_TO_DATE(?, '%m/%d/%Y'),
					?,
					?
				);";

		// Prepare statement.
		$stmt = mysqli_prepare($conn, $sql);
		if($stmt === false) {
			die("Invalid SQL specified. " . mysqli_error($conn));
		}

		// Bind parameters.
		mysqli_stmt_bind_param($stmt, 'sssii', $dest_st, $dest_ct, $date, $days, $user_id);

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
?>