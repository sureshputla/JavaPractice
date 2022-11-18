package in.sp_java_practice;

class SinglyLinkedListNode {
    private int value;
    private SinglyLinkedListNode next;

    public SinglyLinkedListNode(int value, SinglyLinkedListNode next) {
        this.value = value;
        this.next = next;
    }

    public SinglyLinkedListNode(int value) {
        this.value = value;
    }

    public SinglyLinkedListNode() {
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public SinglyLinkedListNode getNext() {
        return next;
    }

    public void setNext(SinglyLinkedListNode next) {
        this.next = next;
    }
}
