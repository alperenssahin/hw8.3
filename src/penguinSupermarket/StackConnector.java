package penguinSupermarket;

public class StackConnector<T> extends DataStructureConnector<T> implements Stack<T> {
    private List<T> head;

    public StackConnector(T x) {
        super(x);
        if (x == null) {
            this.head = null;
        } else {
            this.head = new List<>(x);
        }

    }

    @Override
    public void push(T item) {
        if (this.head == null) {
            this.head = new List<>(item);
        } else {
            this.head = new List<>(item, this.head);
        }
    }

    @Override
    public T pop() {
        if (this.head == null || this.isEmpty()) {
            return null;
        } else {
            List<T> tmp = this.head;
            this.head = this.head.getNext();
            return tmp.getInfo();
        }

    }

    @Override
    public int size() {
        if (this.head != null) {
            return super.size();
        } else {
            return 0;
        }

    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

//    public static void main(String[] args) {
//        LinkedStack<Integer> test = new LinkedStack<>(10);
//        test.push(20);
//        test.push(30);
//        System.out.println(test.pop());
//        System.out.println(test.pop());
//        System.out.println(test.pop());
//        System.out.println(test.pop());
//
//    }
}
