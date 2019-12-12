package penguinSupermarket;

public class LinkedQueue<T> implements Queue<T>,DataStructure {
    private List<T> head;
    private List<T> tail = null;
    public LinkedQueue(T x) {
        if(x == null){
            this.head = null;
        }else{
            this.head = new List<>(x);
        }

    }
    @Override
    public int size() {
        if(this.head != null){
            int result = 0;
            for (List t = head; t != null; t = t.getNext())
                result++;
            return result;
        }else{
            return 0;
        }
    }
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }
    @Override
    public void enqueue(T t) {
        if(this.head == null){
            this.head = new List<>(t);
        }else{
            List<T> n = new List<>(t);
            if(this.tail == null){
                this.tail = n;
                this.head.setNext(this.tail);
            }else{
                this.tail.setNext(n);
                this.tail = this.tail.getNext();
            }
        }
    }

    @Override
    public T dequeue()
    {
        if(this.head == null || this.isEmpty()){
            return null;
        }else{
            List<T> tmp = this.head;
            this.head = this.head.getNext();
            return tmp.getInfo();
        }
    }

//    public static void main(String[] args) {
//        LinkedQueue<Integer> test = new LinkedQueue<>(10);
//        test.enqueue(15);
//        test.enqueue(20);
//        test.enqueue(25);
//        test.enqueue(30);
//        System.out.println(test.dequeue());
//        System.out.println(test.dequeue());
//        System.out.println(test.dequeue());
//        System.out.println(test.dequeue());
//        System.out.println(test.dequeue());
//        System.out.println(test.dequeue());
//        System.out.println(test.dequeue());
//    }
}
