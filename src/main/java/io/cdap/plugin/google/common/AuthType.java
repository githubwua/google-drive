/*
 * Copyright © 2019 Cask Data, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package io.cdap.plugin.google.common;

import io.cdap.plugin.google.common.exceptions.InvalidPropertyType;
import io.cdap.plugin.google.common.exceptions.InvalidPropertyTypeException;

import java.util.Arrays;

/**
 * Enum for data range presenting.
 */
public enum AuthType {
  OAUTH2("oAuth2"),
  SERVICE_ACCOUNT("serviceAccount");

  private final String value;

  AuthType(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  public static AuthType fromValue(String value) {
    return Arrays.stream(AuthType.values()).filter(authtype -> authtype.getValue().equals(value))
      .findAny().orElseThrow(() -> new InvalidPropertyTypeException(InvalidPropertyType.AUTH_TYPE, value));
  }
}
