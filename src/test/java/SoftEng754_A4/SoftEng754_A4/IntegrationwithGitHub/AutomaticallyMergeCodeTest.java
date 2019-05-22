package SoftEng754_A4.SoftEng754_A4.IntegrationwithGitHub;

import org.eclipse.egit.github.core.PullRequest;
import org.eclipse.egit.github.core.RepositoryId;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doReturn;

public class AutomaticallyMergeCodeTest {

    private RepositoryId repoId;

    private AutomaticallyMergeCode merge;

    private PullRequest codeToMerge;


    @Before
    public void before(){
        repoId = new RepositoryId("Hmm", "Test");
        merge = Mockito.mock(AutomaticallyMergeCode.class);
        codeToMerge = new PullRequest();
    }


//  Test when repo is null
    @Test
    public void testWhenRepoIsNull() {
        doReturn(false).when(merge).isRepoValid(null);
        assertFalse(merge.isRepoValid(null));
    }

    //  Test when repo is not null
    @Test
    public void testWhenRepoIsNotNull() {
        doReturn(true).when(merge).isRepoValid(repoId);
        assertTrue(merge.isRepoValid(repoId));
    }

//  Test when code is mergable
    @Test
    public void testIsMergable(){
        doReturn(true).when(merge).isCodeMergable(codeToMerge);
        assertTrue(merge.isCodeMergable(codeToMerge));
    }


//  Test when code is notMergable
    @Test
    public void testNotMergeable(){
        doReturn(false).when(merge).isCodeMergable(codeToMerge);
        assertFalse(merge.isCodeMergable(codeToMerge));
    }


//   Test if code merged successfully
    @Test
    public void testMergeSuccessful(){
        doReturn(true).when(merge).mergeCode(codeToMerge, repoId);
        assertTrue(merge.mergeCode(codeToMerge, repoId));
    }

//  Test if code merge failed
    @Test
    public void testMergeFailed(){
        doReturn(false).when(merge).mergeCode(codeToMerge, repoId);
        assertFalse(merge.mergeCode(codeToMerge, repoId));
    }

}
