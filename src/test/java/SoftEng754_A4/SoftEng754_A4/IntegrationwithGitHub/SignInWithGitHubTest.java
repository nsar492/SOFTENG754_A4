package SoftEng754_A4.SoftEng754_A4.IntegrationwithGitHub;

import org.eclipse.egit.github.core.User;
import org.eclipse.egit.github.core.client.RequestException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;


public class SignInWithGitHubTest {
    private String username;
    private String password;
    private SignInWithGitHub signIn;
    private User user;


    @Before
    public void setUp(){
        username = "Hmm";
        password = "123";
        signIn = Mockito.mock(SignInWithGitHub.class);
        user = new User();
        user.setName("Hmm");
    }

//  Testing if username not filled out.
    @Test
    public void testUsernameEmpty() {
        doReturn(false).when(signIn).usernameFilledOut(null);
        assertFalse(signIn.usernameFilledOut(null));
    }

//  Testing if username is filled out.
    @Test
    public void testUsernameNotEmpty() {
        doReturn(true).when(signIn).usernameFilledOut(username);
        assertTrue(signIn.usernameFilledOut(username));
    }

//  Testing if password not filled out
    @Test
    public void testPasswordEmpty() {
        doReturn(false).when(signIn).passwordFilledOut(null);
        assertFalse(signIn.passwordFilledOut(null));
    }

//  Testing if password is filled out
    @Test
    public void testPasswordNotEmpty() {
        doReturn(true).when(signIn).passwordFilledOut(password);
        assertTrue(signIn.passwordFilledOut(password));
    }

//  Testing successful sign in
    @Test
    public void testSignInSuccessful(){
        doReturn(user).when(signIn).signInUser(username, password);
        assertEquals(user, signIn.signInUser(username, password));
    }

//  Testing failed sign in
    @Test(expected = RequestException.class)
    public void testSignInFail(){
        when(signIn.signInUser(username, "1234")).thenThrow(RequestException.class);
        signIn.signInUser(username, "1234");
    }
}