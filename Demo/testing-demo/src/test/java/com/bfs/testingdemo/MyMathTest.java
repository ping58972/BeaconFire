package com.bfs.testingdemo;


import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class MyMathTest {
    private MyMath myMath;

    @BeforeAll //method must be static otherwise code will not compile
    static void startingTests() {
        System.out.println("@BeforeALl: Starting the tests");
    }

    @BeforeEach
    void setUpMyMath() {
        System.out.println("@BeforeEach: Set up class");
        myMath = new MyMath();
    }

    @Test
    void testDoubleNumber() {
        assertEquals(0, myMath.doubleNumber(0));
        assertEquals(2, myMath.doubleNumber(1));
        assertEquals(4, myMath.doubleNumber(2));
        assertEquals(-4, myMath.doubleNumber(-2));
    }

    @Test
    void testSquareNumber() {
        assertEquals(0, myMath.squareNumber(0));
        assertEquals(1, myMath.squareNumber(1));
        assertEquals(4, myMath.squareNumber(2));
        assertEquals(4, myMath.squareNumber(-2));
    }

    @Test
    @DisplayName("Test a bunch of asserts at the same time")
    void testAll() {
        assertAll(
                () -> assertEquals(100, myMath.squareNumber(10)),
                () -> assertEquals(25, myMath.squareNumber(5)),
                () -> assertEquals(20, myMath.doubleNumber(10)),
                () -> assertEquals(10, myMath.doubleNumber(5))
        );
    }

    @Disabled
    @Test
    void disabledTest() {
        fail(); // = assertTrue(false);
    }

    @AfterEach
    void afterEachTest() {
        if(myMath != null) {
            myMath = null;
            System.out.println("@AfterEach: Setting counter to null after each test");
        }
    }

    @AfterAll
    static void endingTests() {
        System.out.println("@AfterAll: Ending the tests");
    }
}
