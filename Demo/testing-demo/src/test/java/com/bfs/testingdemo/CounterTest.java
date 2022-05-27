package com.bfs.testingdemo;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CounterTest {
    private Counter counter;

    @BeforeAll //method must be static otherwise code will not compile
    static void startingTests() {
        System.out.println("@BeforeALl: Starting the tests");
    }

    @BeforeEach
    void setUpCounter() {
        System.out.println("@BeforeEach: Set up counter");
        counter = new Counter();
    }

    @Test
    void testIncrement() {
        assertEquals(1, counter.increment());
        assertEquals(2, counter.increment());
        assertEquals(3, counter.increment());
    }

    @Test
    void testDecrement() {
        assertEquals(-1, counter.decrement());
        assertEquals(-2, counter.decrement());
        assertEquals(-3, counter.decrement());
    }

    @Test
    @DisplayName("Test a bunch of asserts at the same time")
    void testAll() {
        assertAll(
                () -> assertEquals(1, counter.increment()), // 0 - 1
                () -> assertEquals(0, counter.decrement()), // 1 - 0
                () -> assertEquals(1, counter.increment()), // 0 - 1
                () -> assertEquals(2, counter.increment()), // 1 - 2
                () -> assertEquals(2, counter.getCurrentValue())
        );
    }

    @AfterEach
    void afterEachTest() {
        if(counter != null) {
            counter = null;
            System.out.println("@AfterEach: Setting counter to null after each test");
        }
    }

    @AfterAll
    static void endingTests() {
        System.out.println("@AfterAll: Ending the tests");
    }
}

