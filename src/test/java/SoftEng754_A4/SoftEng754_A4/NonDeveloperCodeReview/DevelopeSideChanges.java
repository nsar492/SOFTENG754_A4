package SoftEng754_A4.SoftEng754_A4.NonDeveloperCodeReview;

import java.io.File;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import junit.framework.TestCase;

public class DevelopeSideChanges extends TestCase{

	private String branch; 
	private String createdBy;
	private String linkedWorkItem;
	private PullRequest pullRequest;
	private File file;
	private NonDeveloperCodeReview nonDeveloperCodeReview;
	
	@Before
	public void setup() {
		branch = "sendAutomatedCodeReviewAndAbstraction";
		createdBy = "Developer1";
		linkedWorkItem = "SSC032";
		file = new File("test.txt");
	}
	
	public void testFetchReviewCommets() {
		pullRequest = Mockito.mock(PullRequest.class);
		int pullRequestID = pullRequest.getPullRequest(branch, createdBy, linkedWorkItem);
		nonDeveloperCodeReview = Mockito.mock(NonDeveloperCodeReview.class);
		//when
		Mockito.doReturn(file).when(nonDeveloperCodeReview).FetchReviewComments(pullRequestID);
		
		//then
		assertEquals(file, nonDeveloperCodeReview.FetchReviewComments(pullRequestID));
	}
	
	@Test (expected = NullPointerException.class)
	public void testFetchReviewCommets_ThrowsException() {
		pullRequest = Mockito.mock(PullRequest.class);
		int pullRequestID = pullRequest.getPullRequest(branch, createdBy, linkedWorkItem);
		nonDeveloperCodeReview = Mockito.mock(NonDeveloperCodeReview.class);
		
		//when
		Mockito.doThrow(new NullPointerException()).when(nonDeveloperCodeReview).FetchReviewComments(pullRequestID);
	}
}
