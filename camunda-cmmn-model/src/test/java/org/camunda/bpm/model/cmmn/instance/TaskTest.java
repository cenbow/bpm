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
package org.camunda.bpm.model.cmmn.instance;

import java.util.Arrays;
import java.util.Collection;

import org.camunda.bpm.model.cmmn.impl.CmmnModelConstants;

/**
 * @author Roman Smirnov
 *
 */
public class TaskTest extends CmmnModelElementInstanceTest {

  public TypeAssumption getTypeAssumption() {
    return new TypeAssumption(PlanItemDefinition.class, false);
  }

  public Collection<ChildElementAssumption> getChildElementAssumptions() {
    return Arrays.asList(
          new ChildElementAssumption(CmmnModelConstants.CMMN10_NS, InputsCaseParameter.class),
          new ChildElementAssumption(CmmnModelConstants.CMMN10_NS, OutputsCaseParameter.class),
          new ChildElementAssumption(InputCaseParameter.class),
          new ChildElementAssumption(OutputCaseParameter.class)
        );
  }

  public Collection<AttributeAssumption> getAttributesAssumptions() {
    return Arrays.asList(
          new AttributeAssumption("isBlocking", false, false, Boolean.TRUE)
        );
  }

}
