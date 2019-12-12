package penguinSupermarket;

public class QueueConnector<T> implements DataStructureConnector<T> {
    @Override
    public boolean hasNextElement() {
        return false;
    }

    @Override
    public void addElement(T t) {

    }

    @Override
    public T removeNextElement() {
        return null;
    }
}
