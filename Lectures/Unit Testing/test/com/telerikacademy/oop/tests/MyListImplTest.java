package com.telerikacademy.oop.tests;

import com.company.oop.MyList;
import com.company.oop.MyListImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MyListImplTest {
    private MyList<Integer> list;

    @BeforeEach
    public void initList() {
        list = new MyListImpl<>();
    }

    @Test
    public void constructor_Should_CreateEmptyList() {
        Assertions.assertEquals(0 , list.size());
    }

    @Test
    public void constructor_Should_UseDefaultCapacity() {
        Assertions.assertEquals(5 , list.capacity());
    }

    @Test
    public void constructor_Should_UseCustomCapacity_When_Specified() {
        MyList<Integer> list = new MyListImpl<>(10); // Тук го оставяме в локална променлива, защото все пак правим промяна с листа.

        Assertions.assertEquals(10 , list.capacity());
    }
//Arrange Act Assert се използват при по-сложните тестове.
    @Test
    public void constructor_Should_UseCustomCapacity_When_Specified_WithArrangeActAssert() {
        //Arrange
        MyList<Integer> list = new MyListImpl<>(10); // Тук го оставяме в локална променлива, защото все пак правим промяна с листа.

        //Act
        int size = list.capacity();

        //Assert
        Assertions.assertEquals(10 , size);
    }

    /*@Test
    public void constructor_Should_UseCustomCapacity_When_Specified2() {
        MyList<Integer> list = new MyListImpl<>(10);

        Assertions.assertEquals(5 , list.capacity());
    }*/

    @Test
    public void get_Should_ThrowException_When_InvalidIndex() {
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> list.get(-3));
    }
}
