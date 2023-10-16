package myPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.SQLException;

public class Student {

	public static void createDB() {
		// TODO Auto-generated method stub
		try {
			String url = "jdbc:mysql://127.0.0.1:3306/";
			String userName = "root";
			String password = "Manju";
			Connection con = DriverManager.getConnection(url,userName,password);
			Statement stm = con.createStatement();
			System.out.println("Connected Successfully!");
			String query = "create database man";
			stm.execute(query);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void createTb() {
		// TODO Auto-generated method stub
		try {
			String url = "jdbc:mysql://127.0.0.1:3306/practice";
			//String db = "practice";
			String userName = "root";
			String password = "Manju";
			Connection con = DriverManager.getConnection(url,userName,password);
			Statement stm = con.createStatement();
			String query = "create table student (sid int (3), sName varchar (200), sMail varchar(200))";
			stm.execute(query);
			System.out.print("Table Created Successfully!!! ");
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void createData() {
	    try {
	        String url = "jdbc:mysql://127.0.0.1:3306/practice";
	        String userName = "root";
	        String password = "Manju";
	        Connection con = DriverManager.getConnection(url, userName, password);

	        // Create a Scanner object to take user input
	        Scanner scanner = new Scanner(System.in);

	        // Get user input for the data to be inserted
	        System.out.print("Enter student ID: ");
	        int sid = scanner.nextInt();
	        scanner.nextLine();  // Consume the newline character
	        System.out.print("Enter student name: ");
	        String sName = scanner.nextLine();
	        System.out.print("Enter student email: ");
	        String sMail = scanner.nextLine();

	        // Define the SQL query with placeholders
	        String query = "INSERT into student (sid, sName, sMail) VALUES (?, ?, ?)";
	        PreparedStatement pstm = con.prepareStatement(query);

	        // Set the user-input values into the PreparedStatement
	        pstm.setInt(1, sid);
	        pstm.setString(2, sName);
	        pstm.setString(3, sMail);

	        // Execute the query to insert the data
	        pstm.executeUpdate();
	        System.out.println("Data Inserted Successfully!!!");

	        // Close resources
	        pstm.close();
	        con.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	public void readData() {
		// TODO Auto-generated method stub
		try {
			String url = "jdbc:mysql://127.0.0.1:3306/practice";
			//String db = "practice";
			String userName = "root";
			String password = "Manju";
			Connection con = DriverManager.getConnection(url,userName,password);
			String query = "SELECT * from student ";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(query);
			while(rs.next()) {
				System.out.println("id = "+rs.getInt(1));
				System.out.println("Name = "+rs.getString(2));
				System.out.println("E- Mail  = "+rs.getString(3));

			}
			System.out.print("Read Successfully!!! ");
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void updateData() {
	    try {
	        String url = "jdbc:mysql://127.0.0.1:3306/practice";
	        String userName = "root";
	        String password = "Manju";
	        Connection con = DriverManager.getConnection(url, userName, password);

	        // Create a Scanner object to take user input
	        Scanner scanner = new Scanner(System.in);

	        // Get user input for the data to be updated
	        System.out.print("Enter the student ID to update: ");
	        int sid = scanner.nextInt();
	        scanner.nextLine();  // Consume the newline character

	        // Check if the student with the given ID exists before updating
	        if (!studentExists(con, sid)) {
	            System.out.println("Student with ID " + sid + " does not exist.");
	            return;
	        }

	        System.out.print("Enter new student name: ");
	        String sName = scanner.nextLine();
	        System.out.print("Enter new student email: ");
	        String sMail = scanner.nextLine();

	        // Define the SQL query for updating the data
	        String query = "UPDATE student SET sName = ?, sMail = ? WHERE sid = ?";
	        PreparedStatement pstm = con.prepareStatement(query);

	        // Set the new values into the PreparedStatement
	        pstm.setString(1, sName);
	        pstm.setString(2, sMail);
	        pstm.setInt(3, sid);

	        // Execute the query to update the data
	        int updatedRows = pstm.executeUpdate();
	        if (updatedRows > 0) {
	            System.out.println("Data Updated Successfully!!!");
	        } else {
	            System.out.println("No data was updated. Please check the student ID.");
	        }

	        // Close resources
	        pstm.close();
	        con.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	}

	// Check if a student with the given ID exists in the database
	
	
	public void deleteData() {
	    try {
	        String url = "jdbc:mysql://127.0.0.1:3306/practice";
	        String userName = "root";
	        String password = "Manju";
	        Connection con = DriverManager.getConnection(url, userName, password);

	        // Create a Scanner object to take user input
	        Scanner scanner = new Scanner(System.in);

	        // Get user input for the student ID to be deleted
	        System.out.print("Enter the student ID to delete: ");
	        int sid = scanner.nextInt();

	        // Check if the student with the given ID exists before deleting
	        if (!studentExists(con, sid)) {
	            System.out.println("Student with ID " + sid + " does not exist.");
	            return;
	        }

	        // Define the SQL query for deleting the data
	        String query = "DELETE FROM student WHERE sid = ?";
	        PreparedStatement pstm = con.prepareStatement(query);

	        // Set the student ID into the PreparedStatement
	        pstm.setInt(1, sid);

	        // Execute the query to delete the data
	        int deletedRows = pstm.executeUpdate();
	        if (deletedRows > 0) {
	            System.out.println("Data Deleted Successfully!!!");
	        } else {
	            System.out.println("No data was deleted. Please check the student ID.");
	        }

	        // Close resources
	        pstm.close();
	        con.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	// Check if a student with the given ID exists in the database
	private boolean studentExists(Connection con, int sid) throws SQLException {
	    String query = "SELECT COUNT(*) FROM student WHERE sid = ?";
	    PreparedStatement pstm = con.prepareStatement(query);
	    pstm.setInt(1, sid);
	    var resultSet = pstm.executeQuery();
	    resultSet.next();
	    int count = resultSet.getInt(1);
	    resultSet.close();
	    return count > 0;
	}

}