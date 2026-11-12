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
    
    
}
