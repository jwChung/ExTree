package co.streamx.fluent.extree.expression

import co.streamx.fluent.extree.Ex
import co.streamx.fluent.extree.Person
import org.danekja.java.util.function.serializable.SerializableFunction
import org.junit.Assert
import org.junit.Test
import java.util.function.Function

class LambdaExpressionKotlinTest {

    @Test
    fun testParse0() {
        val pp = Function<Any, Float> { 23f }
        val parsed: LambdaExpression<Function<Any, Float>> = LambdaExpression.parse(pp)
        val le = parsed.compile()
        Assert.assertTrue(23f == le.apply(arrayOf(Any())) as Float)
        Assert.assertFalse(24f == le.apply(arrayOf(Any())) as Float)
    }

    @Test
    fun canParseAnExpressionWhereCharIsPromotedToIntAsAnOperand() {
        val e = SerializableFunction { s: String -> s[0].code + 1 }
        val parsed = LambdaExpression.parse<Function<String, Int>>(e)
        val le = parsed.compile()
        Assert.assertEquals(e.apply("A"), le.apply(arrayOf<Any>("A")))
    }

    @Test
    fun toFieldGetter() {
        // when
        val actual = Ex.to { c: Person -> c.company.name }
        Assert.assertEquals("company.name", actual)
    }
}
