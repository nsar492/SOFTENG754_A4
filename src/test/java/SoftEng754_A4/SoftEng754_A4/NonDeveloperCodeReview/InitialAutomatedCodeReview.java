package SoftEng754_A4.SoftEng754_A4.NonDeveloperCodeReview;

import org.junit.Before;
import org.mockito.Mockito;
import junit.framework.TestCase;

public class InitialAutomatedCodeReview extends TestCase {
	
	private String branch; 
	private String createdBy;
	private String linkedWorkItem;
	private PullRequest pullRequest;
	
	@Before
	public void setup() {
		branch = "sendAutomatedCodeReviewAndAbstraction";
		createdBy = "Developer1";
		linkedWorkItem = "SSC032";
	}
	
	public void testPullRequestIDIsValid() {
		pullRequest = Mockito.mock(PullRequest.class);
			
		Mockito.doReturn(0).when(pullRequest).getPullRequest(branch, createdBy, linkedWorkItem);
		
		assertEquals(0, pullRequest.getPullRequest(branch, createdBy, linkedWorkItem));
	
	}
		
}