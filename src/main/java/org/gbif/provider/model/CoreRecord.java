/*
 * Copyright 2009 GBIF.
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
package org.gbif.provider.model;

import java.util.Date;

/**
 * TODO: Documentation.
 * 
 */
public interface CoreRecord extends ResourceRelatedObject, Record {

  String getGuid();

  String getLink();

  Date getModified();

  String getPropertyValue(ExtensionProperty property);

  String getSourceId();

  boolean isDeleted();

  void setDeleted(boolean isDeleted);

  void setGuid(String guid);

  void setLink(String link);

  void setModified(Date modified);

  void setSourceId(String sourceId);
}