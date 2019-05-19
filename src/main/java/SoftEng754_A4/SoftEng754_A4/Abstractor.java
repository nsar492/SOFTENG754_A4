package SoftEng754_A4.SoftEng754_A4;

public class Abstractor implements Abstraction {

	private GitReader commitReader;
	
	public Abstractor() {
		commitReader = new GitReader();
	}
	
	public void fetchLastCommitDetails() {
		// get and return the details of latest commit given the git repo link and branch name
		commitReader.getLatestCommit();
	}

	public GitReader getGitReader() {
		return this.commitReader;	
	}
}
