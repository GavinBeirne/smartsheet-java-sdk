package com.smartsheet.api;

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



import java.util.List;

import com.smartsheet.api.models.DataWrapper;
import com.smartsheet.api.models.MultiShare;
import com.smartsheet.api.models.PaginationParameters;
import com.smartsheet.api.models.Share;

/**
 * <p>This interface provides methods to access Share resources.</p>
 * 
 * <p>Thread Safety: Implementation of this interface must be thread safe.</p>
 */
public interface ShareResources {
	
	/**
	 * <p>List shares of a given object.</p>
	 * 
	 * <p>It mirrors to the following Smartsheet REST API method:<br />
	 * GET /workspace/{id}/shares <br />
	 * GET /sheet/{id}/shares</p>
	 *
	 * @param objectId the object id
	 * @param parameters the pagination parameters
	 * @return the list of Share objects (note that an empty list will be returned if there is none).
	 * @throws IllegalArgumentException if any argument is null or empty string
	 * @throws InvalidRequestException if there is any problem with the REST API request
	 * @throws AuthorizationException if there is any problem with  the REST API authorization (access token)
	 * @throws ResourceNotFoundException if the resource cannot be found
	 * @throws ServiceUnavailableException if the REST API service is not available (possibly due to rate limiting)
	 * @throws SmartsheetException if there is any other error during the operation
	 */
	public DataWrapper<Share> listShares(long objectId, PaginationParameters parameters) throws SmartsheetException;

	/**
	 * <p>Get a Share.</p>
	 * 
	 * <p>It mirrors to the following Smartsheet REST API method:<br />
	 * GET /workspace/{id}/shareWithGroups/{shareId}<br />
	 * GET /sheet/{id}/shareWithGroups/{shareId}</p>
	 *
	 * @param objectId the ID of the object to share
	 * @param shareId the ID of the share to whom the object is shared
	 * @return the share (note that if there is no such resource, this method will throw ResourceNotFoundException
	 * rather than returning null).
	 * @throws IllegalArgumentException if any argument is null or empty string
	 * @throws InvalidRequestException if there is any problem with the REST API request
	 * @throws AuthorizationException if there is any problem with  the REST API authorization (access token)
	 * @throws ResourceNotFoundException if the resource cannot be found
	 * @throws ServiceUnavailableException if the REST API service is not available (possibly due to rate limiting)
	 * @throws SmartsheetException if there is any other error during the operation
	 */
	public Share getShare(long objectId, String shareId) throws SmartsheetException;

	/**
	 * <p>Share the object, without sending email.</p>
	 * 
	 * <p>It mirrors to the following Smartsheet REST API method:<br />
	 * POST /workspace/{id}/shares<br />
	 * POST /sheet/{id}/shares</p>
	 *
	 * @param objectId the id of the object
	 * @param share the share object
	 * @return the created share
	 * @throws IllegalArgumentException if any argument is null or empty string
	 * @throws InvalidRequestException if there is any problem with the REST API request
	 * @throws AuthorizationException if there is any problem with  the REST API authorization (access token)
	 * @throws ResourceNotFoundException if the resource cannot be found
	 * @throws ServiceUnavailableException if the REST API service is not available (possibly due to rate limiting)
	 * @throws SmartsheetException if there is any other error during the operation
	 */
	public Share shareTo(long objectId, Share share) throws SmartsheetException;

	/**
	 * <p>Share the object.</p>
	 * 
	 * <p>It mirrors to the following Smartsheet REST API method:<br />
	 * POST /workspace/{id}/shares<br />
	 * POST /sheet/{id}/shares</p>
	 *
	 * @param objectId the ID of the object to share
	 * @param share the share object
	 * @param sendEmail the send email flag
	 * @return the created share
	 * @throws IllegalArgumentException if any argument is null or empty string
	 * @throws InvalidRequestException if there is any problem with the REST API request
	 * @throws AuthorizationException if there is any problem with  the REST API authorization (access token)
	 * @throws ResourceNotFoundException if the resource cannot be found
	 * @throws ServiceUnavailableException if the REST API service is not available (possibly due to rate limiting)
	 * @throws SmartsheetException if there is any other error during the operation
	 */
	public Share shareTo(long objectId, Share share, boolean sendEmail) throws SmartsheetException;

	/**
	 * <p>Share the object with multiple users, without sending email.</p>
	 * 
	 * <p>It mirrors to the following Smartsheet REST API method:<br />
	 * POST /workspace/{id}/multishare<br />
	 * POST /sheet/{id}/multishare</p>
	 *
	 * @param objectId the ID of the object to share
	 * @param multiShare the multi share object
	 * @return the list of created Shares
	 * @throws IllegalArgumentException if any argument is null or empty string
	 * @throws InvalidRequestException if there is any problem with the REST API request
	 * @throws AuthorizationException if there is any problem with  the REST API authorization (access token)
	 * @throws ResourceNotFoundException if the resource cannot be found
	 * @throws ServiceUnavailableException if the REST API service is not available (possibly due to rate limiting)
	 * @throws SmartsheetException if there is any other error during the operation
	 */
	public List<Share> shareTo(long objectId, MultiShare multiShare) throws SmartsheetException;

	/**
	 * <p>Share the object with multiple users.</p>
	 * 
	 * <p>It mirrors to the following Smartsheet REST API method:<br />
	 * POST /workspace/{id}/multishare<br />
	 * POST/sheet/{id}/multishare</p>
	 * 
	 * Parameters: - objectId : the ID of the object to share - multiShare : the MultiShare object - sendEmail : whether
	 * to send email
	 *
	 * @param objectId the object id
	 * @param multiShare the multi share
	 * @param sendEmail the send email flag
	 * @return the list of shares that were created
	 * @throws IllegalArgumentException if any argument is null or empty string
	 * @throws InvalidRequestException if there is any problem with the REST API request
	 * @throws AuthorizationException if there is any problem with  the REST API authorization (access token)
	 * @throws ResourceNotFoundException if the resource cannot be found
	 * @throws ServiceUnavailableException if the REST API service is not available (possibly due to rate limiting)
	 * @throws SmartsheetException if there is any other error during the operation
	 */
	public List<Share> shareTo(long objectId, MultiShare multiShare, boolean sendEmail) throws SmartsheetException;

	/**
	 * <p>Update a share.</p>
	 * 
	 * <p>It mirrors to the following Smartsheet REST API method:<br />
	 * PUT /workspace/{id}/shareWithGroups/{shareId}<br />
	 * PUT /sheet/{id}/shareWithGroups/{shareId}</p>
	 *
	 * @param objectId the ID of the object to share
	 * @param shareId the Id of the user to whom the object is shared
	 * @param share the share
	 * @return the updated share (note that if there is no such resource, this method will throw
	 *  ResourceNotFoundException rather than returning null).
	 * @throws IllegalArgumentException if any argument is null or empty string
	 * @throws InvalidRequestException if there is any problem with the REST API request
	 * @throws AuthorizationException if there is any problem with  the REST API authorization (access token)
	 * @throws ResourceNotFoundException if the resource cannot be found
	 * @throws ServiceUnavailableException if the REST API service is not available (possibly due to rate limiting)
	 * @throws SmartsheetException if there is any other error during the operation
	 */
	public Share updateShare(long objectId, String shareId, Share share) throws SmartsheetException;

	/**
	 * <p>Delete a share.</p>
	 * 
	 * <p>It mirrors to the following Smartsheet REST API method:<br />
	 * DELETE /workspace/{id}/share/{shareId}<br />
	 * DELETE /sheet/{id}/share/{shareId}</p>
	 *
	 * @param objectId the ID of the object to share
	 * @param shareId the ID of the share to delete
	 * @throws IllegalArgumentException if any argument is null or empty string
	 * @throws InvalidRequestException if there is any problem with the REST API request
	 * @throws AuthorizationException if there is any problem with  the REST API authorization (access token)
	 * @throws ResourceNotFoundException if the resource cannot be found
	 * @throws ServiceUnavailableException if the REST API service is not available (possibly due to rate limiting)
	 * @throws SmartsheetException if there is any other error during the operation
	 */
	public void deleteShare(long objectId, String shareId) throws SmartsheetException;
}
