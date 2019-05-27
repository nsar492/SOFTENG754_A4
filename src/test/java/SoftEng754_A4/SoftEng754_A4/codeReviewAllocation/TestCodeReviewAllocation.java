package SoftEng754_A4.SoftEng754_A4.codeReviewAllocation;

import java.util.ArrayList;

import javax.sound.sampled.ReverbType;

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
	 *  test get random reviewer
	 *  test get random reviewer - negative
	 *  test update reviewer information in database
	 *  test update reviewer information in database - negative
	 * */
	
	@BeforeClass
	public void initReviewAllocatorObject()
	{
		this.reviewAllocator = Mockito.mock(CodeReviewAllocation.class);
	}
	
	public void testAddReviewerToDatabase()
	{
		// When - Then
		Mockito.when(reviewAllocator.addReviewerToDatabase()).thenReturn(true);
		
		assertTrue(reviewAllocator.addReviewerToDatabase());
	}
	
	public void testAddReviewerToDatabase_Negative()
	{
		// When - Then
		Mockito.when(reviewAllocator.addReviewerToDatabase()).thenReturn(false);
		
		assertFalse(reviewAllocator.addReviewerToDatabase());
	}

	public void testDeleteReviewerFromDatabase()
	{
		// When - Then
		Mockito.when(reviewAllocator.deleteReviewerFromDatabase()).thenReturn(true);
		
		assertTrue(reviewAllocator.deleteReviewerFromDatabase());
	}

	public void testDeleteReviewerFromDatabase_Negative()
	{
		// When - Then
		Mockito.when(reviewAllocator.deleteReviewerFromDatabase()).thenReturn(false);
		
		assertFalse(reviewAllocator.deleteReviewerFromDatabase());
	}

	public void testUpdateDatabase()
	{
		// When - Then
		Mockito.when(reviewAllocator.updateDatabase()).thenReturn(true);
		
		assertTrue(reviewAllocator.updateDatabase());
	}

	public void testUpdateDatabase_Negative()
	{
		// When - Then
		Mockito.when(reviewAllocator.updateDatabase()).thenReturn(false);
		
		assertFalse(reviewAllocator.updateDatabase());
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

}
