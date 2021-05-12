package lambda;

/**
 * 함수형 인터페이스
 */

@FunctionalInterface //함수형 인터페이스 어노테이션
public interface Predicate<T> {
    boolean test(T t);
}
