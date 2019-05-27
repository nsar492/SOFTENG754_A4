package SoftEng754_A4.SoftEng754_A4.codeReviewAllocation;

import java.util.List;

public interface CodeReviewAllocation {

	public boolean addReviewerToDatabase();

	public boolean deleteReviewerFromDatabase();

	public boolean updateDatabase();

	public List<String> getReviewerListFromDatabase();

}
