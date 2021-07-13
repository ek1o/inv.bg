import org.junit.Test;

public class Opit {
    //@Test
    public void opit(){

        HomePage.setSubDomain();
        LogInPage.logIn();
        UserHomePage.verifySuccessfulLogIn();
        UserHomePage.verifyCorrectEmail("emil@thenet.bg");


    }
}
