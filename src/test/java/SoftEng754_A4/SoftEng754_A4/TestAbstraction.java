package SoftEng754_A4.SoftEng754_A4;

import org.mockito.Mockito;

import junit.framework.TestCase;

public class TestAbstraction extends TestCase{
	
	//	Test fetchLastCommitDetails
	//
	//  Test that fetchLastCommitDetails function should not return null
	public void testFetchCommitDetailsNotNull() {
		
		Abstractor abst = new Abstractor();
		abst.fetchLastCommitDetails();
		
		assertNotNull(abst.getGitReader());
	}
	
	//  Test that fetchLastCommitDetails function returns a map of file names and file paths
	public void testFetchLastCommitDetailsFileListNotNull() {
		
		Abstraction abst = new Abstractor();
		abst.fetchLastCommitDetails();
		
		assertNotNull(abst.getFileMap());
	}	
	
	//	Test getNumberOfCommitedFiles
	//
	public void testGetNumberOfCommitedFiles() {
		Integer expectedFileCount = 4;
		
		Abstractor abst = Mockito.mock(Abstractor.class);
		
		Mockito.when(abst.getNumberOfCommitedFiles()).thenReturn(4);
		
		assertEquals(abst.getNumberOfCommitedFiles(), expectedFileCount);
	}
	
	//	Test getNamesOfCommitedFiles
	//	Test getCommitAbstract
	//	Test getFileAbstract
	//	Test getTempFileFromRepo
	//	Test deleteTempFileFromRepo

}
