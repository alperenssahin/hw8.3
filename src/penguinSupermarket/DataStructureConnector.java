package penguinSupermarket;

public class DataStructureConnector<T> extends List<T> implements DataStructureLink {

    public DataStructureConnector(T x) {
        super(x);
    }

    @Override
    public int size() {
        return this.length();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}