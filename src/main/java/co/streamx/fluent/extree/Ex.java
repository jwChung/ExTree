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

package co.streamx.fluent.extree;

import java.util.Stack;
import java.util.function.Function;

import co.streamx.fluent.extree.expression.Expression;
import co.streamx.fluent.extree.expression.LambdaExpression;
import co.streamx.fluent.extree.expression.MemberExpression;
import co.streamx.fluent.extree.expression.SimpleExpressionVisitor;

public final class Ex {
	private Ex() {
	}

	public static <T> String to(Function<T, ?> function) {
		LambdaExpression<Function<T, ?>> parsed = LambdaExpression.parse(function);
		Expression body = parsed.getBody();
		ArbitraryExpressionVisitor visitor = new ArbitraryExpressionVisitor();

		body.accept(visitor);

		return visitor.toString();
	}

	private static class ArbitraryExpressionVisitor extends SimpleExpressionVisitor {
		Stack<String> names = new Stack<>();

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append(names.pop());
			while (!names.isEmpty()) {
				String name = names.pop();
				name = name.charAt(0) == '[' ? name : "." + name;
				sb.append(name);
			}

			return sb.toString();
		}

		@Override
		public Expression visit(MemberExpression expression) {
			String name = expression.getMember().getName();
			if (expression.getExpressionType() == 23) {
				name = name.replace("get", "");
				if (name.length() == 0) {
					name = "[" +  this.getContextArguments().get(0).toString() + "]";
				}
				else {
					name =  Character.toLowerCase(name.charAt(0)) + name.substring(1);
				}
			}

			names.push(name);

			return super.visit(expression);
		}
	}
}
