/*
 * $Id$
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.tiles.evaluator.impl;

import junit.framework.TestCase;

import org.apache.tiles.Attribute;
import org.apache.tiles.Expression;
import org.apache.tiles.request.Request;

/**
 * Tests {@link DirectAttributeEvaluator}.
 *
 * @version $Rev$ $Date$
 */
public class DirectAttributeEvaluatorTest extends TestCase {

    /**
     * The evaluator to test.
     */
    private DirectAttributeEvaluator evaluator;

    /** {@inheritDoc} */
    @Override
    public void setUp() {
        evaluator = new DirectAttributeEvaluator();
    }

    /**
     * Tests
     * {@link DirectAttributeEvaluator#evaluate(Attribute, Request)}.
     */
    public void testEvaluate() {
        String expression = "This is an expression";
        Attribute attribute = new Attribute(null, Expression.createExpression(
                expression, null), null, (String) null);
        Object result = evaluator.evaluate(attribute, null);
        assertEquals("The expression has not been evaluated correctly", result,
                expression);
        expression = "${attributeName}";
        attribute.setExpressionObject(new Expression(expression));
        result = evaluator.evaluate(attribute, null);
        assertEquals("The expression has not been evaluated correctly", result,
                expression);
    }

    /**
     * Tests
     * {@link DirectAttributeEvaluator#evaluate(String, Request)}.
     */
    public void testEvaluateString() {
        String expression = "This is an expression";
        Object result = evaluator.evaluate(expression, null);
        assertEquals("The expression has not been evaluated correctly", result,
                expression);
        expression = "${attributeName}";
        result = evaluator.evaluate(expression, null);
        assertEquals("The expression has not been evaluated correctly", result,
                expression);
    }
}
