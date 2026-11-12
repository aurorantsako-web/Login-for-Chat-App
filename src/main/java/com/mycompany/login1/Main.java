/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.login1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author anaka
 */
public class Main {

    
    
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Login loginSystem = new Login();
        
        System.out.println("=== QuickChat Authentication ===");
        
       // Step 1: User registration
        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();
        
        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();
        
        System.out.print("Enter Username: ");
        String username = scanner.nextLine();
        
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();
        
        System.out.print("Enter Cell Phone (+27...): ");
        String phone = scanner.nextLine();
        
        String regStatus = loginSystem.registerUser(username, password, phone, firstName, lastName);
        System.out.println(regStatus);
        
       //Require successful registration before proceeeding.
        if (!regStatus.contains("successfully")) {
            System.out.println("Registration failed. Exiting system.");
            return;
        }

        // Step 2: User Login
        System.out.println("\n=== QuickChat Login ===");
        System.out.print("Enter Username: ");
        String loginUser = scanner.nextLine();
        
        System.out.print("Enter Password: ");
        String loginPass = scanner.nextLine();
        
        boolean isAuthenticated = loginSystem.loginUser(loginUser, loginPass);
        System.out.println(loginSystem.returnLoginStatus(isAuthenticated));
        
        if (!isAuthenticated) {
            System.out.println("Access Denied.");
            return;
        }

        // Step 3: QuickChat Main Menu Loop
        System.out.println("\nWelcome to QuickChat");
        
        List<Message> sentMessagesList = new ArrayList<>();
        int totalSentCount = 0;
        boolean running = true;

        while (running) {
            System.out.println("\nPlease choose an option:");
            System.out.println("1) Send Messages");
            System.out.println("2) Show recently sent messages");
            System.out.println("3) Quit");
            System.out.print("Option: ");

            String inputChoice = scanner.nextLine();
            int choice = 0;
            try {
                choice = Integer.parseInt(inputChoice);
            } catch (NumberFormatException e) {
                System.out.println("Invalid numeric option. Please try again.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("\nHow many messages would you like to send? ");
                    int numCount = Integer.parseInt(scanner.nextLine());

                    for (int i = 0; i < numCount; i++) {
                        totalSentCount++;
                        System.out.println("\n--- Entering Message " + totalSentCount + " ---");
                        
                        System.out.print("Enter Recipient Cell Number: ");
                        String recipient = scanner.nextLine();
                        
                        System.out.print("Enter Message Text: ");
                        String text = scanner.nextLine();

                        Message msg = new Message(totalSentCount, recipient, text);
                        
                        String lenCheck = msg.checkMessageLength(text);
                        System.out.println(lenCheck);
                        
                        if (lenCheck.equals("Message ready to send.")) {
                            System.out.println("Select Message Action:");
                            System.out.println("1) Send Message");
                            System.out.println("2) Disregard Message");
                            System.out.println("3) Store Message to send later");
                            System.out.print("Choice: ");
                            int actionChoice = Integer.parseInt(scanner.nextLine());
                            
                            String actionResult = msg.SentMessage(actionChoice);
                            System.out.println(actionResult);
                            
                            if (actionChoice == 1) {
                                sentMessagesList.add(msg);
                                System.out.println("\n--- Message Details ---");
                                System.out.println(msg.printMessages());
                            } else if (actionChoice == 3) {
                                System.out.println("\nStored JSON Output:");
                                System.out.println(msg.storeMessage());
                            }
                        }
                    }
                    System.out.println("\nTotal messages accumulated sent: " + sentMessagesList.size());
                    break;

                case 2:
                    System.out.println("Coming Soon.");
                    break;

                case 3:
                    running = false;
                    System.out.println("Exiting QuickChat. Total messages sent during session: " + sentMessagesList.size());
                    break;

                default:
                    System.out.println("Invalid option. Please enter 1, 2, or 3.");
                    break;
            }
        }
    }
}