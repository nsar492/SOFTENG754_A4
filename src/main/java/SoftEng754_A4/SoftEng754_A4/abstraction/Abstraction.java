package SoftEng754_A4.SoftEng754_A4.abstraction;

import java.util.Map;
import java.util.Set;

public interface Abstraction {

	public void fetchLastCommitDetails();

	public Map<String, String> getFileMap();
	
	public Boolean ifNewCommit();
	
	public Set<String> getCommitedFileNames();
}
