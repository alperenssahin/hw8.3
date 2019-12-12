package penguinSupermarket;

public class StackConnector<T> implements DataStructureConnector<T> {
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
