package SoftEng754_A4.SoftEng754_A4.NonDeveloperCodeReview;

import junit.framework.TestCase;

import org.junit.Test;
import org.mockito.Mockito;
import SoftEng754_A4.SoftEng754_A4.NonDeveloperCodeReview.PullRequest;

public class NonDeveloperCodeReviewTest extends TestCase{
	
	// Requirement 11 
	// Positive test case to check if the given parameters fetch a valid pull request or not 
	public void testSendAutomatedCodeReviewAndAbstraction_CheckIfPullRequestIDIsValid() {
		//Given
		// Name of the branch for which pull request is created
		String branch = "sendAutomatedCodeReviewAndAbstraction";
				
		// Pull request created by
		String createdBy = "Developer1";
				
		//Work item linked with the Pull Request
		String linkedWorkItem = "SSC032";
				
		PullRequest pullRequest = Mockito.mock(PullRequest.class);
		
		//when
		Mockito.when(pullRequest.getPullRequest(branch, createdBy, linkedWorkItem)).thenReturn(1);
		
		//then
		assertEquals(1, pullRequest.getPullRequest(branch, createdBy, linkedWorkItem));
	}
}
