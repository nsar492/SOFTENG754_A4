package SoftEng754_A4.SoftEng754_A4.NonDeveloperCodeReview;

import java.io.File;

public interface NonDeveloperCodeReview {
	public File getAutomatedCodeReviewAndAbstractionFile(String branch, int pullRequestID, String linkedWorkItem);
}
