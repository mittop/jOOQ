/**
 * Copyright (c) 2009-2015, Data Geekery GmbH (http://www.datageekery.com)
 * All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Other licenses:
 * -----------------------------------------------------------------------------
 * Commercial licenses for this work are available. These replace the above
 * ASL 2.0 and offer limited warranties, support, maintenance, and commercial
 * database integrations.
 *
 * For more information, please visit: http://www.jooq.org/licenses
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */
package org.jooq.test;

import static org.jooq.impl.DSL.count;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Common tests related to jOOQ's exception handling
 *
 * @author Lukas Eder
 */
public class ExceptionsTest extends AbstractTest {

    @Test
    public void testMissingWindowSpecification() {

        // [#3162] If a window specification is missing from the query's WINDOW clause,
        // jOOQ should just render the window name regardless of the SQL dialect
        assertTrue(
            create.select(count().over("window"))
                  .getSQL()
                  .contains("over `window`")
        );
    }
}