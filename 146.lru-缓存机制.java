import java.util.HashMap;

/*
 * @Author: guo yawen
 * @Date: 2021-04-14 13:05:48
 * @LastEditTime: 2021-04-14 16:27:22
 * @LastEditors: guo yawen
 * @Description: LinkedHashMap工具类 
 * @FilePath: \LeetCode\146.lru-缓存机制.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=146 lang=java
 *
 * [146] LRU 缓存机制
 */

// @lc code=start
class LRUCache {
    class DLinkNode{
        int key;
        int val;
        DLinkNode prev;
        DLinkNode next;
        public DLinkNode(){}
        public DLinkNode(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    HashMap<Integer,DLinkNode> cache;
    DLinkNode vHead, vTail;
    private int size;
    private int capacity;
    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        vHead = new DLinkNode(-1,-1);
        vTail = new DLinkNode(-1,-1);
        vHead.next = vTail;
        vTail.prev = vHead;
        cache = new HashMap<>();
    }
    
    public int get(int key) {
        DLinkNode curr = cache.get(key);
        if(curr == null){
            return -1;
        }
        removeNode(curr);
        addToHead(curr);
        return curr.val;
       }
    
    public void put(int key, int value) {
        DLinkNode curr = cache.get(key);
        if(curr != null){
            curr.val = value;
            removeNode(curr);
            addToHead(curr);
        }else{
            if(size + 1 > capacity){
                cache.remove(removeTail().key);
            }else{
                size++;
            }
            DLinkNode insert = new DLinkNode(key,value);
            addToHead(insert);
            cache.put(key, insert);
        }
    }
    public void removeNode(DLinkNode deleted){
        deleted.prev.next = deleted.next;
        deleted.next.prev = deleted.prev;
    }
    public void addToHead(DLinkNode head){
        head.next = vHead.next;
        head.prev = vHead;
        vHead.next.prev = head;
        vHead.next = head;
    }
    public DLinkNode removeTail(){
        DLinkNode ret = vTail.prev;
        removeNode(ret);

        return ret;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

