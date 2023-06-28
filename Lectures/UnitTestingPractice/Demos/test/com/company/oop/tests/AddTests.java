package com.company.oop.tests;

import com.company.oop.MyList;
import com.company.oop.MyListImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AddTests {
    @Test
    public void should_StoreElement_When_SingleElement() {
        MyList<Integer> myList = new MyListImpl<>();

        myList.add(5);

        Assertions.assertEquals(5, myList.get(0));
    }

    @Test
    public void should_StoreElement_When_MultipleElemenets() {
        MyList<Integer> myList = new MyListImpl<>();

        myList.add(5);
        myList.add(3);
        myList.add(7);

        Assertions.assertEquals(5, myList.get(0));
        Assertions.assertEquals(3, myList.get(1));
        Assertions.assertEquals(7, myList.get(2));
    }

    @Test
    public void should_UpdateSize_When_SingleElement() {
        MyList<Integer> myList = new MyListImpl<>();

        myList.add(5);

        Assertions.assertEquals(1, myList.size());
    }

    @Test
    public void should_UpdateSize_When_MultiplyElements() {
        MyList<Integer> myList = new MyListImpl<>();

        myList.add(5);
        myList.add(3);
        myList.add(7);

        Assertions.assertEquals(3, myList.size());
    }

    @Test
    public void should_Resize_When_SizeReachCapacity() {
        MyList<Integer> myList = new MyListImpl<>(2);

        myList.add(1);
        myList.add(2);
        myList.add(3);

        Assertions.assertTrue(myList.capacity() > 2);
    }
}
