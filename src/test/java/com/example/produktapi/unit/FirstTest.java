package com.example.produktapi.unit;
import org.junit.jupiter.api.*;

public class FirstTest {
 //Skapar en första test Klass för att se till att projektet fungerar. Erik Östlind
    @Test
    @DisplayName("Make sure it works")
    void doesThisWork(){
       boolean isTrue = true;


       Assertions.assertTrue(isTrue);
    }
}
