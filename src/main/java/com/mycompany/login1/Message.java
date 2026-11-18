/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.login1;
import java.util.Random;
/**
 *
 * @author anaka
 */
public class Message {
    
   private String messageID;
    private int numMessagesSent;
    private String recipient;
    private String messageText;
    private String messageHash; 
    private String flag;
    
    public Message() {
    }
    public Message(int numMessagesSent, String recipient, String messageText, String flag) {
        this.numMessagesSent = numMessagesSent;
        this.recipient = recipient;
        this.messageText = messageText;
        this.flag = flag;
        this.messageID = generateMessageID();
        this.messageHash = createMessageHash();
    }
    public String generateMessageID() {
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(rand.nextInt(10));
        }
        return sb.toString();
    }
   public boolean checkMessageID() {
        return this.messageID != null && this.messageID.length() <= 10;
    }
   public String checkMessageLength(String messageText) {
        if (messageText == null) {
            return "Please enter a message of less than 250 characters.";
        }
        if (messageText.length() <= 250) {
            return "Message ready to send.";
        } else {
            int excess = messageText.length() - 250;
            return "Message exceeds 250 characters by " + excess + "; please reduce the size.";
        }
    }
   public String checkRecipientCell() {
        if (recipient == null) {
            return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
        }
        
        if (recipient.startsWith("+") && recipient.length() <= 12) {
            return "Cell phone number successfully captured.";
        } else {
            return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
        }
    }
   
    public String createMessageHash() {
        if (messageID == null || messageID.length() < 2 || messageText == null || messageText.trim().isEmpty()) {
            return "";
        }

        String firstTwoID = messageID.substring(0, 2);
        String[] words = messageText.trim().split("\\s+");
        String firstWord = words[0].replaceAll("[^a-zA-Z0-9]", "");
        String lastWord = words[words.length - 1].replaceAll("[^a-zA-Z0-9]", "");

        String rawHash = firstTwoID + ":" + numMessagesSent + ":" + firstWord + lastWord;
        return rawHash.toUpperCase();
    }
    public String SentMessage(int choice) {
        switch (choice) {
            case 1:
                return "Message successfully sent.";
            case 2:
                return "Press 0 to delete the message.";
            case 3:
                return storeMessage();
            default:
                return "Invalid option selected.";
        }
    }
    public String storeMessage() {
        return "{\n" +
               "  \"messageID\": \"" + messageID + "\",\n" +
               "  \"numMessagesSent\": " + numMessagesSent + ",\n" +
               "  \"recipient\": \"" + recipient + "\",\n" +
               "  \"messageText\": \"" + messageText.replace("\"", "\\\"") + "\",\n" +
               "  \"messageHash\": \"" + messageHash + "\"\n" +
               "}";
    }

    public String printMessages() {
        return "Message ID: " + messageID + "\n" +
               "Message Hash: " + messageHash + "\n" +
               "Recipient: " + recipient + "\n" +
               "Message: " + messageText;
    }

    public int returnTotalMessagess(int count) {
        return count;
    }

    // Getters and Setters
    public String getMessageID() { return messageID; }
    public void setMessageID(String messageID) { 
        this.messageID = messageID; 
        this.messageHash = createMessageHash(); 
    }
    public int getNumMessagesSent() { return numMessagesSent; }
    public String getRecipient() { return recipient; }
    public String getMessageText() { return messageText; }
    public String getMessageHash() { return messageHash; }
    public String getFlag() {return flag; }
    public void setFlag(String flag) {this.flag = flag; }
}

