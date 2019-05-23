package SoftEng754_A4.SoftEng754_A4.abstraction;

import java.util.HashMap;
import java.util.Map;

public class GitReader {

	// This map stores the committed file names and address
	private Map<String, String> fileMap = null;
	
	
	public void getLatestCommit() {
		this.fileMap = new HashMap<String, String>();
	}

	public Map<String, String> getLastCommitFileMap() {
		// TODO Auto-generated method stub
		// run code to get the last commit details and store in the file map
		return this.fileMap;
	}
	
	public Map<String, String> getLocalFileMap() {
		return this.fileMap;
	}

	public Boolean checkForNewCommits() {
		// Write the code to check git repo for new commits.
		// Return false by default
		return false;		
	}

	public String downloadFileFromGit() {
		// TODO Auto-generated method stub
		return "";
	}

}
