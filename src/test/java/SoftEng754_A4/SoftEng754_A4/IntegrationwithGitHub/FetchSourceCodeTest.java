package SoftEng754_A4.SoftEng754_A4.IntegrationwithGitHub;


import org.eclipse.egit.github.core.PullRequest;
import org.eclipse.egit.github.core.RepositoryId;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;


public class FetchSourceCodeTest {

    private PullRequest testRequest;

    private RepositoryId repoId;

    private int pullId;

    private FetchSourceCode getCode;


    @Before
    public void before(){
        testRequest = new PullRequest();
        testRequest.setBodyText("Test Repo");
        testRequest.setTitle("Test");
        repoId = new RepositoryId("Hmm", "Test");
        pullId = 3;
        getCode = Mockito.mock(FetchSourceCode.class);

    }

//  Test when repo is null
    @Test
    public void testWhenRepoIsNull() {
        doReturn(false).when(getCode).pullRequestValid(null, pullId);
        assertFalse(getCode.pullRequestValid(null, pullId));
    }

//  Test when repo is not null and is valid
    @Test
    public void testWhenRepoIsNotNullAndIsValid() {
        doReturn(true).when(getCode).pullRequestValid(repoId, pullId);
        assertTrue(getCode.pullRequestValid(repoId, pullId));
    }

//  Test when repo is not null but is not valid
    @Test
    public void testWhenRepoIsNotNullAndIsNotValid() {
        RepositoryId invalidRepo = new RepositoryId("No","nothing");
        doReturn(false).when(getCode).pullRequestValid(invalidRepo, pullId);
        assertFalse(getCode.pullRequestValid(invalidRepo, pullId));
    }

//  Test the pull request received successfully
    @Test
    public void testPullRequestSuccess() {
        doReturn(testRequest).when(getCode).retrievePullRequest(repoId, pullId);
        assertNotNull(getCode.retrievePullRequest(repoId, pullId));
    }

//  Test the pull request not received successfully
    @Test
    public void testPullRequestFail() {
        doReturn(null).when(getCode).retrievePullRequest(repoId, pullId);
        assertNull(getCode.retrievePullRequest(repoId, pullId));
    }

//  Test getting the source code from the pull request
    @Test
    public void testGetSourceCode() {
        doReturn(testRequest.getBodyText()).when(getCode).getSourceCode(testRequest);
        assertEquals("Test Repo", getCode.getSourceCode(testRequest));
    }

    //  Test getting code  not working
    @Test
    public void testNullSourceCode() {
        doReturn(null).when(getCode).getSourceCode(testRequest);
        assertNull(getCode.getSourceCode(testRequest));
    }

    //  Test getting code returning the incorrect value
    @Test
    public void testWrongSourceCode() {
        doReturn("Wrong Body").when(getCode).getSourceCode(testRequest);
        assertNotEquals(testRequest.getBodyText(), getCode.getSourceCode(testRequest));
    }
}
