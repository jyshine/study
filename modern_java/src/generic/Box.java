package generic;

/**
 * generic
 *
 * @param <E>
 */
public class Box<E> {
    private E object;

    public E getObject() {
        return object;
    }

    public void setObject(E object) {
        this.object = object;
    }
}
