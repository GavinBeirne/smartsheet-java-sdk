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

import com.smartsheet.api.GroupResources;
import com.smartsheet.api.MemberResources;
import com.smartsheet.api.SmartsheetException;
import com.smartsheet.api.internal.util.Util;
import com.smartsheet.api.models.Group;

/**
 * This is the implementation of the HomeResources.
 * 
 * Thread Safety: This class is thread safe because it is immutable and its base class is thread safe.
 */
public class GroupResourcesImpl extends AbstractResources implements GroupResources {
	private MemberResources members;
	/**
	 * Constructor.
	 * 
	 * Exceptions: - IllegalArgumentException : if any argument is null
	 *
	 * @param smartsheet the smartsheet
	 */
	public GroupResourcesImpl(SmartsheetImpl smartsheet) {
		super(smartsheet); 
		this.members = new MemberResourcesImpl(smartsheet, "group");
	}

	@Override
	public List<Group> listGroups() throws SmartsheetException {
		return this.listResources("groups", Group.class);
	}

	@Override
	public Group getGroup(long groupId) throws SmartsheetException {
		return this.getResource("group/" + groupId, Group.class);
	}

	@Override
	public Group createGroup(Group group) throws SmartsheetException {
		Util.throwIfNull(group);
		return this.createResource("groups", Group.class, group);
	}

	@Override
	public Group updateGroup(Group group) throws SmartsheetException {
		Util.throwIfNull(group);
		return this.updateResource("group/"+ group.getId(), Group.class, group);
	}

	@Override
	public void deleteGroup(long groupId) throws SmartsheetException {
		this.deleteResource("group/" + groupId, Group.class);
	}

	@Override
	public MemberResources members() throws SmartsheetException {
		return members;
	}
}
