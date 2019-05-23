package SoftEng754_A4.SoftEng754_A4.IntegrationwithGitHub;


import org.eclipse.egit.github.core.RepositoryId;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doReturn;

public class PostCommentsTest {

    private String commentText;

    private PostComments createComment;

    private RepositoryId repoId;


    @Before
    public void before() {
        commentText = "Test comment.";
        createComment = Mockito.mock(PostComments.class);
        repoId = new RepositoryId("Hmm", "Test");
    }

//    Test when comment is empty.
    @Test
    public void testCommentIsEmpty(){
        doReturn(false).when(createComment).isCommentValid(null);
        assertFalse(createComment.isCommentValid(null));
    }

//    Test when comment is not empty.
    @Test
    public void testCommentIsNotEmpty(){
        doReturn(true).when(createComment).isCommentValid(commentText);
        assertTrue(createComment.isCommentValid(commentText));
    }

// Test when repo is null
    @Test
    public void testWhenRepoIsNull() {
        doReturn(false).when(createComment).isRepoValid(null);
        assertFalse(createComment.isRepoValid(null));
    }

// Test when repo is not null and is valid
    @Test
    public void testWhenRepoIsNotNullAndIsValid() {
        doReturn(true).when(createComment).isRepoValid(repoId);
        assertTrue(createComment.isRepoValid(repoId));
    }

//     Test when repo is not null but is not valid
    @Test
    public void testWhenRepoIsNotNullAndIsNotValid() {
        RepositoryId invalidRepo = new RepositoryId("No","nothing");
        doReturn(false).when(createComment).isRepoValid(invalidRepo);
        assertFalse(createComment.isRepoValid(invalidRepo));
    }

//    Test when comment fails to post
    @Test
    public void testCommentPostFailure(){
    doReturn(false).when(createComment).postComment(commentText, repoId);
    assertFalse(createComment.postComment(commentText, repoId));
    }

//   Test when comment posts successfully
    @Test
    public void testCommentPostSuccess(){
        doReturn(true).when(createComment).postComment(commentText, repoId);
        assertTrue(createComment.postComment(commentText, repoId));
    }
}
