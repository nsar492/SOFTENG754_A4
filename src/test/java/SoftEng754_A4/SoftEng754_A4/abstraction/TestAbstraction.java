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
	
	private Abstractor abstractor;
	
	public TestAbstraction() {
		// TODO Auto-generated constructor stub
		abstractor = new Abstractor();
	}
	
	//	Test fetchLastCommitDetails
	//
	public void testIfNewCommit() {
		
		Abstractor abstractor1 = Mockito.spy(abstractor);
		Mockito.when(abstractor1.ifNewCommit()).thenReturn(true);
		
		assertEquals(abstractor1.ifNewCommit(), Boolean.TRUE);
	}
	
	public void testIfNewCommitDefaultValue() {
		
		assertEquals(abstractor.ifNewCommit(), Boolean.FALSE);
	}
	
	public void testFetchLastCommitDetailsNotNull() {
		
		abstractor.fetchLastCommitDetails();
		
		assertNotNull(abstractor.getGitReader());
	}
	
	//  Test that fetchLastCommitDetails function returns a map of file names and file paths
	//
	public void testFetchLastCommitDetailsFileListNotNull() {
		
		abstractor.fetchLastCommitDetails();
		
		assertNotNull(abstractor.getFileMap());
	}	
	
	
	
	//	Test getNumberOfCommitedFiles
	//
	public void testGetNumberOfCommitedFiles() {
		Integer expectedFileCount = 4, actualFileCount = 4;
		
		abstractor = Mockito.mock(Abstractor.class);
		
		Mockito.when(abstractor.getNumberOfCommitedFiles()).thenReturn(expectedFileCount);
		
		assertEquals(abstractor.getNumberOfCommitedFiles(), actualFileCount);
	}
	
	
	
	//	Test getNamesOfCommitedFiles
	//
	public void testGetNamesOfCommitedFiles() {
		
		abstractor = Mockito.mock(Abstractor.class);
		
		TestAbstraction testObject = Mockito.mock(TestAbstraction.class);
		
		Mockito.when(testObject.checkMapKeySet(abstractor.getCommitedFileNames(), new HashSet<String>())).thenReturn(true);
		
		assertEquals(checkMapKeySet(abstractor.getCommitedFileNames(), new HashSet<String>()), true);
		
	}
	
	
	
	//	Test downloadTempFileFromRepo
	//
	public void testDownloadTempFileFromRepo() {
		Abstractor abstractor1 = Mockito.spy(abstractor);
		
		Mockito.when(abstractor1.downloadTempFileFromRepo()).thenReturn("D:/test.java");
		
		assertEquals(abstractor1.downloadTempFileFromRepo(), "D:/test.java");
	}

	
	
	//	Test getFileAbstract
	//
	public void testGetFileAbstractNotNull() {
		Abstractor abstractor2 = Mockito.spy(abstractor);
		Mockito.when(abstractor2.getFileAbstract()).thenReturn(new HashMap<Integer, String>());
		
		assertNotNull(abstractor2.getFileAbstract());
	}
	
	public void testGetFileAbstractValue() {
		
		Abstractor abstractor2 = Mockito.spy(abstractor);
		Mockito.when(abstractor2.getFileAbstract()).thenReturn(new HashMap<Integer, String>());
		
		assertEquals(abstractor2.getFileAbstract(), new HashMap<Integer, String>());
	}
	
	
	
	//	Test getCommitAbstract
	//
	public void testGetCommitAbstractNotNull() {
		
		abstractor.fetchLastCommitDetails();
		
		assertNotNull(abstractor.getCommitAbstract());
	}
	
	// validate the map returned by getCommitAbstract function
	public void testGetCommitAbstract() {
		
		abstractor.fetchLastCommitDetails();
		
		assertEquals(abstractor.getCommitAbstract(), getExpectedCommitDetailMapTime());
	}
	
	//	Test deleteTempFileFromRepo
	public void testDeleteTempFileFromRepo() {
		
		
		
	}

	
	
	
	
	
	
	
	
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
	
	
	public Map<String, Map<Integer, String>> getExpectedCommitDetailMapTime()
	{
		return new HashMap<String, Map<Integer, String>>();
	}
}
