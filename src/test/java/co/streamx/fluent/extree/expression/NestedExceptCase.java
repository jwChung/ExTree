package co.streamx.fluent.extree.expression;

import java.util.List;

public final class NestedExceptCase {
	public final NoneGetterPublicClass noneGetterPublicClass;

	public final OnlyGetterClass onlyGetterClass;

	public final List<NoneGetterPublicClass> noneGetterPublicClasses;

	public final List<OnlyGetterClass> onlyGetterClasses;

	public NestedExceptCase(NoneGetterPublicClass noneGetterPublicClass, OnlyGetterClass onlyGetterClass, List<NoneGetterPublicClass> noneGetterPublicClasses, List<OnlyGetterClass> onlyGetterClasses) {
		this.noneGetterPublicClass = noneGetterPublicClass;
		this.onlyGetterClass = onlyGetterClass;
		this.noneGetterPublicClasses = noneGetterPublicClasses;
		this.onlyGetterClasses = onlyGetterClasses;
	}

	public NoneGetterPublicClass getNoneGetterPublicClass() {
		return this.noneGetterPublicClass;
	}

	public OnlyGetterClass getOnlyGetterClass() {
		return this.onlyGetterClass;
	}

	public List<NoneGetterPublicClass> getNoneGetterPublicClasses() {
		return this.noneGetterPublicClasses;
	}

	public List<OnlyGetterClass> getOnlyGetterClasses() {
		return this.onlyGetterClasses;
	}

	public boolean equals(final Object o) {
		if (o == this)
			return true;
		if (!(o instanceof NestedExceptCase))
			return false;
		final NestedExceptCase other = (NestedExceptCase)o;
		final Object this$noneGetterPublicClass = this.getNoneGetterPublicClass();
		final Object other$noneGetterPublicClass = other.getNoneGetterPublicClass();
		if (this$noneGetterPublicClass == null ? other$noneGetterPublicClass != null : !this$noneGetterPublicClass.equals(other$noneGetterPublicClass))
			return false;
		final Object this$onlyGetterClass = this.getOnlyGetterClass();
		final Object other$onlyGetterClass = other.getOnlyGetterClass();
		if (this$onlyGetterClass == null ? other$onlyGetterClass != null : !this$onlyGetterClass.equals(other$onlyGetterClass))
			return false;
		final Object this$noneGetterPublicClasses = this.getNoneGetterPublicClasses();
		final Object other$noneGetterPublicClasses = other.getNoneGetterPublicClasses();
		if (this$noneGetterPublicClasses == null ? other$noneGetterPublicClasses != null : !this$noneGetterPublicClasses.equals(other$noneGetterPublicClasses))
			return false;
		final Object this$onlyGetterClasses = this.getOnlyGetterClasses();
		final Object other$onlyGetterClasses = other.getOnlyGetterClasses();
		if (this$onlyGetterClasses == null ? other$onlyGetterClasses != null : !this$onlyGetterClasses.equals(other$onlyGetterClasses))
			return false;
		return true;
	}

	public int hashCode() {
		final int PRIME = 59;
		int result = 1;
		final Object $noneGetterPublicClass = this.getNoneGetterPublicClass();
		result = result * PRIME + ($noneGetterPublicClass == null ? 43 : $noneGetterPublicClass.hashCode());
		final Object $onlyGetterClass = this.getOnlyGetterClass();
		result = result * PRIME + ($onlyGetterClass == null ? 43 : $onlyGetterClass.hashCode());
		final Object $noneGetterPublicClasses = this.getNoneGetterPublicClasses();
		result = result * PRIME + ($noneGetterPublicClasses == null ? 43 : $noneGetterPublicClasses.hashCode());
		final Object $onlyGetterClasses = this.getOnlyGetterClasses();
		result = result * PRIME + ($onlyGetterClasses == null ? 43 : $onlyGetterClasses.hashCode());
		return result;
	}

	public String toString() {
		return "NestedExceptCase(noneGetterPublicClass=" + this.getNoneGetterPublicClass() + ", onlyGetterClass=" + this.getOnlyGetterClass() + ", noneGetterPublicClasses=" + this.getNoneGetterPublicClasses() + ", onlyGetterClasses=" + this.getOnlyGetterClasses() + ")";
	}
}
