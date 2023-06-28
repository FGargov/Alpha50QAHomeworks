package com.company.oop.tests;

import com.company.oop.MyList;
import com.company.oop.MyListImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ConstructorTests {
    private MyList<Integer> list;

    @BeforeEach
    public void initList() {
        list = new MyListImpl<>();
    }

    @Test
    public void should_CreateEmptyList() {
       // MyList<Integer> list = new MyListImpl<>();

        Assertions.assertEquals(0, list.size());
    }

    @Test
    public void should_UseDefaultCapacity() {
       // MyList<Integer> list = new MyListImpl<>();

        Assertions.assertEquals(5, list.capacity());
    }

    @Test
    public void should_UseCustomCapacity_When_Specified() {
       MyList<Integer> list = new MyListImpl<>(10);

        Assertions.assertEquals(10, list.capacity());
    }

    @Test
    public void constructor_Should_UseCustomCapacity_When_Specified_WithArrangeActAssert() {
        //Arrange
        MyList<Integer> list = new MyListImpl<>(10);

        //Act
        int capacity = list.capacity();

        //Assert
        Assertions.assertEquals(10, capacity);
    }

    @Test
    public void get_Should_Throw_When_InvalidIndex() {
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> list.get(-3));
    }
}

