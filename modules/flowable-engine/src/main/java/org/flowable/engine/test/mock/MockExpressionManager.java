/* Licensed under the Apache License, Version 2.0 (the "License");
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

package org.flowable.engine.test.mock;

import org.flowable.engine.common.impl.javax.el.ArrayELResolver;
import org.flowable.engine.common.impl.javax.el.BeanELResolver;
import org.flowable.engine.common.impl.javax.el.CompositeELResolver;
import org.flowable.engine.common.impl.javax.el.ELResolver;
import org.flowable.engine.common.impl.javax.el.ListELResolver;
import org.flowable.engine.common.impl.javax.el.MapELResolver;
import org.flowable.engine.impl.el.DefaultExpressionManager;
import org.flowable.engine.impl.el.VariableScopeElResolver;
import org.flowable.variable.service.delegate.VariableScope;

public class MockExpressionManager extends DefaultExpressionManager {

    @Override
    protected ELResolver createElResolver(VariableScope variableScope) {
        CompositeELResolver compositeElResolver = new CompositeELResolver();
        compositeElResolver.add(new VariableScopeElResolver(variableScope));
        compositeElResolver.add(new MockElResolver());
        compositeElResolver.add(new ArrayELResolver());
        compositeElResolver.add(new ListELResolver());
        compositeElResolver.add(new MapELResolver());
        compositeElResolver.add(new BeanELResolver());
        return compositeElResolver;
    }

}
