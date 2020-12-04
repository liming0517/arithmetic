public class LinkedList<E> {
    private class Node{
        public E e;
        public Node next;

        public Node(E e,Node next){
            this.e =e;
            this.next =next;
        }

        public Node(E e){
            this(e,null);
        }
        public Node( ){
            this(null,null);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "e=" + e +
                    ", next=" + next +
                    '}';
        }
    }
    //构造函数
    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }
    //虚拟头节点
    private Node dummyHead;
    int size;

    /**
     * 在链表的index添加元素e
     * 在链表中不是一个常用的操作，主要理解
     * 时间复杂度：O(n)
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed.  Illegal index.");
        }

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
//            Node node = new Node(e);
//            node.next = prev.next;
//            prev.next = node;

        prev.next = new Node(e, prev.next);//当前新增节点的下一节点
        size++;

    }
    /**
     * 在链表头添加元素
     * 时间复杂度：O(1)
     */
    public void addFirst(E e) {
//        Node node = new Node(e);
//        node.next = head;
//        head = node;

//        head = new Node(e, head);
//        size++;

        add(0, e);
    }
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node cur = dummyHead.next;
        while (cur != null) {
            res.append(cur + "->");
            cur = cur.next;
        }
//        for (Node cur=dummyHead.next;cur!=null;cur=cur.next) {
//            res.append(cur + "->");
//        }
        res.append("NULL");
        return res.toString();
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList();
        linkedList.add(0,22);
        linkedList.add(1,23);
        System.out.println(linkedList);
    }

}
