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
package org.camunda.bpm.model.cmmn;

import org.camunda.bpm.model.cmmn.util.ParseCmmnModelRule;
import org.junit.Before;
import org.junit.Rule;

/**
 * @author Roman Smirnov
 *
 */
public abstract class CmmnModelTest {

  @Rule
  public final ParseCmmnModelRule parseCmmnModelRule = new ParseCmmnModelRule();

  protected CmmnModelInstance cmmnModelInstance;

  @Before
  public void setup() {
    cmmnModelInstance = parseCmmnModelRule.getCmmnModel();
  }

}
