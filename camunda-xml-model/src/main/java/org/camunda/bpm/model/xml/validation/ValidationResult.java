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
package org.camunda.bpm.model.xml.validation;

import org.camunda.bpm.model.xml.instance.ModelElementInstance;

/**
 * An individual validation result.
 *
 * @author Daniel Meyer
 * @since 7.6
 */
public interface ValidationResult {

  /**
   * @return The type of the result.
   */
  ValidationResultType getType();

  /**
   * @return the element
   */
  ModelElementInstance getElement();

  /**
   * @return A human consumable detail message about the validation
   */
  String getMessage();

  /**
   * @return A reference code for this validation result
   */
  int getCode();

}
