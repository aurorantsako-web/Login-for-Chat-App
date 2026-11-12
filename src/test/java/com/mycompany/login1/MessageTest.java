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
public class MessageTest {
    
    public MessageTest() {
    }

    @Test
    public void testMessageLengthSuccess() {
        Message msg = new Message();
        String validMessage = "Hi Mike, can you join us for dinner tonight?";
        String expected = "Message ready to send.";
        String actual = msg.checkMessageLength(validMessage);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testMessageLengthFailure() {
        Message msg = new Message();
        // Construct string > 250 chars
        StringBuilder longMsg = new StringBuilder();
        for (int i = 0; i < 260; i++) {
            longMsg.append("a");
        }
        String actual = msg.checkMessageLength(longMsg.toString());
        assertTrue(actual.contains("Message exceeds 250 characters by 10"));
    }

    @Test
    public void testRecipientCellSuccess() {
        Message msg = new Message(1, "+27718693002", "Test");
        String expected = "Cell phone number successfully captured.";
        String actual = msg.checkRecipientCell();
        assertEquals(expected, actual);
    }

    @Test
    public void testRecipientCellFailure() {
        Message msg = new Message(1, "08575975889", "Test");
        String expected = "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
        String actual = msg.checkRecipientCell();
        assertEquals(expected, actual);
    }

    @Test
    public void testMessageHashCreationTest1() {
       //Test case 1 data from rubric
        Message msg = new Message(1, "+27718693002", "Hi Mike, can you join us for dinner tonight?");
        msg.setMessageID("0012345678"); // Override ID to match rubric prefix test
        String expectedHash = "00:1:HITONIGHT";
        assertEquals(expectedHash, msg.createMessageHash());
    }

    @Test
    public void testMessageIDCreation() {
        Message msg = new Message(1, "+27718693002", "Hello");
        assertTrue(msg.checkMessageID());
    }

    @Test
    public void testMessageSentOptions() {
        Message msg = new Message(1, "+27718693002", "Hello");
        
        assertEquals("Message successfully sent.", msg.SentMessage(1));
        assertEquals("Press 0 to delete the message.", msg.SentMessage(2));
        assertTrue(msg.SentMessage(3).contains("\"messageID\""));
    }
}

