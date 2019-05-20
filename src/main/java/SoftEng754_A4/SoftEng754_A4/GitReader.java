package SoftEng754_A4.SoftEng754_A4;

import java.util.HashMap;
import java.util.Map;

public class GitReader {

	private Map<String, String> fileMap = null;
	
	
	public void getLatestCommit() {
		this.fileMap = new HashMap<String, String>();
	}

	public Map<String, String> getLastCommitFileMap() {
		// TODO Auto-generated method stub
		return this.fileMap;
	}

	public Boolean checkForNewCommits() {
		// Write the code to check git repo for new commits.
		// Return false by default
		return false;		
	}

}
