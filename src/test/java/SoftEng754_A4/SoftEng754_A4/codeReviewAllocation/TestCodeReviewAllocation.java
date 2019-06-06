package SoftEng754_A4.SoftEng754_A4.codeReviewAllocation;

import java.util.ArrayList;

import javax.sound.sampled.ReverbType;

import org.junit.Before;
import org.junit.BeforeClass;
import org.mockito.Mockito;

import junit.framework.TestCase;

public class TestCodeReviewAllocation extends TestCase{

	private CodeReviewAllocation reviewAllocator;
	
	/*
	 *  test add non-developer reviewer to database
	 *  test add non-developer reviewer to database - negative
	 *  test delete non-developer reviewer to database
	 *  test delete non-developer reviewer to database - negative
	 *  test update database
	 *  test update database - negative
	 *  test get reviewer list from database
	 *  test get reviewer list from database - negative
	 *  test get available reviewer
	 *  test get available reviewer - negative
	 *  test update reviewer information in database
	 *  test update reviewer information in database - negative
	 * */
	
	public TestCodeReviewAllocation()
	{
//		System.out.println("coming here");
		reviewAllocator = new CodeReviewAllocator();
		reviewAllocator.openDatabaseConnection();
	}
	
	public void testAddReviewerToDatabase()
	{
		
		String reviewerName = "Ranveer";
		// When - Then
//		Mockito.when(reviewAllocator.addReviewerToDatabase("abc")).thenReturn(true);
		
		assertTrue(reviewAllocator.addReviewerToDatabase(reviewerName));
	}
	/*
	public void testDatabaseConnection() {
		
	}
	
	@BeforeClass
	public void initReviewAllocatorObject()
	{
		this.reviewAllocator = Mockito.mock(CodeReviewAllocation.class);
	}
	
	
	
	public void testAddReviewerToDatabase_Negative()
	{
		// When - Then
		Mockito.when(reviewAllocator.addReviewerToDatabase("abc")).thenReturn(false);
		
		assertFalse(reviewAllocator.addReviewerToDatabase("abc"));
	}

	public void testDeleteReviewerFromDatabase()
	{
		// When - Then
		Mockito.when(reviewAllocator.deleteReviewerFromDatabase("abc")).thenReturn(true);
		
		assertTrue(reviewAllocator.deleteReviewerFromDatabase("abc"));
	}

	public void testDeleteReviewerFromDatabase_Negative()
	{
		// When - Then
		Mockito.when(reviewAllocator.deleteReviewerFromDatabase("abc")).thenReturn(false);
		
		assertFalse(reviewAllocator.deleteReviewerFromDatabase("abc"));
	}


	public void testGetReviewerListFromDatabase()
	{
		// When - Then
		Mockito.when(reviewAllocator.getReviewerListFromDatabase()).thenReturn(new ArrayList<String>());
		
		assertNotNull(reviewAllocator.getReviewerListFromDatabase());
	}
	
	public void testGetReviewerListFromDatabase_Negative()
	{
		// When - Then
		Mockito.when(reviewAllocator.getReviewerListFromDatabase()).thenReturn(null);
		
		assertNull(reviewAllocator.getReviewerListFromDatabase());
	}

	public void testGetAvailableReviewerFromDatabase()
	{
		// When - Then
		Mockito.when(reviewAllocator.getAvailableReviewerFromDatabase()).thenReturn("abc");
		
		assertNotNull(reviewAllocator.getAvailableReviewerFromDatabase());
	}

	public void testGetAvailableReviewerFromDatabase_Negative()
	{
		// When - Then
		Mockito.when(reviewAllocator.getAvailableReviewerFromDatabase()).thenReturn(null);
		
		assertNull(reviewAllocator.getAvailableReviewerFromDatabase());
	}

	public void testUpdateReviewerInfoInDatabase()
	{
		// When - Then
		Mockito.when(reviewAllocator.updateCompletedReviewInDatabase("abc")).thenReturn(true);
		
		assertTrue(reviewAllocator.updateCompletedReviewInDatabase("abc"));
	}
	
	public void testUpdateReviewerInfoInDatabase_Negative()
	{
		// When - Then
		Mockito.when(reviewAllocator.updateCompletedReviewInDatabase("abc")).thenReturn(false);
		
		assertFalse(reviewAllocator.updateCompletedReviewInDatabase("abc"));
	}
	*/
}
