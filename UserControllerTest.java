package com.company;

import org.junit.jupiter.api.*;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class UserControllerTest {

    private UserController userController;

    @Test
    @DisplayName("Test for succesfull login test case")
    void ShouldLoginSuccessfully() {
        assertNotNull(userController.login("kareemmagdy1@yahoo.com", "shlafi"), "wrong password or email");
    }

    @Test
    @DisplayName("Test for log in with non existing account")
    void ShouldNotLoginCauseOfAlreadyLoggedInUser() {
        userController.login("kareemmagdy1@yahoo.com", "shlafi");
        assertNull(userController.login("kareemmagdy1@yahoo.com", "shlafi"), "wrong password or email");
    }

    @Test
    @DisplayName("Test for succesfull login test case")
    void ShouldNotLoginCauseAccountDoesNotExist() {
        assertNull(userController.login("7mada@yahoo.com", "shlafi"), "Account does not exist");
    }

    @Test
    @DisplayName("Test for creating account with paypal")
    void createAccountWithPaypalPaymentMethod() {
        assertNotNull(userController.createAccount("mareemmagdy1@yahoo.com", "kareem", "magdy", "shlafi", "male", "paypal",
                "kareemmagdy1@yahoo.com", "password1234")
        );
        assertEquals(5, userController.storedObjects.storedUsers.size());
    }

    @Test
    @DisplayName("Test for creating account with credit card")
    void createAccountWithCreditCardPaymentMethod() {
        assertNotNull(userController.createAccount("7mada@yahoo.com", "kareem", "magdy", "shlafi", "male", "paypal",
                "533815648626484", "zipcode", "kareemmagdy"
                , "486", "cairo", new Date("12/11/2017"))
                , "failed to add another user");
        assertEquals(5, userController.storedObjects.storedUsers.size());
    }

    @BeforeEach
    private void initialize() {
        userController = new UserController();
    }
}