package co.streamx.fluent.extree.expression;

import java.io.Serializable;
import java.util.Objects;
import java.util.function.Function;

public interface SerializableFunction2<T, R> extends Function<T, R>, Serializable {
	default <V> org.danekja.java.util.function.serializable.SerializableFunction<V, R> compose(org.danekja.java.util.function.serializable.SerializableFunction<? super V, ? extends T> before) {
		Objects.requireNonNull(before);
		return (v) -> {
			return this.apply(before.apply(v));
		};
	}

	default <V> org.danekja.java.util.function.serializable.SerializableFunction<T, V> andThen(org.danekja.java.util.function.serializable.SerializableFunction<? super R, ? extends V> after) {
		Objects.requireNonNull(after);
		return (t) -> {
			return after.apply(this.apply(t));
		};
	}

	static <T> org.danekja.java.util.function.serializable.SerializableFunction<T, T> identity() {
		return (t) -> {
			return t;
		};
	}
}
