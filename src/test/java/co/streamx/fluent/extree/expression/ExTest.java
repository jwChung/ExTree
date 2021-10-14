/*
 * Fixture Monkey
 *
 * Copyright (c) 2021-present NAVER Corp.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package co.streamx.fluent.extree.expression;

import static org.assertj.core.api.BDDAssertions.then;
import static org.assertj.core.api.BDDAssertions.thenThrownBy;

import org.junit.Test;

import co.streamx.fluent.extree.Company;
import co.streamx.fluent.extree.Ex;
import co.streamx.fluent.extree.Person;

public class ExTest {
	@Test
	public void toField() {
		// when
		String actual = Ex.to((Person p) -> p.company);

		then(actual).isEqualTo("company");
	}

	@Test
	public void toGetter() {
		// when
		String actual = Ex.to(Person::getCompany);

		then(actual).isEqualTo("company");
	}

	@Test
	public void toFieldField() {
		// when
		String actual = Ex.to((Person c) -> c.company.name);

		then(actual).isEqualTo("company.name");
	}

	@Test
	public void toGetterField() {
		// when
		String actual = Ex.to((Person c) -> c.getCompany().name);

		then(actual).isEqualTo("company.name");
	}

	@Test
	public void toFieldGetter() {
		// when
		String actual = Ex.to((Person c) -> c.company.getName());

		then(actual).isEqualTo("company.name");
	}

	@Test
	public void toGetterGetter() {
		// when
		String actual = Ex.to((Person c) -> c.getCompany().getName());

		then(actual).isEqualTo("company.name");
	}

	@Test
	public void toListElement() {
		// when
		String actual = Ex.to((Company c) -> c.productNames.get(0));

		then(actual).isEqualTo("productNames[0]");
	}

	@Test
	public void toGetterListElementField() {
		// when
		String actual = Ex.to((Person p) -> p.getCompany().productNames.get(1));

		then(actual).isEqualTo("company.productNames[1]");
	}

	@Test
	public void toFieldListElementGetter() {
		// when
		String actual = Ex.to((Person p) -> p.company.getProductNames().get(0));

		then(actual).isEqualTo("company.productNames[0]");
	}

	@Test
	public void toFieldListElementField() {
		// when
		String actual = Ex.to((Person p) -> p.company.productNames.get(0));

		then(actual).isEqualTo("company.productNames[0]");
	}

	@Test
	public void toNestedListElementField() {
		// when
		String actual = Ex.to((Company c) -> c.names.get(0).get(0));

		then(actual).isEqualTo("names[0][0]");
	}

	@Test
	public void toNestedListElementFieldDiffIndex() {
		// when
		String actual = Ex.to((Company c) -> c.names.get(3).get(4));

		then(actual).isEqualTo("names[3][4]");
	}

	@Test
	public void toNestedListElementGetter() {
		// when
		String actual = Ex.to((Company c) -> c.getNames().get(0).get(0));

		then(actual).isEqualTo("names[0][0]");
	}

	@Test
	public void toArrayElementGetter() {
		// when
		String actual = Ex.to((Company c) -> c.getNameArray()[0]);

		then(actual).isEqualTo("nameArray[0]");
	}

	@Test
	public void toArrayElementField() {
		// when
		String actual = Ex.to((Company c) -> c.nameArray[0]);

		then(actual).isEqualTo("nameArray[0]");
	}

	@Test
	public void toNestedArrayElementField() {
		// when
		String actual = Ex.to((Company c) -> c.nameNestedArray[0][0]);

		then(actual).isEqualTo("nameNestedArray[0][0]");
	}

	@Test
	public void toNestedArrayElementGetter() {
		// when
		String actual = Ex.to((Company c) -> c.getNameNestedArray()[0][0]);

		then(actual).isEqualTo("nameNestedArray[0][0]");
	}

	@Test
	public void toBooleanGetter() {
		// when
		String actual = Ex.to(Company::isCheck);

		then(actual).isEqualTo("check");
	}

	@Test
	public void toFieldBooleanGetter() {
		// when
		String actual = Ex.to((Person p) -> p.getCompany().check);

		then(actual).isEqualTo("company.check");
	}

	@Test
	public void toGetterBooleanGetter() {
		// when
		String actual = Ex.to((Person p) -> p.getCompany().isCheck());

		then(actual).isEqualTo("company.check");
	}

	@Test
	public void toBooleanField() {
		// when
		String actual = Ex.to((Company c) -> c.check);

		then(actual).isEqualTo("check");
	}

	@Test
	public void toFieldBooleanField() {
		// when
		String actual = Ex.to((Person p) -> p.company.check);

		then(actual).isEqualTo("company.check");
	}

	@Test
	public void toGetterBooleanField() {
		// when
		String actual = Ex.to((Person p) -> p.getCompany().check);

		then(actual).isEqualTo("company.check");
	}

	@Test
	public void toNoneGetterPublicFieldClass() {
		// when
		String actual = Ex.to((NoneGetterPublicClass c) -> c.value);

		then(actual).isEqualTo("value");
	}

	@Test
	public void toOnlyGetterClass() {
		// when
		String actual = Ex.to(OnlyGetterClass::getValue);

		then(actual).isEqualTo("value");
	}

	@Test
	public void toFieldNoneGetterClass() {
		// when
		String actual = Ex.to((NestedExceptCase c) -> c.noneGetterPublicClass.value);

		then(actual).isEqualTo("noneGetterPublicClass.value");
	}

	@Test
	public void toGetterNoneGetterClass() {
		// when
		String actual = Ex.to((NestedExceptCase c) -> c.getNoneGetterPublicClass().value);

		then(actual).isEqualTo("noneGetterPublicClass.value");
	}

	@Test
	public void toGetterOnlyGetterClass() {
		// when
		String actual = Ex.to((NestedExceptCase c) -> c.getOnlyGetterClass().getValue());

		then(actual).isEqualTo("onlyGetterClass.value");
	}

	@Test
	public void toFieldOnlyGetterClass() {
		// when
		String actual = Ex.to((NestedExceptCase c) -> c.onlyGetterClass.getValue());

		then(actual).isEqualTo("onlyGetterClass.value");
	}

	@Test
	public void toFieldOnlyGetterClasses() {
		// when
		String actual = Ex.to((NestedExceptCase c) -> c.onlyGetterClasses.get(1).getValue());

		then(actual).isEqualTo("onlyGetterClasses[1].value");
	}

	@Test
	public void toGetterOnlyGetterClasses() {
		// when
		String actual = Ex.to((NestedExceptCase c) -> c.getOnlyGetterClasses().get(1).getValue());

		then(actual).isEqualTo("onlyGetterClasses[1].value");
	}

	@Test
	public void toFieldNoneGetterClasses() {
		// when
		String actual = Ex.to((NestedExceptCase c) -> c.noneGetterPublicClasses.get(1).value);

		then(actual).isEqualTo("noneGetterPublicClasses[1].value");
	}

	@Test
	public void toGetterNoneGetterClasses() {
		// when
		String actual = Ex.to((NestedExceptCase c) -> c.noneGetterPublicClasses.get(1).value);

		then(actual).isEqualTo("noneGetterPublicClasses[1].value");
	}

	@Test
	public void toGetterFakeList() {
		thenThrownBy(() -> Ex.to(FakeList::get))
			.isExactlyInstanceOf(IllegalArgumentException.class)
			.satisfies(it -> then(it.getMessage()).contains("Given method is not getter."));
	}

}
