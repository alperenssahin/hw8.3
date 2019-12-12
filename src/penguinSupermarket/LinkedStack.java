package penguinSupermarket;

public class LinkedStack<T>  implements Stack<T>,DataStructure {
    private List<T> head;
 
    public LinkedStack() {
		super();
	}

	public LinkedStack(T x) {
        if(x == null){
            this.head = null;
        }else{
            this.head = new List<>(x);
        }
    }

    @Override
    public void push(T item) {
        if(this.head == null){
            this.head = new List<>(item);
        }else{
            this.head = new List<>(item,this.head);
        }
    }

    @Override
    public T pop() {
        if(this.head == null || this.isEmpty()){
            return null;
        }else{
            List<T> tmp = this.head;
            this.head = this.head.getNext();
            return tmp.getInfo();
        }

    }

    @Override
    public int size() {
        if(this.head != null){
            int result = 1;
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

    public static void main(String[] args) {
        LinkedStack<String> test = new LinkedStack<>();
        System.out.println(test.size());
        test.push("ABC");
        System.out.println(test.size());
        test.push("DEF");
        System.out.println(test.size());
        
        System.out.println(test.pop());
        System.out.println(test.size());
        System.out.println(test.pop());
        System.out.println(test.size());
        System.out.println(test.pop());
        System.out.println(test.size());
        System.out.println(test.pop());

    }
}
