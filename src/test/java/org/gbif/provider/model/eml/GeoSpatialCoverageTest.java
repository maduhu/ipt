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
package org.gbif.provider.model.eml;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.gbif.provider.model.BBox;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import java.util.Map;
import java.util.Set;

import org.junit.Test;

/**
 * This class can be used for unit testing {@link GeoSpatialCoverage}.
 * 
 */
public class GeoSpatialCoverageTest {

  @Test
  public final void testCreate() {
    GeoSpatialCoverage.create(null, null, null, null);
    Set<String> keywords = Sets.newHashSet("k1", "k2");
    GeoSpatialCoverage.create(BBox.newWorldInstance(), "d", keywords, "ts");
  }

  @Test
  public final void testEqualsObject() {
    Set<String> keywords = Sets.newHashSet("k1", "k2");
    assertEquals(GeoSpatialCoverage.create(BBox.newWorldInstance(), "d",
        keywords, "ts"), GeoSpatialCoverage.create(BBox.newWorldInstance(),
        "d", keywords, "ts"));
  }

  @Test
  public final void testGetBoundingCoordinates() {
    Set<String> keywords = Sets.newHashSet("k1", "k2");
    assertEquals(BBox.newWorldInstance(), GeoSpatialCoverage.create(
        BBox.newWorldInstance(), "d", keywords, "ts").getBoundingCoordinates());
  }

  @Test
  public final void testGetDescription() {
    Set<String> keywords = Sets.newHashSet("k1", "k2");
    assertEquals("d", GeoSpatialCoverage.create(BBox.newWorldInstance(), "d",
        keywords, "ts").getDescription());
  }

  @Test
  public final void testGetKeywords() {
    Set<String> keywords = Sets.newHashSet("k1", "k2");
    assertEquals(keywords, GeoSpatialCoverage.create(BBox.newWorldInstance(),
        "d", keywords, "ts").getKeywords());
  }

  @Test
  public final void testGetTaxonomicSystem() {
    Set<String> keywords = Sets.newHashSet("k1", "k2");
    assertEquals("ts", GeoSpatialCoverage.create(BBox.newWorldInstance(), "d",
        keywords, "ts").getTaxonomicSystem());
  }

  @Test
  public final void testHashCode() {
    Set<String> keywords = Sets.newHashSet("k1", "k2");
    assertEquals(GeoSpatialCoverage.create(BBox.newWorldInstance(), "d",
        keywords, "ts").hashCode(), GeoSpatialCoverage.create(
        BBox.newWorldInstance(), "d", keywords, "ts").hashCode());
    GeoSpatialCoverage gsc = GeoSpatialCoverage.create(BBox.newWorldInstance(),
        "d", keywords, "ts");
    Map<GeoSpatialCoverage, String> map = Maps.newHashMap();
    map.put(gsc, "foo");
    assertTrue(map.containsKey(GeoSpatialCoverage.create(
        BBox.newWorldInstance(), "d", keywords, "ts")));
  }

  @Test
  public final void testToString() {
    Set<String> keywords = Sets.newHashSet("k1", "k2");
    GeoSpatialCoverage.create(BBox.newWorldInstance(), "d", keywords, "ts");
  }
}