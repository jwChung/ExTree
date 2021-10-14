package co.streamx.fluent.extree.expression;

public final class FakeList {
	public FakeList() {
	}

	public String get() {
		return "value";
	}

	public boolean equals(final Object o) {
		if (o == this)
			return true;
		if (!(o instanceof FakeList))
			return false;
		final FakeList other = (FakeList)o;
		return true;
	}

	public int hashCode() {
		int result = 1;
		return result;
	}

	public String toString() {
		return "FakeList()";
	}
}
