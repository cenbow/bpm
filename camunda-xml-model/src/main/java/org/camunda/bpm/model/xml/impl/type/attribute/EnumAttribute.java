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
package org.camunda.bpm.model.xml.impl.type.attribute;

import org.camunda.bpm.model.xml.type.ModelElementType;

/**
 * <p>An attribute exposing an Enum value</p>
 *
 * @author Daniel Meyer
 *
 */
public class EnumAttribute<T extends Enum<T>> extends AttributeImpl<T> {

  private final Class<T> type;

  public EnumAttribute(ModelElementType owningElementType, Class<T> type) {
    super(owningElementType);
    this.type = type;
  }

  protected T convertXmlValueToModelValue(String rawValue) {
    if (rawValue != null) {
      return Enum.valueOf(type, rawValue);
    }
    else {
      return null;
    }
  }

  protected String convertModelValueToXmlValue(T modelValue) {
    return modelValue.name();
  }

}
