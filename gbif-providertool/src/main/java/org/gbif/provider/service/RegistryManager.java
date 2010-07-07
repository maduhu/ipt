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
package org.gbif.provider.service;

import org.gbif.provider.model.ResourceMetadata;
import org.gbif.registry.api.client.GbrdsExtension;
import org.gbif.registry.api.client.GbrdsOrganisation;
import org.gbif.registry.api.client.GbrdsResource;
import org.gbif.registry.api.client.GbrdsService;
import org.gbif.registry.api.client.GbrdsThesaurus;
import org.gbif.registry.api.client.Gbrds.Credentials;
import org.gbif.registry.api.client.GbrdsRegistry.CreateOrgResponse;
import org.gbif.registry.api.client.GbrdsRegistry.CreateResourceResponse;
import org.gbif.registry.api.client.GbrdsRegistry.CreateServiceResponse;
import org.gbif.registry.api.client.GbrdsRegistry.DeleteResourceResponse;
import org.gbif.registry.api.client.GbrdsRegistry.DeleteServiceResponse;
import org.gbif.registry.api.client.GbrdsRegistry.ListServicesForResourceResponse;
import org.gbif.registry.api.client.GbrdsRegistry.ReadOrgResponse;
import org.gbif.registry.api.client.GbrdsRegistry.ReadResourceResponse;
import org.gbif.registry.api.client.GbrdsRegistry.UpdateOrgResponse;
import org.gbif.registry.api.client.GbrdsRegistry.UpdateResourceResponse;
import org.gbif.registry.api.client.GbrdsRegistry.UpdateServiceResponse;
import org.gbif.registry.api.client.GbrdsRegistry.ValidateOrgCredentialsResponse;

import java.util.List;

/**
 * This class provides a service interface for working with the GBRDS.
 * 
 */
public interface RegistryManager {

  /**
   * This class represents registry specific exceptions.
   * 
   */
  @SuppressWarnings("serial")
  public class RegistryException extends Exception {
    public RegistryException() {
      super();
    }

    public RegistryException(String string) {
      super(string);
    }

    public RegistryException(String string, Throwable e) {
      super(string, e);
    }
  }

  /**
   * Helper that creates a {@link GbrdsOrganisation.Builder} from
   * {@link ResourceMetadata}. Throws {@link NullPointerException} if the
   * <code>resourceMetadata</code> is null.
   * 
   * @param resourceMetadata
   * @return GbrdsOrganisation.Builder
   */
  GbrdsOrganisation.Builder buildGbrdsOrganisation(
      ResourceMetadata resourceMetadata);

  /**
   * Helper that creates a {@link GbrdsResource.Builder} from
   * {@link ResourceMetadata}. Throws {@link NullPointerException} if the
   * <code>resourceMetadata</code> is null.
   * 
   * @param resourceMetadata
   * @return GbrdsResource.Builder
   */
  GbrdsResource.Builder buildGbrdsResource(ResourceMetadata resourceMetadata);

  /**
   * Creates a new {@link GbrdsOrganisation} and returns the
   * {@link CreateOrgResponse} from the GBRDS. Throws
   * {@link NullPointerException} if the <code>organisation</code> is null.
   * Throws {@link RegistryException} if there are errors creating the
   * organisation.
   * 
   * @param organisation the organisation to create
   * @return CreateOrgResponse the GBRDS response
   * @throws NullPointerException, RegistryException
   */
  CreateOrgResponse createGbrdsOrganisation(GbrdsOrganisation organisation)
      throws RegistryException;

  /**
   * Creates a new {@link GbrdsResource} and returns the
   * {@link CreateResourceResponse} from the GBRDS. Throws
   * {@link NullPointerException} if the <code>resource</code> is null. Throws
   * {@link RegistryException} if there are errors creating the resource.
   * 
   * @param resource the resource to create
   * @return CreateResourceResponse
   * @throws NullPointerException, RegistryException
   */
  CreateResourceResponse createGbrdsResource(GbrdsResource resource)
      throws RegistryException;

  /**
   * Creates a new {@link GbrdsService} and returns the
   * {@link CreateServiceResponse} from the GBRDS. Throws
   * {@link NullPointerException} if the <code>service</code> is null. Throws
   * {@link RegistryException} if there are errors creating the service.
   * 
   * @param service the service to create
   * @return CreateServiceResponse
   * @throws NullPointerException, RegistryException
   */
  CreateServiceResponse createGbrdsService(GbrdsService service)
      throws RegistryException;

  /**
   * Deletes an existing {@link GbrdsResource} and returns the
   * {@link DeleteResourceResponse} from the GBRDS. Throws
   * {@link NullPointerException} if the <code>resource</code> is null. Throws
   * {@link RegistryException} if there are errors deleting the resource.
   * 
   * @param resource
   * @return DeleteResourceResponse
   * @throws NullPointerException, RegistryException
   */
  DeleteResourceResponse deleteGbrdsResource(GbrdsResource resource)
      throws RegistryException;

  /**
   * Deletes an existing {@link GbrdsService} and returns the
   * {@link DeleteServiceResponse} from the GBRDS. Throws
   * {@link NullPointerException} if the <code>service</code> is null. Throws
   * {@link RegistryException} if there are errors deleting the service.
   * 
   * @param service
   * @return DeleteServiceResponse
   * @throws NullPointerException, RegistryException
   */
  DeleteServiceResponse deleteGbrdsService(GbrdsService service)
      throws RegistryException;

  /**
   * Returns a list of {@link GbrdsExtension}s from the GBRDS.
   * 
   * @return List<GbrdsExtension>
   */
  List<GbrdsExtension> listAllExtensions();

  /**
   * Returns a list of {@link GbrdsThesaurus}s from the GBRDS.
   * 
   * @return List<GbrdsThesaurus>
   */
  List<GbrdsThesaurus> listAllThesauri();

  /**
   * Returns a {@link ListServicesForResourceResponse} from the GBRDS that
   * contains a list of {@link GbrdsService}s for a given {@link GbrdsResource}
   * key. Throws {@link NullPointerException} if the <code>resourceKey</code> is
   * null. Throws {@link RegistryException} if there are errors listing the
   * services.
   * 
   * @param resourceKey
   * @return ListServicesForResourceResponse
   * @throws NullPointerException, RegistryException
   */
  ListServicesForResourceResponse listGbrdsServices(String resourceKey)
      throws RegistryException;

  /**
   * Reads a {@link GbrdsOrganisation} from the GBRDS and returns the
   * {@link ReadOrgResponse}. Throws {@link NullPointerException} if the
   * <code>organisationKey</code> is null. Throws {@link RegistryException} if
   * there are errors reading the organisation.
   * 
   * @param organisationKey
   * @return ReadOrgResponse
   * @throws NullPointerException, RegistryException
   */
  ReadOrgResponse readGbrdsOrganisation(String organisationKey)
      throws RegistryException;

  /**
   * Reads a {@link GbrdsResource} from the GBRDS and returns the
   * {@link ReadResourceResponse}. Throws {@link NullPointerException} if the
   * <code>resourceKey</code> is null. Throws {@link RegistryException} if there
   * are errors reading the resource.
   * 
   * @param resourcekey
   * @return ReadResourceResponse
   * @throws NullPointerException, RegistryException
   */
  ReadResourceResponse readGbrdsResource(String resourceKey)
      throws RegistryException;

  /**
   * Updates a {@link GbrdsOrganisation} in the GBRDS and returns the
   * {@link UpdateOrgResponse}. Throws {@link NullPointerException} if the
   * <code>organisation</code> is null. Throws {@link RegistryException} if
   * there are errors updating the organisation.
   * 
   * @param organisation
   * @return UpdateOrgResponse
   * @throws NullPointerException, RegistryException
   */
  UpdateOrgResponse updateGbrdsOrganisation(GbrdsOrganisation organisation)
      throws RegistryException;

  /**
   * Updates a {@link GbrdsResource} in the GBRDS and returns the
   * {@link UpdateResourceResponse}. Throws {@link NullPointerException} if the
   * <code>resource</code> is null. Throws {@link RegistryException} if there
   * are errors updating the resource.
   * 
   * @param resource
   * @return UpdateResourceResponse
   * @throws NullPointerException, RegistryException
   */
  UpdateResourceResponse updateGbrdsResource(GbrdsResource resource)
      throws RegistryException;

  /**
   * Updates a {@link GbrdsService} in the GBRDS and returns the
   * {@link UpdateServiceResponse}. Throws {@link NullPointerException} if the
   * <code>service</code> is null. Throws {@link RegistryException} if there are
   * errors updating the service.
   * 
   * @param service
   * @return UpdateServiceResponse
   * @throws NullPointerException, RegistryException
   */
  UpdateServiceResponse updateGbrdsService(GbrdsService service)
      throws RegistryException;

  /**
   * Validates {@link Credentials} for a {@link GbrdsOrganisation} in the GBRDS
   * and returns the {@link ValidateOrgCredentialsResponse}. Throws
   * {@link NullPointerException} if the <code>organisationKey</code> or
   * <code>credentials</code> are null.
   * 
   * @param organisationKey
   * @param credentials
   * @return ValidateOrgCredentialsResponse
   */
  ValidateOrgCredentialsResponse validateGbifOrganisationCredentials(
      String organisationKey, Credentials credentials);
}