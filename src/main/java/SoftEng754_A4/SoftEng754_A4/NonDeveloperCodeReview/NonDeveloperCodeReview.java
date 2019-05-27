package SoftEng754_A4.SoftEng754_A4.NonDeveloperCodeReview;

import java.io.File;

public interface NonDeveloperCodeReview {
	public File getAutomatedCodeReviewAndAbstractionFile(String branch, int pullRequestID, String linkedWorkItem);
	
	public Boolean establishConnection(String sourceAddress, String destinationAddress);
	
	public File receiveAutomatedCodeReviewAndAbstraction(String branch, int pullRequestID, String linkedWorkItem);
	
	public Boolean postReviewFeedback(int pullRequestID, String reviewer, String commet);
}
