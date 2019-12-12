package penguinSupermarket;

public class List<T> {
    private final T info;
    private List next;

    public List(T x) {
        info = x;
        next = null;
    }

    public List(T x, List l) {
        info = x;
        next = l;
    }

    public List getNext() {
        return next;
    }

    public void setNext(List next) {
        this.next = next;
    }

    public void insert(T x) {
        next = new List<T>(x, next);
    }

    public int length() {
        int result = 1;
        for (List t = next; t != null; t = t.next)
            result++;
        return result;
    }
    
    public void delete(){
    	 for (List t = next; t != null; t = t.next)
             t = null;    	
    }

    public T getInfo() {
        return info;
    }

    @Override
    public String toString() {
        String result = "[" + info;
        for (List t = next; t != null; t = t.next)
            result = result + ", " + t.info;
        return result + "]";
    }
}
