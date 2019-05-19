package SoftEng754_A4.SoftEng754_A4;

import junit.framework.TestCase;

public class TestAbstraction extends TestCase{
	
	//	Test getCommitDetails
	//  Test that getCommitDetails function should not return null
	public void testFetchCommitDetailsNotNull() {
		
		Abstraction abst = new Abstractor();
		abst.fetchLastCommitDetails();
		
		assertNotNull(abst.getGitReader());
	}
	
	//  Test that getCommitDetails function fetches all file names from git commit
//	public void testGetCommitDetailsFileList() {
//		
//		Abstraction abst = new Abstractor();
//		
//		assertNotNull(abst.fetchLastCommitDetails());
//	}	
	
	//	Test getNumberOfCommitedFiles
	//	Test getNamesOfCommitedFiles
	//	Test getCommitAbstract
	//	Test getFileAbstract
	//	Test getTempFileFromRepo
	//	Test deleteTempFileFromRepo

}
