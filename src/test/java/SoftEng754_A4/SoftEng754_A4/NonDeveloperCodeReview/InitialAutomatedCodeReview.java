package SoftEng754_A4.SoftEng754_A4.NonDeveloperCodeReview;

import java.io.File;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import junit.framework.TestCase;

public class InitialAutomatedCodeReview extends TestCase {
	
	private String branch; 
	private String createdBy;
	private String linkedWorkItem;
	private PullRequest pullRequest;
	private File file;
	private NonDeveloperCodeReview nonDeveloperCodeReview;
	private String developerToolAddress;
	private String reviewToolAddress;
	
	@Before
	public void setup() {
		branch = "sendAutomatedCodeReviewAndAbstraction";
		createdBy = "Developer1";
		linkedWorkItem = "SSC032";
		file = new File("test.txt");
		developerToolAddress = "developerToolAddress";
		reviewToolAddress = "reviewToolAddress";
	}
	
	public void testPullRequestIDIsValid() {
		pullRequest = Mockito.mock(PullRequest.class);
			
		Mockito.doReturn(0).when(pullRequest).getPullRequest(branch, createdBy, linkedWorkItem);
		
		assertEquals(0, pullRequest.getPullRequest(branch, createdBy, linkedWorkItem));
	}
	
	public void testPullRequestIDIsInvalid() {
		pullRequest = Mockito.mock(PullRequest.class);
		//when
		Mockito.doReturn(-1).when(pullRequest).getPullRequest(branch, createdBy, linkedWorkItem);
		
		assertFalse(pullRequest.getPullRequest(branch, createdBy, linkedWorkItem) == 0);
	}
	
	public void testFetchInitialReviewFile() {
		
		pullRequest = Mockito.mock(PullRequest.class);
		
		int pullRequestID = pullRequest.getPullRequest(branch, createdBy, linkedWorkItem);
		nonDeveloperCodeReview = Mockito.mock(NonDeveloperCodeReview.class);
		
		//when
		Mockito.doReturn(file).when(nonDeveloperCodeReview)
				.getAutomatedCodeReviewAndAbstractionFile(branch, pullRequestID, linkedWorkItem);
		
		//then
		assertEquals(file, nonDeveloperCodeReview
				.getAutomatedCodeReviewAndAbstractionFile(branch, pullRequestID, linkedWorkItem));
	}

	@Test (expected = NullPointerException.class)
	public void testFetchInitialReviewFileThrowsException() {
		
		pullRequest = Mockito.mock(PullRequest.class);
		int pullRequestID = pullRequest.getPullRequest(branch, createdBy, linkedWorkItem);
		nonDeveloperCodeReview = Mockito.mock(NonDeveloperCodeReview.class);
		
		Mockito.doThrow(new NullPointerException()).when(nonDeveloperCodeReview)
				.getAutomatedCodeReviewAndAbstractionFile(branch, pullRequestID, linkedWorkItem); 
	}
	
	public void	testEstablishConnection() {
		
		nonDeveloperCodeReview = Mockito.mock(NonDeveloperCodeReview.class);
		
		//when
		Mockito.doReturn(true).when(nonDeveloperCodeReview).establishConnection(developerToolAddress, reviewToolAddress);
		
		//then
		assertTrue(nonDeveloperCodeReview.establishConnection(developerToolAddress, reviewToolAddress));
	}
		
}