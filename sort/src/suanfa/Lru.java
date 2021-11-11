package suanfa;

import java.util.HashMap;

public class Lru {


    class LruNode {

        int key;
        int value;
        LruNode next;
        LruNode prev;

        public LruNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    class LruCache {

        int capacity;
        HashMap<Integer, LruNode> map = new HashMap<>(8);

        LruNode head = new LruNode(0, 0);
        LruNode tail = new LruNode(0, 0);

        public LruCache(int capacity) {
            this.capacity = capacity;
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {

            if (map.containsKey(key)) {
                moveToTop(map.get(key));
                return map.get(key).value;
            } else {
                return -1;
            }

        }

        public void put(int key, int value) {

            if (!map.containsKey(key)) {
                if (map.size() == capacity) {
                    deleteLast();
                } else {
                    LruNode node = new LruNode(key, value);
                    LruNode temp = head.next;
                    head.next = node;
                    node.prev = head;
                    node.next = temp;
                    temp.prev = node;
                    map.put(key, node);
                }
            } else {
                LruNode node = map.get(key);
                moveToTop(node);
            }
        }

        private void moveToTop(LruNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;

            LruNode temp = head.next;
            head.next = node;
            node.prev = head;
            node.next = temp;
            temp.prev = node;
        }

        private void deleteLast() {
            LruNode node = tail.prev;
            node.prev.next = tail;
            tail.prev = node.prev;
            map.remove(node.key);
        }

    }


}
