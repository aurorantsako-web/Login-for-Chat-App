/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.login1;

/**
 *
 * @author anaka
 */
public class Login1 {

    public class Login {
    
    private String username;
    private String password;
    private String cellPhoneNumber;
    private String firstName;
    private String lastName;
    
    public Login() {
    }
    
    public boolean checkUserName(String username) {
        if (username == null) {
            return false;
        }
        boolean hasUnderscore = username.contains("_");
        boolean isValidLength = username.length() <= 5;
        return hasUnderscore && isValidLength;
    }
    
    public boolean checkPasswordComplexity(String password) {
        if (password == null) {
            return false;
        }
        boolean hasMinLength = password.length() >= 8;
        boolean hasUpper = !password.equals(password.toLowerCase());
        boolean hasNum = password.matches(".*\\d.*");
        boolean hasSpecial = password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?].*");

        return hasMinLength && hasUpper && hasNum && hasSpecial;
    }
    
    public boolean checkCellPhoneNumber(String cellPhoneNumber) {
        if (cellPhoneNumber == null) {
            return false;
        }
        return cellPhoneNumber.startsWith("+27") && cellPhoneNumber.length() == 12 && cellPhoneNumber.substring(1).matches("\\d+");  
    }
    
    public String registerUser(String username, String password, String cellPhoneNumber, String firstName, String lastName) {
        if (!checkUserName(username)) {
            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        }
        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }
        if (!checkCellPhoneNumber(cellPhoneNumber)) {
            return "Cell phone number incorrectly formatted or does not contain international code; please correct the number and try again.";
        }
        return "Username successfully captured.\nPassword successfully captured.\nCell phone number successfully added.\nUser registered successfully.";
    }
    
    public boolean loginUser(String enteredUsername, String enteredPassword) {
        if (username == null || password == null) {
            return false;
        }
        return username.equals(enteredUsername) && password.equals(enteredPassword);
    }
    
    public String returnLoginStatus(boolean loginSuccess) {
        if (loginSuccess) {
            return "Welcome " + firstName + " ," + lastName + " it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
    
}
}
     
    

