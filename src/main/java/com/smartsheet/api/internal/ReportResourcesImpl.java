package com.smartsheet.api.internal;

/*
 * #[license]
 * Smartsheet SDK for Java
 * %%
 * Copyright (C) 2014 Smartsheet
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
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
 * %[license]
 */


import com.smartsheet.api.ReportResources;
import com.smartsheet.api.Smartsheet;
import com.smartsheet.api.SmartsheetException;
import com.smartsheet.api.internal.util.QueryUtil;
import com.smartsheet.api.models.ObjectInclusion;
import com.smartsheet.api.models.Report;
import com.smartsheet.api.models.SheetEmail;

import java.util.EnumSet;

/**
 * This is the implementation of the ReportResources.
 *
 * Thread Safety: This class is thread safe because it is immutable and its base class is thread safe.
 */

public class ReportResourcesImpl extends AbstractResources implements ReportResources{

    /**
     * Constructor.
     *
     * Parameters: - smartsheet : the SmartsheetImpl
     *
     * Exceptions: - IllegalArgumentException : if any argument is null
     *
     * @param smartsheet the smartsheet
     */
    public ReportResourcesImpl(SmartsheetImpl smartsheet) {
        super(smartsheet);
    }

    /**
     * Get a report.
     *
     * It mirrors to the following Smartsheet REST API method: GET /reports/{id}
     *
     * Exceptions:
     *   InvalidRequestException : if there is any problem with the REST API request
     *   AuthorizationException : if there is any problem with the REST API authorization(access token)
     *   ResourceNotFoundException : if the resource can not be found
     *   ServiceUnavailableException : if the REST API service is not available (possibly due to rate limiting)
     *   SmartsheetRestException : if there is any other REST API related error occurred during the operation
     *   SmartsheetException : if there is any other error occurred during the operation
     *
     * @param reportId the folder id
     * @return the report (note that if there is no such resource, this method will throw ResourceNotFoundException
     * rather than returning null)
     * @throws SmartsheetException the smartsheet exception
     */
    public Report getReport(long reportId, EnumSet<ObjectInclusion> includes, boolean includeAll, Integer pageSize, Integer page) throws SmartsheetException{
        this.checkParameters(pageSize, page);
        String path = "reports/" + reportId;
        path += QueryUtil.generateReportQueryString(includes, includeAll, pageSize, page);
        return this.getResource(path, Report.class);
    }

    /**
     * Sends a report as a PDF attachment via email to the designated recipients.
     *
     * It mirrors to the following Smartsheet REST API method: POST /reports/{id}/emails
     *
     * Exceptions:
     *   InvalidRequestException : if there is any problem with the REST API request
     *   AuthorizationException : if there is any problem with the REST API authorization(access token)
     *   ResourceNotFoundException : if the resource can not be found
     *   ServiceUnavailableException : if the REST API service is not available (possibly due to rate limiting)
     *   SmartsheetRestException : if there is any other REST API related error occurred during the operation
     *   SmartsheetException : if there is any other error occurred during the operation
     *
     * @param reportId the report id
     * @param email the recipient email
     * @return the report (note that if there is no such resource, this method will throw ResourceNotFoundException
     * rather than returning null)
     * @throws SmartsheetException the smartsheet exception
     */
    public void sendSheet(long reportId, SheetEmail email) throws SmartsheetException{
         this.createResource("reports/" + reportId + "/emails", SheetEmail.class, email);
    };

    /**
     * Checks pageSize and page.
     *
     * Exceptions:
     *   - InvalidRequestException : if there is any problem with the REST API request
     *   - AuthorizationException : if there is any problem with the REST API authorization(access token)
     *   - ResourceNotFoundException : if the resource can not be found
     *   - ServiceUnavailableException : if the REST API service is not available (possibly due to rate limiting)
     *   - SmartsheetRestException : if there is any other REST API related error occurred during the operation
     *   - SmartsheetException : if there is any other error occurred during the operation
     *
     * @param pageSize the page size
     * @param page the page number
     * @return the sheet as file
     * @throws SmartsheetException the smartsheet exception
     */
    private void checkParameters(Integer pageSize, Integer page){
        if (page != null && page <= 0 )
        {
            throw new IllegalArgumentException("Page Number must be greater than 0.");
        }

        if (pageSize != null && (pageSize <= 0 || pageSize > 500))
        {
            throw new IllegalArgumentException("Page Size must be between 1 and 500.");
        }
    }

}