/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.login1;
import java.util.Scanner;
/**
 *
 * @author anaka
 */
public class Main {
    
      public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      Login login = new Login();
      
        System.out.println("==== CHAT APP REGISTRATION ====");
        
        System.out.println("Enter First Name: ");
        String firstname = input.nextLine();
        
        System.out.println("Enter Last Name: ");
        String lastname = input.nextLine();
        
        String  username;
        String password;
        String phoneNumber;
        String registrationMessage = null;
        
        while(true){
            System.out.println("Enter Username: ");
            username = input.nextLine();
            System.out.println("Enter Password: ");
            password = input.nextLine();
            System.out.println("Enter Cell Phone (+27...): ");
            phoneNumber = input.nextLine();
            
            registrationMessage = login.registerUser(username, password, phoneNumber, firstname, lastname);
            System.out.println(registrationMessage);
            
            // Check if registration successfully captured user details
            if (registrationMessage != null && registrationMessage.contains("successfully captured")){
                break;
            }
        }
        // --- LOGIN FLOW ---
        System.out.println("==== CHAT APP LOGIN ====");
         while (true){
             System.out.println("Enter Username: ");
             String loginUsername = input.nextLine();
             
             System.out.println("Enter Password: ");
             String loginPassword = input.nextLine();
             
             // Verify entered credentials against saved instance values
             boolean success = login.loginUser(loginUsername, loginPassword);
             String statusMessage = login.returnLoginStatus(success);
             
             System.out.println(statusMessage + "\n");
             
             if (success){
                 break;
             }
        }
        input.close();
    }
}