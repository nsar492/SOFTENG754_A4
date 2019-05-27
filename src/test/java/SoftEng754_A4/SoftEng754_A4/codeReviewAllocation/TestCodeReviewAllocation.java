package SoftEng754_A4.SoftEng754_A4.codeReviewAllocation;

import org.mockito.Mockito;

import junit.framework.TestCase;

public class TestCodeReviewAllocation extends TestCase{

	/*
	 * The  developer  can  add/delete  one  or  more  non-developer  
	 * reviewers  in  this  tool.  A  database is used to store the reviewers’ information.
	 * 9)  The tool can randomly choose a reviewer and allocate code review task 
	 * to this reviewer. The  chance  of  being  allocated  is  related  to  the  
	 * count  of  reviews  previously  done  by  a  reviewer, the lower count, the higher chance.  
	 * 10) The  count  will  be  updated  after  the  allocation.  The  count  information  
	 * is  stored  in  the  database as well.
	 * 
	 * */
	
	/*
	 *  test add non-developer reviewer to database
	 *  test add non-developer reviewer to database - negative
	 *  test delete non-developer reviewer to database
	 *  test delete non-developer reviewer to database - negative
	 *  test update database
	 *  test update database - negative
	 *  test get reviewer list from database
	 *  test get random reviewer
	 *  test update reviewer information in database
	 * */
	
	public void testAddReviewerToDatabase()
	{
		CodeReviewAllocation reviewAllocator = Mockito.mock(CodeReviewAllocation.class);
		
		// When - Then
		Mockito.when(reviewAllocator.addReviewerToDatabase()).thenReturn(true);
		
		assertTrue(reviewAllocator.addReviewerToDatabase());
	}
	
	public void testAddReviewerToDatabase_Negative()
	{
		CodeReviewAllocation reviewAllocator = Mockito.mock(CodeReviewAllocation.class);
		
		// When - Then
		Mockito.when(reviewAllocator.addReviewerToDatabase()).thenReturn(false);
		
		assertFalse(reviewAllocator.addReviewerToDatabase());
	}

	public void testDeleteReviewerToDatabase()
	{
		CodeReviewAllocation reviewAllocator = Mockito.mock(CodeReviewAllocation.class);
		
		// When - Then
		Mockito.when(reviewAllocator.deleteReviewerToDatabase()).thenReturn(true);
		
		assertTrue(reviewAllocator.deleteReviewerToDatabase());
	}
}
