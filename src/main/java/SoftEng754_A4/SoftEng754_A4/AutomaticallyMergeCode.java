package SoftEng754_A4.SoftEng754_A4.IntegrationwithGitHub;

import org.eclipse.egit.github.core.PullRequest;
import org.eclipse.egit.github.core.RepositoryId;

public interface AutomaticallyMergeCode {
    boolean isRepoValid(RepositoryId repoId);
    boolean isCodeMergable(PullRequest codeToMerge);
    boolean mergeCode(PullRequest codeToMerge, RepositoryId repoId);

}
