package penguinSupermarket;

public interface Queue <T>{
    public void enqueue(T t);
    public T dequeue();
}
