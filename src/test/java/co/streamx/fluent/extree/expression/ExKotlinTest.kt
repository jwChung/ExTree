package co.streamx.fluent.extree.expression

import co.streamx.fluent.extree.Company
import co.streamx.fluent.extree.Ex
import co.streamx.fluent.extree.Person
import org.assertj.core.api.BDDAssertions.then
import org.junit.Test

class ExKotlinTest {
    @Test
    fun toField() {
        // when
        val actual = Ex.to { p: Person -> p.company }
        then(actual).isEqualTo("company")
    }

    @Test
    fun toGetter() {
        // when
        val actual = Ex.to { obj: Person -> obj.getCompany() }
        then(actual).isEqualTo("company")
    }

    @Test
    fun toFieldField() {
        // when
        val actual = Ex.to { c: Person -> c.company.name }
        then(actual).isEqualTo("company.name")
    }

    @Test
    fun toGetterField() {
        // when
        val actual = Ex.to { c: Person -> c.getCompany().name }
        then(actual).isEqualTo("company.name")
    }

    @Test
    fun toFieldGetter() {
        // when
        val actual = Ex.to { c: Person -> c.company.getName() }
        then(actual).isEqualTo("company.name")
    }

    @Test
    fun toGetterGetter() {
        // when
        val actual = Ex.to { c: Person -> c.getCompany().getName() }
        then(actual).isEqualTo("company.name")
    }

    @Test
    fun toListElement() {
        // when
        val actual = Ex.to { c: Company -> c.productNames[0] }
        then(actual).isEqualTo("productNames[0]")
    }

    @Test
    fun toGetterListElementField() {
        // when
        val actual = Ex.to { p: Person -> p.getCompany().productNames[0] }
        then(actual).isEqualTo("company.productNames[0]")
    }

    @Test
    fun toFieldListElementGetter() {
        // when
        val actual = Ex.to { p: Person -> p.company.getProductNames()[0] }
        then(actual).isEqualTo("company.productNames[0]")
    }

    @Test
    fun toFieldListElementField() {
        // when
        val actual = Ex.to { p: Person -> p.company.productNames[0] }
        then(actual).isEqualTo("company.productNames[0]")
    }

    @Test
    fun toNestedListElementField() {
        // when
        val actual = Ex.to { c: Company -> c.names[0][0] }
        then(actual).isEqualTo("names[0][0]")
    }

    @Test
    fun toNestedListElementFieldDiffIndex() {
        // when
        val actual = Ex.to { c: Company -> c.names[3][4] }
        then(actual).isEqualTo("names[3][4]")
    }

    @Test
    fun toNestedListElementGetter() {
        // when
        val actual = Ex.to { c: Company -> c.getNames()[0][0] }
        then(actual).isEqualTo("names[0][0]")
    }

    @Test
    fun toArrayElementGetter() {
        // when
        val actual = Ex.to { c: Company -> c.getNameArray()[0] }
        then(actual).isEqualTo("nameArray[0]")
    }

    @Test
    fun toArrayElementField() {
        // when
        val actual = Ex.to { c: Company -> c.nameArray[0] }
        then(actual).isEqualTo("nameArray[0]")
    }

    @Test
    fun toNestedArrayElementField() {
        // when
        val actual = Ex.to { c: Company -> c.nameNestedArray[0][0] }
        then(actual).isEqualTo("nameNestedArray[0][0]")
    }

    @Test
    fun toNestedArrayElementGetter() {
        // when
        val actual = Ex.to { c: Company -> c.getNameNestedArray()[0][0] }
        then(actual).isEqualTo("nameNestedArray[0][0]")
    }

    @Test
    fun toBooleanGetter() {
        // when
        val actual = Ex.to { obj: Company -> obj.isCheck }
        then(actual).isEqualTo("check")
    }

    @Test
    fun toFieldBooleanGetter() {
        // when
        val actual = Ex.to { p: Person -> p.getCompany().check }
        then(actual).isEqualTo("company.check")
    }

    @Test
    fun toGetterBooleanGetter() {
        // when
        val actual = Ex.to { p: Person -> p.getCompany().isCheck }
        then(actual).isEqualTo("company.check")
    }

    @Test
    fun toBooleanField() {
        // when
        val actual = Ex.to { c: Company -> c.check }
        then(actual).isEqualTo("check")
    }

    @Test
    fun toFieldBooleanField() {
        // when
        val actual = Ex.to { p: Person -> p.company.check }
        then(actual).isEqualTo("company.check")
    }

    @Test
    fun toGetterBooleanField() {
        // when
        val actual = Ex.to { p: Person -> p.getCompany().check }
        then(actual).isEqualTo("company.check")
    }

    @Test
    fun toNoneGetterPublicFieldClass() {
        // when
        val actual = Ex.to { c: NoneGetterPublicClass -> c.value }
        then(actual).isEqualTo("value")
    }

    @Test
    fun toOnlyGetterClass() {
        // when
        val actual = Ex.to { obj: OnlyGetterClass -> obj.value }
        then(actual).isEqualTo("value")
    }

    @Test
    fun toFieldNoneGetterClass() {
        // when
        val actual = Ex.to { c: NestedExceptCase -> c.noneGetterPublicClass.value }
        then(actual).isEqualTo("noneGetterPublicClass.value")
    }

    @Test
    fun toGetterNoneGetterClass() {
        // when
        val actual = Ex.to { c: NestedExceptCase -> c.getNoneGetterPublicClass().value }
        then(actual).isEqualTo("noneGetterPublicClass.value")
    }

    @Test
    fun toGetterOnlyGetterClass() {
        // when
        val actual = Ex.to { c: NestedExceptCase -> c.getOnlyGetterClass().value }
        then(actual).isEqualTo("onlyGetterClass.value")
    }

    @Test
    fun toFieldOnlyGetterClass() {
        // when
        val actual = Ex.to { c: NestedExceptCase -> c.onlyGetterClass.value }
        then(actual).isEqualTo("onlyGetterClass.value")
    }

    @Test
    fun toFieldOnlyGetterClasses() {
        // when
        val actual = Ex.to { c: NestedExceptCase -> c.onlyGetterClasses[1].value }
        then(actual).isEqualTo("onlyGetterClasses[1].value")
    }

    @Test
    fun toGetterOnlyGetterClasses() {
        // when
        val actual = Ex.to { c: NestedExceptCase -> c.getOnlyGetterClasses()[1].value }
        then(actual).isEqualTo("onlyGetterClasses[1].value")
    }

    @Test
    fun toFieldNoneGetterClasses() {
        // when
        val actual = Ex.to { c: NestedExceptCase -> c.noneGetterPublicClasses[1].value }
        then(actual).isEqualTo("noneGetterPublicClasses[1].value")
    }

    @Test
    fun toGetterNoneGetterClasses() {
        // when
        val actual = Ex.to { c: NestedExceptCase -> c.noneGetterPublicClasses[1].value }
        then(actual).isEqualTo("noneGetterPublicClasses[1].value")
    }

    @Test
    fun toGetterFakeList() {
        // BDDAssertions.thenThrownBy { Ex.to(Function<FakeList?, Any?> { obj: FakeList -> obj.get() }) }
        //     .isExactlyInstanceOf(IllegalArgumentException::class.java)
        //     .satisfies { it -> then(it.message).contains("Given method is not getter.") }
    }
}
