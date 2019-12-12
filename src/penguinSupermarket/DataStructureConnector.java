package penguinSupermarket;

public interface DataStructureConnector<T> {
   public boolean hasNextElement();
   public void addElement(T t);
   public T removeNextElement();
}
