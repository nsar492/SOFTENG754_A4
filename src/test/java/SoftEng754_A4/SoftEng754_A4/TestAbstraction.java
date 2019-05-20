package SoftEng754_A4.SoftEng754_A4;

import org.mockito.Mockito;

import junit.framework.TestCase;

public class TestAbstraction extends TestCase{
	
	//	Test fetchLastCommitDetails
	//
	public void testIfNewCommit() {
		
		Abstractor abstractor = Mockito.mock(Abstractor.class);
		Mockito.when(abstractor.ifNewCommit()).thenReturn(true);
		
		assertEquals(abstractor.ifNewCommit(), Boolean.TRUE);
	}
	
	public void testIfNewCommitNegative() {
		
		Abstractor abstractor = Mockito.mock(Abstractor.class);
		Mockito.when(abstractor.ifNewCommit()).thenReturn(false);
		
		assertEquals(abstractor.ifNewCommit(), Boolean.FALSE);
	}
	
	public void testFetchLastCommitDetailsNotNull() {
		
		Abstractor abstractor = new Abstractor();
		abstractor.fetchLastCommitDetails();
		
		assertNotNull(abstractor.getGitReader());
	}
	
	//  Test that fetchLastCommitDetails function returns a map of file names and file paths
	public void testFetchLastCommitDetailsFileListNotNull() {
		
		Abstraction abstractor = new Abstractor();
		abstractor.fetchLastCommitDetails();
		
		assertNotNull(abstractor.getFileMap());
	}	
	
	//	Test getNumberOfCommitedFiles
	//
	public void testGetNumberOfCommitedFiles() {
		Integer expectedFileCount = 4;
		
		Abstractor abstractor = Mockito.mock(Abstractor.class);
		
		Mockito.when(abstractor.getNumberOfCommitedFiles()).thenReturn(4);
		
		assertEquals(abstractor.getNumberOfCommitedFiles(), expectedFileCount);
	}
	
	//	Test getNamesOfCommitedFiles
	//	Test getCommitAbstract
	//	Test getFileAbstract
	//	Test getTempFileFromRepo
	//	Test deleteTempFileFromRepo

}
