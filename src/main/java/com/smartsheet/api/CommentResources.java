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



import com.smartsheet.api.models.Comment;

/**
 * <p>This interface provides methods to access Comment resources.</p>
 * 
 * <p>Thread Safety: Implementation of this interface must be thread safe.</p>
 */
public interface CommentResources {
	
	/**
	 * <p>Get a comment.</p>
	 * 
	 * <p>It mirrors to the following Smartsheet REST API method:<br />
	 * GET /comment/{id}</p>
	 *
	 * @param id the id
	 * @return the comment (note that if there is no such resource, this method will throw ResourceNotFoundException
	 * rather than returning null).
	 * @throws IllegalArgumentException if any argument is null or empty string
	 * @throws InvalidRequestException if there is any problem with the REST API request
	 * @throws AuthorizationException if there is any problem with  the REST API authorization (access token)
	 * @throws ResourceNotFoundException if the resource cannot be found
	 * @throws ServiceUnavailableException if the REST API service is not available (possibly due to rate limiting)
	 * @throws SmartsheetException if there is any other error during the operation
	 */
	public Comment getComment(long id) throws SmartsheetException;

	/**
	 * <p>Delete a comment.</p>
	 * 
	 * <p>It mirrors to the following Smartsheet REST API method:<br />
	 * DELETE /comment{id}</p>
	 * 
	 * @param id the id
	 * @throws IllegalArgumentException if any argument is null or empty string
	 * @throws InvalidRequestException if there is any problem with the REST API request
	 * @throws AuthorizationException if there is any problem with  the REST API authorization (access token)
	 * @throws ResourceNotFoundException if the resource cannot be found
	 * @throws ServiceUnavailableException if the REST API service is not available (possibly due to rate limiting)
	 * @throws SmartsheetException if there is any other error during the operation
	 */
	public void deleteComment(long id) throws SmartsheetException;

	/**
	 * <p>Return the AssociatedAttachmentResources object that provides access to attachment resources associated with
	 * Comment resources.</p>
	 *
	 * @return the associated attachment resources
	 */
	public AssociatedAttachmentResources attachments();
}
