package com.code.problem_146;

import org.junit.Assert;
import org.junit.Test;

public class LRUCacheTest {

    @Test
    public void test() {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        Assert.assertEquals(lRUCache.get(1), 1);
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        Assert.assertEquals(lRUCache.get(2), -1);
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        Assert.assertEquals(lRUCache.get(1), -1);
        Assert.assertEquals(lRUCache.get(3), 3);
        Assert.assertEquals(lRUCache.get(4), 4);
    }

}
