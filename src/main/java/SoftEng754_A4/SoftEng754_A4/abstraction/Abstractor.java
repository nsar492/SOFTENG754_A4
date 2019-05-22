package SoftEng754_A4.SoftEng754_A4.abstraction;

import java.util.Map;
import java.util.Set;

public class Abstractor implements Abstraction {

	private GitReader commitReader;
	
	public Abstractor() {
		commitReader = new GitReader();
	}
	
	public void fetchLastCommitDetails() {
		// get and return the details of latest commit given the git repo link and branch name
		this.commitReader.getLatestCommit();
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
		return this.commitReader.getLastCommitFileMap().size();
	}

	public Boolean ifNewCommit() {
		return this.commitReader.checkForNewCommits();
	}

	public Set<String> getCommitedFileNames() {
		// TODO Auto-generated method stub
		return this.commitReader.getLastCommitFileMap().keySet();
	}

	// downloads file and returns file path
	public String downloadTempFileFromRepo() {
		// TODO Auto-generated method stub
		return this.commitReader.downloadFileFromGit();
	}
}
