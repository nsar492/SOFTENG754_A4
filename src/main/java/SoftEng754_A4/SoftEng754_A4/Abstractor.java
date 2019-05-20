package SoftEng754_A4.SoftEng754_A4;

import java.util.Map;

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

	public Map<String, String> getFileMap() {
		// TODO Auto-generated method stub
		return this.commitReader.getLastCommitFileMap();
	}

	public Integer getNumberOfCommitedFiles() {
		// TODO Auto-generated method stub
		return commitReader.getLastCommitFileMap().size();
	}

	public Boolean ifNewCommit() {
		// TODO Auto-generated method stub
		return null;
	}
}
