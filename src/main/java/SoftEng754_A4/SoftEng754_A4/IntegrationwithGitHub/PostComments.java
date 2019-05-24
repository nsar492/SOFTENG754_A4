package SoftEng754_A4.SoftEng754_A4.IntegrationwithGitHub;

import org.eclipse.egit.github.core.RepositoryId;

public interface PostComments {
    boolean isCommentValid(String commentText);
    boolean isRepoValid(RepositoryId repo);
    boolean postComment(String commentText, RepositoryId repo);
}
