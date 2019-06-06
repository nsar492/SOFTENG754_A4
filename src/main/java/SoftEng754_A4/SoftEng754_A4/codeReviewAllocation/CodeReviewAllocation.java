package SoftEng754_A4.SoftEng754_A4.codeReviewAllocation;

import java.util.List;

public interface CodeReviewAllocation {

	/**
	 * addReviewerToDatabase() adds reviewer to database and returns true if successfully added
	 * */
	public boolean addReviewerToDatabase(String reviewerName);

	/**
	 * deleteReviewerFromDatabase() deletes reviewer from database and returns true if successfully added
	 * */
	public boolean deleteReviewerFromDatabase(String reviewerName);

	/**
	 * getReviewerListFromDatabase() retrieves list of reviewer from database
	 * and returns a list of type string
	 * */
	public List<String> getReviewerListFromDatabase();

	/**
	 * getAvailableReviewerFromDatabase() retrieves available reviewer from database
	 * and returns reviewer ID
	 * */
	public String getAvailableReviewerFromDatabase();

	/**
	 * updateCompletedReviewInDatabase() updates database with active and total review count 
	 * when a reviewer is assigned a review and returns true if successfully updated
	 * */
	public boolean updateCompletedReviewInDatabase(String reviewerName);
	
	/**
	 * updateReviewerInfoInDatabase() updates database with active and total review count 
	 * when a reviewer is assigned a review and returns true if successfully updated
	 * */
	public void assignReview(String reviewerName);
	
	public String getReviewer(String reviewerName);
	
	public void openDatabaseConnection();

}
