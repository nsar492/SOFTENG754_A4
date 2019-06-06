package SoftEng754_A4.SoftEng754_A4.codeReviewAllocation;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import SoftEng754_A4.SoftEng754_A4.codeReviewAllocation.CodeReviewAllocation;

import static org.junit.Assert.assertNull;

public class AddReviewerToDatabaseSteps {

 // code reviewer object - needs to be renamed to whatever the class name is
   CodeReviewAllocation editReviewers;

    @Given("$name is a reviewer in the database")
    public void givenFredIsAReviewerInTheDatabase(String name){
       // code reviewer object - needs to be renamed to whatever the class name is
        editReviewers = new CodeReviewAllocation();
//        create a user called Fred in the database
        editReviewers.addReviewerToDatabase(name);
    }

    @When("user deletes the reviewer $name")
    public void whenReviewerFredIsDeletedFromTheDatabase(String name){
       // delete user from database
        editReviewers.deleteReviewerFromDatabase(name);
    }

    @Then("$name is removed from the database")
    public void thenReviewerNamedFredShouldNotExsistInTheDatabase( String name){
       // method call to get Fred from database, assert returns null
        String reviewer = getReviewer(name);
        assertNull(reviewer);
    }


}
