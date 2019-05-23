package SoftEng754_A4.SoftEng754_A4.IntegrationwithGitHub;

import org.eclipse.egit.github.core.User;


public interface SignInWithGitHub {
    boolean usernameFilledOut(String username);
    boolean passwordFilledOut(String password);
    User signInUser(String username, String password);
}


