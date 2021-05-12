package lambda;

/**
 * 함수형 인터페이스
 */
public interface Predicate<T> {
    boolean test(T t);
}
