package SoftEng754_A4.SoftEng754_A4;

import java.util.Map;

public interface Abstraction {

	public void fetchLastCommitDetails();

	public Map<String, String> getFileMap();
	
	public Boolean ifNewCommit();
}
