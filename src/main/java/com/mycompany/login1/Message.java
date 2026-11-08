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
    
    public Message() {
    }
    public Message(int numMessagesSent, String recipient, String messageText) {
        this.numMessagesSent = numMessagesSent;
        this.recipient = recipient;
        this.messageText = messageText;
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
   
    
}
