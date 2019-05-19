package SoftEng754_A4.SoftEng754_A4;

public class Abstractor implements Abstraction {

	public GitReader getCommitDetails() {
		GitReader latestCommit = new GitReader();
		
		// get and return the details of latest commit given the git repo link and branch name
		latestCommit.getLatestCommit();
		
		return latestCommit;
	}

}
