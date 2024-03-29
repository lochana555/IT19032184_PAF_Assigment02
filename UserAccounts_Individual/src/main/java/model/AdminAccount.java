package model;

import java.sql.*;

public class AdminAccount {
	// A common method to connect to the DB
		private Connection connect() {
			Connection con = null;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				// Provide the correct details: DBServer/DBName, username, password
				con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/user_account_service", "root", "");
			}

			catch (Exception e) {
				e.printStackTrace();
			}

			return con;
		}

		// Inserting details to the user account
		// create user account

		public String insertAdminDetails(String UserName, String Password, String Email, String Age, String Address) {
			
			String output = "";
			
			try {
				Connection con = connect();
				if (con == null) {
					return "Error while connecting to the database for inserting.";
				}

				// insert elements to database
				String query = " insert into admin_account(`uid`,`uname`,`password`,`email`,`age`,`address`)"
						+ " values(?, ?, ?, ?, ?, ?)";
				PreparedStatement preparedStmt = con.prepareStatement(query);

				// binding values
				preparedStmt.setInt(1, 0);
				preparedStmt.setString(2, UserName);
				preparedStmt.setString(3, Password);
				preparedStmt.setString(4, Email);
				preparedStmt.setInt(5, Integer.parseInt(Age));
				preparedStmt.setString(6, Address);
				

				// execute the statement
				preparedStmt.execute();
				con.close();
				String newAdmin = readAdminDetails();
				output = "{\"status\":\"success\", \"data\": \"" +
						newAdmin + "\"}";
			}

			catch (Exception e) {
				output = "{\"status\":\"error\", \"data\":\"Error while inserting Admin Details.\"}";
				System.err.println(e.getMessage());
			}

			return output;
		}

		// reading user account details
		public String readAdminDetails() {
			String output = "";
			try {
				Connection con = connect();
				if (con == null) {
					return "Error while connecting to the database for reading.";
				}

				// Prepare the html table to be displayed
				output = "<table border='1'><tr>" + "<th>Admin Name</th>" + "<th>Password</th>"
						+ "<th>Email</th>" + "<th>Age</th>" + "<th>Address</th>"
						
						  +"<th>Update</th>" + "<th>Remove</th>"
						 
						+ "</tr>";
				String query = "select * from admin_account";
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(query);

				// iterate through the rows in the result set
				while (rs.next()) {
					String uid = Integer.toString(rs.getInt("uid"));
					String uname = rs.getString("uname");
					String password = rs.getString("password");
					String email = rs.getString("email");
					String age = Integer.toString(rs.getInt("age"));
					String address = rs.getString("address");
					

					// Add into the html table
					output += "<tr><td><input id='hidUIDUpdate'name='hidUIDUpdate'type='hidden' value='" + uid+ "'>" 
							+ uname + "</td>";
					output += "<td>" + password + "</td>";
					output += "<td>" + email + "</td>";
					output += "<td>" + age + "</td>";
					output += "<td>" + address + "</td>";
					

					//buttons
					output += "<td><input name='btnUpdate'type='button' value='Update'class='btnUpdate btn btn-secondary'></td>"+ "<td><input name='btnRemove'type='button' value='Remove'class='btnRemove btn btn-danger'data-uid='"
							+ uid + "'>" + "</td></tr>";
				}

				con.close();
				// Complete the html table
				output += "</table>";
			}

			catch (Exception e) {
				output = "Error while reading the profile details.";
				System.err.println(e.getMessage());
			}

			return output;
		}

		// update profile details

		public String updateAdminDetails(String UId, String UserName, String Password, String Email, String Age, String Address) {
			String output = "";
			try {
				Connection con = connect();
				if (con == null) {
					return "Error while connecting to the database for updating.";
				}

				// create a prepared statement
				String query = "UPDATE admin_account SET uname=?,password=?,email=?,age=?,address=? WHERE uid=?";
				PreparedStatement preparedStmt = con.prepareStatement(query);

				// binding values
				preparedStmt.setString(1, UserName);
				preparedStmt.setString(2, Password);
				preparedStmt.setString(3, Email);
				preparedStmt.setInt(4, Integer.parseInt(Age));
				preparedStmt.setString(5, Address);
				preparedStmt.setInt(6, Integer.parseInt(UId));

				// execute the statement
				preparedStmt.execute();
				con.close();
				String newAdmin = readAdminDetails();
				output = "{\"status\":\"success\", \"data\": \"" +
						newAdmin + "\"}";
			} catch (Exception e) {
				output = "{\"status\":\"error\", \"data\":\"Error while updating Admin Details.\"}";
				System.err.println(e.getMessage());
			}

			return output;
		}

		// Delete user profile

		public String deleteAdminDetails(String uid)
			{
				String output = "";
				try
				{
					Connection con = connect();
					if (con == null)
					{
						return "Error while connecting to the database for deleting.";
					}
					// create a prepared statement
					
					String query = "delete from admin_account where uid=?";
					PreparedStatement preparedStmt = con.prepareStatement(query);
					
					// binding values
					preparedStmt.setInt(1, Integer.parseInt(uid));
			
					// execute the statement
					preparedStmt.execute();
					con.close();
					String newAdmin = readAdminDetails();
					output = "{\"status\":\"success\", \"data\": \"" +
							newAdmin + "\"}";
				}
				catch (Exception e)
				{
					output = "{\"status\":\"error\", \"data\":\"Error while deleting Admin Details.\"}";
					System.err.println(e.getMessage());
				}
				
			return output;
			
			}

}
