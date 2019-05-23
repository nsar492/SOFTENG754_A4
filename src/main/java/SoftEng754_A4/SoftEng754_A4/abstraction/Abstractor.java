package SoftEng754_A4.SoftEng754_A4.abstraction;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Abstractor implements Abstraction {

	private GitReader commitReader;
	private Map<Integer, String> fileAbstractMap;
	
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
	
	public void runFileAbstract() {
		// code to use machine learning and run abstraction on the 
		// file and return a map of the comments goes here
		this.fileAbstractMap = new HashMap<Integer, String>();
	}

	// returns a map with line number as key and 
	public Map<Integer, String> getFileAbstract() {
		return this.fileAbstractMap;
	}

	// getFileAbstract() only abstracts one file, getCommitAstract loops through all files in a commit
	// and returns a cumulative abstract 
	public Map<String, Map<Integer, String>> getCommitAbstract() {
		// TODO Auto-generated method stub
		Map<String, Map<Integer, String>> tempMap = new HashMap<String, Map<Integer,String>>();
		
		for(String s : this.commitReader.getLocalFileMap().keySet())
		{
			tempMap.put(s, getFileAbstract());
		}
		return tempMap;
	}

	public boolean removeTempFiles() {
		// TODO Auto-generated method stub
		return false;
	}
}
