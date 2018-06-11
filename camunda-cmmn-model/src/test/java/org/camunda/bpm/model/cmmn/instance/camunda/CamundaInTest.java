/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.camunda.bpm.model.cmmn.instance.camunda;

import static org.camunda.bpm.model.cmmn.impl.CmmnModelConstants.CAMUNDA_NS;

import java.util.Arrays;
import java.util.Collection;

import org.camunda.bpm.model.cmmn.instance.CmmnModelElementInstanceTest;

/**
 * @author Sebastian Menski
 * @author Roman Smirnov
 */
public class CamundaInTest extends CmmnModelElementInstanceTest {

  public TypeAssumption getTypeAssumption() {
    return new TypeAssumption(CAMUNDA_NS, false);
  }

  public Collection<ChildElementAssumption> getChildElementAssumptions() {
    return null;
  }

  public Collection<AttributeAssumption> getAttributesAssumptions() {
    return Arrays.asList(
      new AttributeAssumption(CAMUNDA_NS, "source"),
      new AttributeAssumption(CAMUNDA_NS, "sourceExpression"),
      new AttributeAssumption(CAMUNDA_NS, "variables"),
      new AttributeAssumption(CAMUNDA_NS, "target"),
      new AttributeAssumption(CAMUNDA_NS, "businessKey"),
      new AttributeAssumption(CAMUNDA_NS, "local")
    );
  }
}