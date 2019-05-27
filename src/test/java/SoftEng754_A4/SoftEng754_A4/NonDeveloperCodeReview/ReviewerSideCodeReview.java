package SoftEng754_A4.SoftEng754_A4.NonDeveloperCodeReview;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import junit.framework.TestCase;

public class ReviewerSideCodeReview extends TestCase{

	private String branch; 
	private String createdBy;
	private String linkedWorkItem;
	private PullRequest pullRequest;
	private File file;
	private NonDeveloperCodeReview nonDeveloperCodeReview;
	private String reviewer;
	private String comment;
	
	@Before
	public void setup() {
		branch = "sendAutomatedCodeReviewAndAbstraction";
		createdBy = "Developer1";
		linkedWorkItem = "SSC032";
		file = new File("test.txt");
		reviewer = "reviewer";
		comment = "Looks good";
	}
	
	public void testReceiveAutomatedCodeReview() {
		
		pullRequest = Mockito.mock(PullRequest.class);
		int pullRequestID = pullRequest.getPullRequest(branch, createdBy, linkedWorkItem);
		nonDeveloperCodeReview = Mockito.mock(NonDeveloperCodeReview.class);
				
		//when
		Mockito.doReturn(file).when(nonDeveloperCodeReview).
			receiveAutomatedCodeReviewAndAbstraction(branch, pullRequestID, linkedWorkItem);
		
		//then
		assertEquals(file, nonDeveloperCodeReview.receiveAutomatedCodeReviewAndAbstraction(branch, pullRequestID, linkedWorkItem));
	}
	
	@Test(expected = NullPointerException.class)
	public void testReceiveAutomatedCodeReviewFails() {
		pullRequest = Mockito.mock(PullRequest.class);
		int pullRequestID = pullRequest.getPullRequest(branch, createdBy, linkedWorkItem);
		nonDeveloperCodeReview = Mockito.mock(NonDeveloperCodeReview.class);
				
		//when
		Mockito.doThrow(new NullPointerException()).when(nonDeveloperCodeReview).receiveAutomatedCodeReviewAndAbstraction(branch, pullRequestID, linkedWorkItem);
	}	
	
	public void testPostReviewFeedback() {
		pullRequest = Mockito.mock(PullRequest.class);
		int pullRequestID = pullRequest.getPullRequest(branch, createdBy, linkedWorkItem);
		nonDeveloperCodeReview = Mockito.mock(NonDeveloperCodeReview.class);
		
		//when
		Mockito.doReturn(true).when(nonDeveloperCodeReview).postReviewFeedback(pullRequestID, reviewer, comment);
		
		//then
		assertTrue(nonDeveloperCodeReview.postReviewFeedback(pullRequestID, reviewer, comment));
	}
}
