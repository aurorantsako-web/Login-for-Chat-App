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
        //
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
        
        List<Message> storedMessagesList = new ArrayList<>();
        List<Message> sentMessagesList = new ArrayList<>();
        int totalSentCount = 0;
        boolean running = true;

        while (running) {
            System.out.println("\nPlease choose an option:");
            System.out.println("1) Send Messages");
            System.out.println("2) Show recently sent messages");
            System.out.println("3) Quit");
            System.out.println("Stored Messages Menu");
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

                        Message msg = new Message(totalSentCount, recipient, text, "Sent");
                        
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
                case 4:
                    System.out.println("\n--- STORED MESSAGES MENU ---");
                    System.out.println("a) Display sender and recipient of all stored messages");
                    System.out.println("b) Display the longest stored message");
                    System.out.println("c) Search for a message ID and display corresponding recipient and message");
                    System.out.println("d) Search for all messages stored for a particular recipient");
                    System.out.println("e) Delete a message using the message hash");
                    System.out.println("f) Display a report that lists full details of all stored messages");
                    System.out.print("Select sub-option (a-f): ");
                    String subChoice = scanner.nextLine().trim().toLowerCase();
                    
            switch (subChoice) {
                case "a":
                    System.out.println("\n--- Sender & Recipient of Stored Messages ---");
                  for (Message m : storedMessagesList) {
                     System.out.println("Recipient: " + m.getRecipient() + " | Text: " + m.getMessageText());
        }
            break;
                case "b":
                     Message longest = storedMessagesList.stream()
                     .max((m1, m2) -> Integer.compare(m1.getMessageText().length(), m2.getMessageText().length()))
                     .orElse(null);
                    if (longest != null) {
                       System.out.println("\nLongest Stored Message: " + longest.getMessageText());
        }
            break;
                case "c":
                     System.out.print("Enter Message ID to search: ");
                     String searchId = scanner.nextLine();
                  for (Message m : storedMessagesList) {
                      if (m.getMessageID().equals(searchId)) {
                        System.out.println("Recipient: " + m.getRecipient() + " | Message: " + m.getMessageText());
            }
        }
            break;
                case "d":
                     System.out.print("Enter Recipient cell number: ");
                     String searchRecip = scanner.nextLine();
                  for (Message m : storedMessagesList) {
                     if (m.getRecipient().equals(searchRecip)) {
                     System.out.println("Message: " + m.getMessageText());
            }
        }
            break;
                case "e":
                     System.out.print("Enter Message Hash to delete: ");
                     String hashDel = scanner.nextLine();
                     storedMessagesList.removeIf(m -> m.getMessageHash().equalsIgnoreCase(hashDel));
                     System.out.println("Message with hash " + hashDel + " successfully deleted.");
            break;
                case "f":
                     System.out.println("\n--- Full Stored Messages Report ---");
                 for (Message m : storedMessagesList) {
                     System.out.println(m.printMessages() + "\n-------------------");
        }
           break;
          default:
                  System.out.println("Invalid sub-option.");
}          break;
            }
        }
     }
}
     
                    
         