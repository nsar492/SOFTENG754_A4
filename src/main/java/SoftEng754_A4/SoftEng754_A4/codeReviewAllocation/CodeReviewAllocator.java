package SoftEng754_A4.SoftEng754_A4.codeReviewAllocation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.mysql.cj.jdbc.MysqlDataSource;


public class CodeReviewAllocator implements CodeReviewAllocation{

	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	
	@Override
	public boolean addReviewerToDatabase(String reviewerName) {
		try {
			String addQuery = "INSERT INTO Reviewers (ReviewerName, ReviewCount, ActiveReviews) VALUES ('" 
					+ reviewerName + "' , 0, 0);";
			
			stmt = conn.createStatement();
			stmt.executeUpdate(addQuery);
			
			//stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<String> getReviewerListFromDatabase() {
		ArrayList<String> reviewrList = new ArrayList<String>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT ReviewerName FROM Reviewers");
			
			while(rs.next()) {
				reviewrList.add(rs.getString(1));
			}
			
			//stmt.close();
			//rs.close();
			if(reviewrList.size() > 0) {
				
				return reviewrList;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getAvailableReviewerFromDatabase() {
		// 
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT ReviewerName FROM Reviewers ORDER BY ActiveReviews LIMIT 1;");
			rs.next();
			//stmt.close();

			return rs.getString(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "";
	}

	public void openDatabaseConnection() {
		
		MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setUser("root");
		dataSource.setPassword("Mysql@12");
		dataSource.setServerName("localhost");
		dataSource.setDatabaseName("SE754");
		
		try {
			conn = dataSource.getConnection();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	@Override
	public boolean updateCompletedReviewInDatabase(String reviewerName) {
		String getData = "SELECT * FROM Reviewers WHERE ReviewerName = '" + reviewerName + "'";
		Integer reviewCount = 0, activeReview = 0;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(getData);
			
			rs.next();
			reviewCount = Integer.parseInt(rs.getString(3));
			activeReview = Integer.parseInt(rs.getString(4));
			
			if(activeReview > 0) {
				stmt.executeUpdate("UPDATE Reviewers SET ReviewCount = "
						+ (reviewCount + 1) 
						+ ", ActiveReviews = "
						+ (activeReview - 1) 
						+ " WHERE ReviewerName = '" + reviewerName + "'");
				
				rs = stmt.executeQuery(getData);
				return rs.next();
				//System.out.println(rs.getString(2) + "  " + rs.getString(3) + "  " + rs.getString(4));
			}
			else {
				System.out.println("Can't update. no active review.");
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}


	@Override
	public void assignReview(String reviewerName) {
		String getData = "SELECT ActiveReviews FROM Reviewers WHERE ReviewerName = '" + reviewerName + "'";
		Integer activeReview = 0;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(getData);
			
			rs.next();
			activeReview = Integer.parseInt(rs.getString(1));
			System.out.println("Active review count is " + activeReview);
			
			if(activeReview != null) {
				stmt.executeUpdate("UPDATE Reviewers SET ActiveReviews = "
				+ (activeReview + 1) 
				+ " WHERE ReviewerName = '" + reviewerName + "'");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean deleteReviewerFromDatabase(String reviewerName) {
		// DELETE FROM Reviewers WHERE ID = 7;
		String getData = "SELECT ID FROM Reviewers WHERE ReviewerName = '" + reviewerName + "'";
		String id;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(getData);
			
			rs.next();
			id = rs.getString(1);
			
			stmt.executeUpdate("DELETE FROM Reviewers WHERE ID = " + id);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}		
	}

	public static void main(String[] args) {
		CodeReviewAllocator tempObj = new CodeReviewAllocator();
		
		tempObj.openDatabaseConnection();
//		tempObj.addReviewerToDatabase("Ranveer");
//		System.out.println(tempObj.getReviewerListFromDatabase());
//		System.out.println(tempObj.getAvailableReviewerFromDatabase());
//		tempObj.updateCompletedReviewInDatabase("Ranveer");
//		tempObj.assignReview("Ranveer");
//		tempObj.deleteReviewerFromDatabase("Jim");
		System.out.println(tempObj.getReviewer("Jim"));
	}

	@Override
	public String getReviewer(String reviewerName) {
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT ReviewerName FROM Reviewers WHERE ReviewerName = '" + reviewerName + "';");
			
			if(rs.next()) {
				return rs.getString(1);
			} else return null;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}		
	}
}
