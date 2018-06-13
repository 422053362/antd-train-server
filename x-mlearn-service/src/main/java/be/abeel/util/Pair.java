/**
 * %HEADER%
 */
package be.abeel.util;

/**
 * Represents a pair or couple of objects.
 * 
 * @author Thomas Abeel
 * 
 * @param <S>
 *            type of the first element
 * @param <T>
 *            type of the second element
 */
public class Pair<S, T> {

    private S x;

    private T y;

    private int hashCode;

    public Pair(S x, T y) {
        this.x = x;
        this.y = y;

        this.hashCode = (1 << x.hashCode()) + y.hashCode();
    }

    public S x() {
        return x;

    }

    public T y() {
        return y;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object o) {
        Pair p = (Pair) o;
        return p.x.equals(this.x) && p.y.equals(this.y);
    }

    @Override
    public int hashCode() {
        return hashCode;
    }

    @Override
    public String toString() {
        return "[" + x.toString() + ";" + y.toString() + "]";
    }
}