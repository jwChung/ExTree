package co.streamx.fluent.extree;

import java.util.List;

public final class Company {
	public final String name;

	public final List<String> productNames;

	public final List<List<String>> names;

	public final String[] nameArray;

	public final String[][] nameNestedArray;

	public final boolean check;

	public Company(String name, List<String> productNames, List<List<String>> names, String[] nameArray, String[][] nameNestedArray, boolean check) {
		this.name = name;
		this.productNames = productNames;
		this.names = names;
		this.nameArray = nameArray;
		this.nameNestedArray = nameNestedArray;
		this.check = check;
	}

	public String getName() {
		return this.name;
	}

	public List<String> getProductNames() {
		return this.productNames;
	}

	public List<List<String>> getNames() {
		return this.names;
	}

	public String[] getNameArray() {
		return this.nameArray;
	}

	public String[][] getNameNestedArray() {
		return this.nameNestedArray;
	}

	public boolean isCheck() {
		return this.check;
	}

	public boolean equals(final Object o) {
		if (o == this)
			return true;
		if (!(o instanceof Company))
			return false;
		final Company other = (Company)o;
		final Object this$name = this.getName();
		final Object other$name = other.getName();
		if (this$name == null ? other$name != null : !this$name.equals(other$name))
			return false;
		final Object this$productNames = this.getProductNames();
		final Object other$productNames = other.getProductNames();
		if (this$productNames == null ? other$productNames != null : !this$productNames.equals(other$productNames))
			return false;
		final Object this$names = this.getNames();
		final Object other$names = other.getNames();
		if (this$names == null ? other$names != null : !this$names.equals(other$names))
			return false;
		if (!java.util.Arrays.deepEquals(this.getNameArray(), other.getNameArray()))
			return false;
		if (!java.util.Arrays.deepEquals(this.getNameNestedArray(), other.getNameNestedArray()))
			return false;
		if (this.isCheck() != other.isCheck())
			return false;
		return true;
	}

	public int hashCode() {
		final int PRIME = 59;
		int result = 1;
		final Object $name = this.getName();
		result = result * PRIME + ($name == null ? 43 : $name.hashCode());
		final Object $productNames = this.getProductNames();
		result = result * PRIME + ($productNames == null ? 43 : $productNames.hashCode());
		final Object $names = this.getNames();
		result = result * PRIME + ($names == null ? 43 : $names.hashCode());
		result = result * PRIME + java.util.Arrays.deepHashCode(this.getNameArray());
		result = result * PRIME + java.util.Arrays.deepHashCode(this.getNameNestedArray());
		result = result * PRIME + (this.isCheck() ? 79 : 97);
		return result;
	}

	public String toString() {
		return "Company(name=" + this.getName() + ", productNames=" + this.getProductNames() + ", names=" + this.getNames() + ", nameArray=" + java.util.Arrays.deepToString(this.getNameArray()) + ", nameNestedArray=" + java.util.Arrays.deepToString(this.getNameNestedArray()) + ", check=" + this.isCheck() + ")";
	}
}
