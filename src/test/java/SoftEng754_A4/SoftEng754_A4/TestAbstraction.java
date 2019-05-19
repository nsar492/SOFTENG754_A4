package SoftEng754_A4.SoftEng754_A4;

import junit.framework.TestCase;

public class TestAbstraction extends TestCase{
	
	//	Test getCommitDetails
	public void testGetCommitDetails() {
		Abstraction abst = new Abstractor();
		
		assertNotNull(abst.getCommitDetails());
	}
	//	Test getNumberOfCommitedFiles
	//	Test getNamesOfCommitedFiles
	//	Test getCommitAbstract
	//	Test getFileAbstract
	//	Test getTempFileFromRepo
	//	Test deleteTempFileFromRepo

}
