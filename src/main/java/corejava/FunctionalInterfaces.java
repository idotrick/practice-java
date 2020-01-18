package corejava;

import javax.sound.midi.Soundbank;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Java 8 inbuilt functional interfaces
 *
 * 1. Predicate<T> : boolean test(T t)
 * 2. Supplier<T> : T get()
 * 3. Consumer<T> : void accept(T t)
 * 4. Function<T, R> : R apply(T t)
 */

public class FunctionalInterfaces {
    public static void main(String[] args) {
        Predicate<Integer> p = i -> i > 10;
        Supplier<Integer> s = () -> 10;
        Consumer<Integer> c = System.out::println;
        Function<Integer, Integer> f = i -> i*i;
        System.out.println("Predicate: "+p.test(10));
        System.out.println("Supplier: "+s.get());
        System.out.print("Consumer: ");c.accept(10);
        System.out.println("Function: "+f.apply(10));
    }
}
