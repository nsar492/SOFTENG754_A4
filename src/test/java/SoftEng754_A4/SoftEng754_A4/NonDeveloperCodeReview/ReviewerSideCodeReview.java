package SoftEng754_A4.SoftEng754_A4.NonDeveloperCodeReview;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class ReviewerSideCodeReview {

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
}