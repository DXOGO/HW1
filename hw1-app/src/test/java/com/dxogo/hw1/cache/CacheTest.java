package com.dxogo.hw1.cache;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

public class CacheTest {

    Cache cache;

    @BeforeEach
    void testBeforeEach() throws InterruptedException {
        this.cache = new Cache(2);
    }

    @AfterEach
    void clear(){ this.cache.clear(); }

    @DisplayName("Cache is empty on construction")
    @Test
    void isEmpty(){ 
        assertTrue(cache.isEmpty()); 
        
        cache.add("cache", "empty_test");
        assertFalse(cache.isEmpty());
        
        cache.clear();
        assertTrue(cache.isEmpty());
    }


    @DisplayName("Add item to cache")
    @Test
    public void addTest() {
        cache.add("cache", "add_test");

        assertEquals(cache.get("cache"), "add_test");
        assertEquals(cache.size(), 1);
    }
    

    @DisplayName("After n add to an empty cache, n > 0, cache is not empty and its size is n")
    @Test
    public void addAndCleanTest() {
        
        assertTrue(cache.isEmpty());

        cache.add("cache1", "add_t1");
        cache.add("cache2", "add_t2");
        cache.add("cache3", "add_t3");
        
        assertEquals( cache.size(), 3);

        cache.clean("cache1");
        
        assertEquals(cache.size(), 2);
        assertFalse(cache.clean("cache1"));        

        assertFalse(cache.isEmpty());
    }

    @DisplayName("If the size is n, then after n clean, the cache is empty and has a size 0")
    @Test
    void emptyAfterPop(){

        cache.add("cache1", "add_t1");
        cache.add("cache2", "add_t2");
        cache.add("cache3", "add_t3");

        assertEquals(cache.size(), 3);
        assertFalse(cache.isEmpty());

        cache.clean("cache1");
        cache.clean("cache2");
        cache.clean("cache3");

        assertTrue((cache.size() == 0)  && (cache.isEmpty()));
    }

    @DisplayName("After add to cache, we can get the added objects")
    @Test
    public void getTest() {
        cache.add("cache1", "add_t1");
        cache.add("cache2", "add_t2");

        assertEquals(cache.get("cache1"), "add_t1");      // requests = 1 | misses = 0 | hits = 1
        assertNotEquals( cache.get("cache2"), "add_t1");  // requests = 2 | misses = 0 | hits = 2
        
        assertEquals( cache.get("cache3"), null );        // requests = 3 | misses = 1 | hits = 2

        assertEquals( cache.getRequests(), 3); 
        assertEquals( cache.getHits(), 2);   
        assertEquals( cache.getMisses(), 1);   
    }


    @DisplayName("Cache behaviour should function properly")
    @Test
    public void behaviourTest() {
        cache.add("cache1", "add_t1");
        cache.add("cache2", "add_t2");

        assertEquals(cache.size(), 2);
        assertEquals(cache.get("cache1"), "add_t1");

        try {
            Thread.sleep(4000); // sleep 3 seconds

        } catch(InterruptedException e) {
            System.out.println("Got interrupted!");
        }

        assertEquals(cache.size(), 0);
        assertEquals(cache.get("cache1"), null);
    }

}
