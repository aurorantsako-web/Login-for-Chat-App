/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.login1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author anaka
 */
public class LoginTest {
    
    public LoginTest() {
    }
    @Test
    public void testUsernameCorrectlyFormattedMessage() {
        Login login = new Login();
        String result = login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Adams");
        assertEquals("Username successfully captured.\nPassword successfully captured.", result);
    }

    @Test
    public void testUsernameIncorrectlyFormattedMessage() {
        Login login = new Login();
        String expected = "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        String actual = login.registerUser("kyle!!!!!!", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Adams");
        assertEquals(expected, actual);
    }

    @Test
    public void testPasswordMeetsComplexityMessage() {
        Login login = new Login();
        String result = login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Adams");
        assertTrue(result.contains("Password successfully captured."));
    }

    @Test
    public void testPasswordDoesNotMeetComplexityMessage() {
        Login login = new Login();
        String expected = "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        String actual = login.registerUser("kyl_1", "password", "+27838968976", "Kyle", "Adams");
        assertEquals(expected, actual);
    }

    @Test
    public void testCellPhoneNumberCorrectlyFormattedMessage() {
        Login login = new Login();
        String result = login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Adams");
        assertTrue(result.contains("Username successfully captured."));
    }

    @Test
    public void testCellPhoneNumberIncorrectlyFormattedMessage() {
        Login login = new Login();
        String expected = "Cell phone number is invalid. Please ensure it includes the international country code (+27) and is the correct length.";
        String actual = login.registerUser("kyl_1", "Ch&&sec@ke99!", "08966553", "Kyle", "Adams");
        assertEquals(expected, actual);
    }

    //assertTrue/ assertFalse Tests (Booleans)
    @Test
    public void testCheckUserNameCorrectlyFormatted() {
        Login login = new Login();
        boolean result = login.checkUserName("kyl_1");
        assertTrue(result);
    }

    @Test
    public void testCheckUserNameIncorrectlyFormatted() {
        Login login = new Login();
        boolean result = login.checkUserName("kyle!!!!!!");
        assertFalse(result);
    }

    @Test
    public void testCheckPasswordComplexitySuccess() {
        Login login = new Login();
        boolean result = login.checkPasswordComplexity("Ch&&sec@ke99!");
        assertTrue(result);
    }

    @Test
    public void testCheckPasswordComplexityFailure() {
        Login login = new Login();
        boolean result = login.checkPasswordComplexity("password");
        assertFalse(result);
    }

    @Test
    public void testCheckCellPhoneNumberCorrect() {
        Login login = new Login();
        boolean result = login.checkCellPhoneNumber("+27838968976");
        assertTrue(result);
    }

    @Test
    public void testCheckCellPhoneNumberIncorrect() {
        Login login = new Login();
        boolean result = login.checkCellPhoneNumber("08966553");
        assertFalse(result);
    }
    
    @Test
    public void testLoginSuccessful() {
        Login login = new Login();
        login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Adams");
        boolean success = login.loginUser("kyl_1", "Ch&&sec@ke99!");
        assertTrue(success);
    }

    @Test
    public void testLoginFailed() {
        Login login = new Login();
        login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Adams");
        boolean success = login.loginUser("kyl_1", "wrongPassword");
        assertFalse(success);
    }
}
 