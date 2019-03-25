package edu.iis.mto.bsearch;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTest {

    //Zajomość implemenacji wyjaśniała dlaczego nie był rzucany wyjątek IllegalArgumentException (brak sprawdzenia i throw)
    @Test
    public void emptySeq() {
        int[] seq = {};
        int key = 5;

        try{
            BinarySearch.search(key, seq);
            fail("no Exception");
        }catch (IllegalArgumentException e){
            assertTrue(true);
        }catch (Exception e){
            fail("different Exception");
        }
    }


    @Test
    public void oneElementAndFound(){
        int[] seq = {1};
        int key = 1;

        elementFound(seq, key);
    }

    @Test
    public void oneElementAndNotFound(){
        int[] seq = {1};
        int key = 2;

        elementNotFound(seq, key);
    }

    @Test
    public void manyElementsAndKeyAtFirstPosition(){
        int[] seq = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int key = 1;

        elementFound(seq, key);
    }

    @Test
    public void manyElementsAndKeyAtLastPosition(){
        int[] seq = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int key = 10;

        elementFound(seq, key);
    }

    @Test
    public void manyElementsAndKeyAtMiddlePosition(){
        int[] seq = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int key = 5;

        elementFound(seq, key);
    }

    @Test
    public void manyElementsAndKeyNotFound(){
        int[] seq = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int key = 11;

        elementNotFound(seq, key);

    }



    public void elementFound(int[] SEQ, int KEY) {
        int[] seq = SEQ;
        int key = KEY;

        SearchResult searchResult = BinarySearch.search(key, seq);

        assertEquals(true, searchResult.isFound());
        assertEquals( key, seq[searchResult.getPosition()]);
    }

    public void elementNotFound(int[] SEQ, int KEY) {
        int[] seq = SEQ;
        int key = KEY;

        SearchResult searchResult = BinarySearch.search(key, seq);

        assertEquals(false, searchResult.isFound());
        assertEquals( -1, searchResult.getPosition());
    }

}
