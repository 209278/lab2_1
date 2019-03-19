package edu.iis.mto.bsearch;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTest {

    @Test
    public void elementFound() {
        int[] seq = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int key = 5;

        SearchResult searchResult = BinarySearch.search(key, seq);

        assertEquals(true, searchResult.isFound());
        assertEquals( key, seq[searchResult.getPosition()]);
    }
    
}
