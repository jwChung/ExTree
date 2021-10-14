package co.streamx.fluent.extree;

public class Person {
	private String name;
	private int age;
	private Integer height = 1;
	public Company company;

	public Person() {
	}

	public boolean isAdult() {
		return age >= 18;
	}

	public String getName() {
		return this.name;
	}

	public int getAge() {
		return this.age;
	}

	public Integer getHeight() {
		return this.height;
	}

	public Company getCompany() {
		return this.company;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String toString() {
		return "Person(name=" + this.getName() + ", age=" + this.getAge() + ", height=" + this.getHeight() + ", company=" + this.getCompany() + ")";
	}

	public boolean equals(final Object o) {
		if (o == this)
			return true;
		if (!(o instanceof Person))
			return false;
		final Person other = (Person)o;
		if (!other.canEqual((Object)this))
			return false;
		final Object this$name = this.getName();
		final Object other$name = other.getName();
		if (this$name == null ? other$name != null : !this$name.equals(other$name))
			return false;
		return true;
	}

	protected boolean canEqual(final Object other) {
		return other instanceof Person;
	}

	public int hashCode() {
		final int PRIME = 59;
		int result = 1;
		final Object $name = this.getName();
		result = result * PRIME + ($name == null ? 43 : $name.hashCode());
		return result;
	}
}
