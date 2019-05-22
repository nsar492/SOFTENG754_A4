package SoftEng754_A4.SoftEng754_A4.abstraction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.mockito.Mockito;

import SoftEng754_A4.SoftEng754_A4.abstraction.Abstraction;
import SoftEng754_A4.SoftEng754_A4.abstraction.Abstractor;
import junit.framework.TestCase;
import scala.collection.mutable.HashSet;

public class TestAbstraction extends TestCase{
	
	//  Helper functions
	public boolean checkMapKeySet(Set actual, HashSet expected)
	{
		int matchCount = 0;
		if(actual.size() == expected.size())
		{
			for(Object s : actual)
			{
				if (expected.contains(s))
					matchCount ++;
			}
		}
		
		return (matchCount == actual.size());
	}
	
	
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
	//
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
	//
	public void testGetNamesOfCommitedFiles() {
		
		Abstractor abstractor = Mockito.mock(Abstractor.class);
		TestAbstraction testObject = Mockito.mock(TestAbstraction.class);
		
		Mockito.when(testObject.checkMapKeySet(abstractor.getCommitedFileNames(), new HashSet<String>())).thenReturn(true);
		
		assertEquals(checkMapKeySet(abstractor.getCommitedFileNames(), new HashSet<String>()), true);
		
	}
	
	
	
	//	Test downloadTempFileFromRepo
	//
	public void testDownloadTempFileFromRepo() {
		Abstractor abstractor = Mockito.mock(Abstractor.class);
		
		Mockito.when(abstractor.downloadTempFileFromRepo()).thenReturn("D:/test.java");
		
		assertEquals(abstractor.downloadTempFileFromRepo(), "D:/test.java");
	}

	
	
	//	Test getFileAbstract
	//
	public void testGetFileAbstractNotNull() {
		Abstractor abstractor = new Abstractor();
		
		Abstractor abstractor2 = Mockito.spy(abstractor);
		Mockito.when(abstractor2.getFileAbstract()).thenReturn(new HashMap<Integer, String>());
		
		assertNotNull(abstractor2.getFileAbstract());
	}
	
	public void testGetFileAbstractValue() {
		Abstractor abstractor = new Abstractor();
		
		Abstractor abstractor2 = Mockito.spy(abstractor);
		Mockito.when(abstractor2.getFileAbstract()).thenReturn(new HashMap<Integer, String>());
		
		assertEquals(abstractor2.getFileAbstract(), new HashMap<Integer, String>());
	}
	
	
	
	//	Test getCommitAbstract
	//
	public void testGetCommitAbstractNotNull() {
		Abstractor abstractor = new Abstractor();
		abstractor.fetchLastCommitDetails();
		
		assertNotNull(abstractor.getCommitAbstract());
	}
	
	//	Test deleteTempFileFromRepo

}