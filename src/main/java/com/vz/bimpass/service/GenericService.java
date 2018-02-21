/*
 * Copyright (C) Red Hat, Inc.
 * http://www.redhat.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.vz.bimpass.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


@org.springframework.stereotype.Service
public class GenericService {
	private static final Logger LOG = LoggerFactory.getLogger(GenericService.class);

	@Autowired
	private com.vz.bimpass.integration.services.wrapper.IGenericWrapper genericWrapper;

	public List<Object> find(String criteria) {
		LOG.info("GenericService : find started...");
		return genericWrapper.find(criteria);
	}
	
	public List<Object> findAll() {
		LOG.info("GenericService : findAll started...");
		return genericWrapper.findAll();
	}


	public Object save(List<Object> list) {
		LOG.info("GenericService :save started...");
		return genericWrapper.save(list);
	}
	
	public Object delete(List<Object> list) {
		LOG.info("GenericService :save started...");
		return genericWrapper.delete(list);
	}
}
