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
    //Omar
    @Test
    @DisplayName("getCategory Test")
    public void getCategoryTest(){
        Product product = new Product("Test produkt",20.0,"Test Category","produkten är i toppklass","En bild");
        Assertions.assertEquals("Test Category", product.getCategory(), "Category should be 'Test Category'");
    }
    //Omar
    @Test
    @DisplayName("setCategory Test")
    public void setCategoryTest(){
        Product product = new Product("Test produkt",20.0,"Test Category","Produkten är i toppklass","En bild");
        product.setCategory("Category Cars");
        Assertions.assertEquals("Category Cars", product.getCategory(), "Category should be 'Category Cars'");
    }
    //Omar
    @Test
    @DisplayName("GetPrice Test")
    public void getPriceTest(){
        Product product = new Product("Test produkt",30.0,"Test Category","produkten är i toppklass","En bild");
        Assertions.assertEquals(30.0, product.getPrice(), "Price should be 'Test Price'");
    }
    //Omar
    @Test
    @DisplayName("setPrice Test")
    public void setPriceTest(){
        Product product = new Product("Test produkt",30.0,"Test Category","Produkten är i toppklass","En bild");
        product.setPrice(40.0);
        Assertions.assertEquals(40.0, product.getPrice(), "Price should be '40.0'");
    }





    //Patricia
    @Test
    @DisplayName("getDescription Test")
    public void getDescriptionTest () {
        Product product = new Product("Cutest Dog", 99.0, "Dog Cathegory", "Cutest Dog In The World", "Picture");
        Assertions.assertEquals("Cutest Dog In The World", product.getDescription());
    }

    //Patricis
    @Test
    @DisplayName("setDescriptionTest")
    public void setDescriptionTest () {
        Product product = new Product("Cutest Cat", 59.0, "Cat Cathegory", "Cutest Cat In The World", "Picture");
        product.setDescription("Cutest Cat In The World");
        Assertions.assertEquals("Cutest Cat In The World", product.getDescription());
    }

    //Patricia
    @Test
    @DisplayName("setImageTest")
    public void setImageTest (){
        Product product = new Product ("CatDogs", 19.0, "CatDogs Cathehory", "Cutest CatDogs In The World", "CatDog");
        product.setImage("CatDog");
        Assertions.assertEquals("CatDog", product.getImage());
    }

    //Patricia
    @Test
    @DisplayName("getImageTest")
    public void getImageTest (){
        Product product = new Product ("Test product", 45.0, "Test Cathegory", "Best product","CatDog");
        Assertions.assertEquals("CatDog", product.getImage());
    }

}
