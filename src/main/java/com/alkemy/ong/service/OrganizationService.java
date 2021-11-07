package com.alkemy.ong.service;

import java.util.List;

import com.alkemy.ong.dto.OrganizationDetailsResponse;
import com.alkemy.ong.dto.OrganizationRequest;
import com.alkemy.ong.model.Organization;

public interface OrganizationService {

    List<OrganizationDetailsResponse> getOrganizationDetails();
     Organization registerOrganization(OrganizationRequest orgRequest);

}
