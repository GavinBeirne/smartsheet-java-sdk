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

import java.util.List;

import com.smartsheet.api.*;
import com.smartsheet.api.internal.util.Util;
import com.smartsheet.api.models.Column;

/**
 * This is the implementation of the SheetColumnResources.
 * 
 * Thread Safety: This class is thread safe because it is immutable and its base class is thread safe.
 */
public class SheetColumnResourcesImpl extends AbstractResources implements SheetColumnResources {
	
	/**
	 * Constructor.
	 * 
	 * Exceptions: - IllegalArgumentException : if any argument is null
	 *
	 * @param smartsheet the smartsheet
	 */
	public SheetColumnResourcesImpl(SmartsheetImpl smartsheet) {
		super(smartsheet);
	}

	/**
	 * List columns of a given sheet.
	 * 
	 * It mirrors to the following Smartsheet REST API method: GET /sheet/{id}/columns
	 * 
	 * Exceptions:
	 *   InvalidRequestException : if there is any problem with the REST API request
	 *   AuthorizationException : if there is any problem with the REST API authorization(access token)
	 *   ResourceNotFoundException : if the resource can not be found
	 *   ServiceUnavailableException : if the REST API service is not available (possibly due to rate limiting)
	 *   SmartsheetRestException : if there is any other REST API related error occurred during the operation
	 *   SmartsheetException : if there is any other error occurred during the operation
	 *
	 * @param sheetId the sheet id
	 * @return the columns (note that empty list will be returned if there is none)
	 * @throws SmartsheetException the smartsheet exception
	 */
	public List<Column> listColumns(long sheetId) throws SmartsheetException  {
		return this.listResources("sheet/" + sheetId + "/columns", Column.class);
	}

	/**
	 * Add column to a sheet.
	 * 
	 * It mirrors to the following Smartsheet REST API method: POST /sheet/{id}/columns
	 * 
	 * Exceptions:
	 *   IllegalArgumentException : if any argument is null
	 *   InvalidRequestException : if there is any problem with the REST API request
	 *   AuthorizationException : if there is any problem with the REST API authorization(access token)
	 *   ResourceNotFoundException : if the resource can not be found
	 *   ServiceUnavailableException : if the REST API service is not available (possibly due to rate limiting)
	 *   SmartsheetRestException : if there is any other REST API related error occurred during the operation
	 *   SmartsheetException : if there is any other error occurred during the operation
	 *
	 * @param sheetId the sheet id
	 * @param column the coluimn object limited to the following attributes: *
	 * title * type * symbol (optional) * options (optional) - array of options * index (zero-based) * systemColumnType
	 * (optional) * autoNumberFormat (optional)
	 * @return the created column
	 * @throws SmartsheetException the smartsheet exception
	 */
	public Column addColumn(long sheetId, Column column) throws SmartsheetException {
		return this.createResource("sheet/" + sheetId + "/columns", Column.class, column);
	}

	/**
	 * <p>Delete column.</p>
	 *
	 * <p>It mirrors to the following Smartsheet REST API method: DELETE /sheets/{sheetId}/columns/{columnId}</p>
	 *
	 * @param sheetId the sheet id
	 * @param columnId the column id
	 * @return the created column
	 * @throws IllegalArgumentException if any argument is null or empty string
	 * @throws InvalidRequestException if there is any problem with the REST API request
	 * @throws AuthorizationException if there is any problem with  the REST API authorization (access token)
	 * @throws ResourceNotFoundException if the resource cannot be found
	 * @throws ServiceUnavailableException if the REST API service is not available (possibly due to rate limiting)
	 * @throws SmartsheetException if there is any other error during the operation
	 */
	public void deleteColumn(long sheetId, long columnId) throws SmartsheetException {
		this.deleteResource("sheets/" + sheetId + "/columns/" + columnId, Column.class);
	}

	/**
	 * Update a column.
	 *
	 * It mirrors to the following Smartsheet REST API method: PUT /sheets/{sheetId}/columns/{columnId}
	 *
	 * Exceptions:
	 *   IllegalArgumentException : if any argument is null
	 *   InvalidRequestException : if there is any problem with the REST API request
	 *   AuthorizationException : if there is any problem with the REST API authorization(access token)
	 *   ResourceNotFoundException : if the resource can not be found
	 *   ServiceUnavailableException : if the REST API service is not available (possibly due to rate limiting)
	 *   SmartsheetRestException : if there is any other REST API related error occurred during the operation
	 *   SmartsheetException : if there is any other error occurred during the operation
	 *
	 * @param sheetId the sheetId
	 * @param column the column to update limited to the following attributes: index (column's new index in the sheet),
	 * title, sheetId, type, options (optional), symbol (optional), systemColumnType (optional),
	 * autoNumberFormat (optional)
	 * @return the updated sheet (note that if there is no such resource, this method will throw
	 * ResourceNotFoundException rather than returning null).
	 * @throws SmartsheetException the smartsheet exception
	 */
	public Column updateColumn(long sheetId, Column column) throws SmartsheetException {
		Util.throwIfNull(column);
		return this.updateResource("sheets/" + sheetId + "/columns/" + column.getId(), Column.class, column);
	}
}
