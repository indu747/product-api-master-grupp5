package com.example.produktapi.unit;

import com.example.produktapi.model.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ProductModelTest {
    //Erik Östlind
    @Test
    @DisplayName("getTitle Test")
    void getTitleTest(){
        //Directly give product a title
        Product product = new Product("text",10.0,"kategori","en bra produkt","en bild");
        Assertions.assertEquals("text", product.getTitle(), "Title should be 'text'");
    }
    //Erik Östlind
    @Test
    @DisplayName("Default title is null")
    void getDefaultTitleTest(){
        Product product = new Product();
        //No value is set so it should default null
        Assertions.assertNull(product.getTitle(),"Title should be null by default");
    }
    //Erik Östlind
    @Test
    @DisplayName("setTitle test")
    void setTitleTest(){
        Product product = new Product();
        product.setTitle("Test Title");
        Assertions.assertEquals("Test Title",product.getTitle(), "Title should be 'Test Title'");
    }
    //Erik Östlind
    @Test
    @DisplayName("Default ID is null")
    void getIdTest(){
        //Directly give product a title
        Product product = new Product("text",10.0,"kategori","en bra produkt","en bild");
        Assertions.assertNull(product.getId(), "ID should be null");
    }
    //Erik Östlind
    @Test
    @DisplayName("setId test")
    void setIdTest(){
        Product product = new Product("text",10.0,"kategori","en bra produkt","en bild");
        product.setId(512);
        Assertions.assertEquals(512,product.getId(),"id should be 512");
    }
}
