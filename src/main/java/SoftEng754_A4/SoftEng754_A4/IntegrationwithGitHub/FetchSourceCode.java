package SoftEng754_A4.SoftEng754_A4.IntegrationwithGitHub;
import org.eclipse.egit.github.core.PullRequest;
import org.eclipse.egit.github.core.RepositoryId;

public interface FetchSourceCode {

   boolean pullRequestValid(RepositoryId repoId, int id);
   PullRequest retrievePullRequest(RepositoryId repoId, int id);
   String getSourceCode(PullRequest Request);

}