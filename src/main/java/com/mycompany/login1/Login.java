/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.login1;

/**
 *
 * @author anaka
 */
public class Login {

    private String username;
    private String password;
    private String phoneNumber;
    private String firstName;
    private String lastName;
   
    //default constructor
    public Login() {}

    // checks if the username contains an underscore (_) and is no more than 5 characters long.
    public boolean checkUserName(String username) {
        if (username == null) {
            return false;
        }
        return username.contains("_") && username.length() <= 5;
    }

    
    public boolean checkPasswordComplexity(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }

        boolean hasUpper = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        for (int i = 0; i < password.length(); i++) {
            String singleLetter = password.substring(i, i + 1);

            if (singleLetter.matches("[A-Z]")) {
                hasUpper = true;
            } else if (singleLetter.matches("[0-9]")) {
                hasDigit = true;
            } else if (!singleLetter.matches("[a-zA-Z0-9]")) {
                hasSpecial = true;
            }
        }

        return hasUpper && hasDigit && hasSpecial;
    }

    public boolean checkCellPhoneNumber(String phoneNumber) {
        if (phoneNumber == null) {
            return false;
        }
        return phoneNumber.startsWith("+27") && phoneNumber.length() == 12 && phoneNumber.substring(1).matches("\\d+");
    }

    public String registerUser(String username, String password, String phoneNumber, String firstName, String lastName) {
        if (!checkUserName(username)) {
            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
       }

        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }

        if (!checkCellPhoneNumber(phoneNumber)) {
            return "Cell phone number is invalid. Please ensure it includes the international country code (+27) and is the correct length.";
        }

        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;

        return "Username successfully captured.\nPassword successfully captured.";
    }
    //Validates credetials against saved state
    public boolean loginUser(String enteredUsername, String enteredPassword) {
        return enteredUsername != null && enteredPassword != null 
                && enteredUsername.equals(this.username) 
                && enteredPassword.equals(this.password);
    }
    // Returns appropriate message showing the login status
    
    public String returnLoginStatus(boolean isLoggedIn) {
        if (isLoggedIn) {
            return "Welcome " + firstName + ", " + lastName + " it is great to see you again.";
        }
        return "Username or password incorrect, please try again.";
    }
}
   

