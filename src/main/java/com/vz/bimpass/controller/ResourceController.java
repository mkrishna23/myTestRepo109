package com.vz.bimpass.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vz.bimpass.exception.ErrorCodes;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * 
 *
 * @author TechMahindra
 */
@RestController
@RequestMapping("/bsi/usecase")
public class ResourceController {

	@Autowired
	private com.vz.bimpass.service.GenericService service;

	private static final Logger LOG = LoggerFactory.getLogger(ResourceController.class);

	@ApiOperation(value = "Fetch All Resources", notes = "Fetch All Resource(s)")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully returns the list of Resource(s)"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	@RequestMapping(value = { "/v1/list" }, method = { RequestMethod.GET }, produces = { "application/json" })
	public ResponseEntity<?> getAllResources() {
		try {
			LOG.info("ResourceController:: getAll method started ");
			List<Object> fetchedResources = service.findAll();
			return new ResponseEntity<List<Object>>(fetchedResources, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return (new ResponseEntity<String>(ErrorCodes.SERVER_ERROR.getDescription(),
					HttpStatus.INTERNAL_SERVER_ERROR));
		}
	}

	
	@ApiOperation(value = "Create New Resource(s)", notes = "Create New Resource(s)")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Created new Resource(s) Successfully"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	@RequestMapping(value = { "/v1" }, method = RequestMethod.POST)
	public ResponseEntity<?> createResource(@RequestBody List<Object> list) {  
		try {
			
			//Generic template code
			Object response = service.save(list);

			// Mongodb template code
			/*List<Object> documentList = new ArrayList<Object>();
			documentList.addAll(list);
			Object response = service.save(documentList);
			*/
			
			return new ResponseEntity<Object>(response, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return (new ResponseEntity<String>(ErrorCodes.SERVER_ERROR.getDescription(),
					HttpStatus.INTERNAL_SERVER_ERROR));
		}
	}

	@ApiOperation(value = "Update Existing Resource(s)", notes = "Update Existing Resource(s)")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Updated Existing Resource(s) Successfully"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	@RequestMapping(value = { "/v1" }, method = RequestMethod.PUT)
	public ResponseEntity<?> updateResource(@RequestBody List<Object> list) {  
		try {
			
			//Generic template code
			Object response = service.save(list);

			// Mongodb template code
			/*List<Object> documentList = new ArrayList<Object>();
			  documentList.addAll(list);
			  Object response = service.save(documentList);
			*/
			return new ResponseEntity<Object>(response, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return (new ResponseEntity<String>(ErrorCodes.SERVER_ERROR.getDescription(),
					HttpStatus.INTERNAL_SERVER_ERROR));
		}
	}
	
	@ApiOperation(value = "Delete Resource(s)", notes = "Delete Resource(s) for list of input ids")
	@ApiResponses(value = {	@ApiResponse(code = 200, message = "Deleted Resource(s) Successfully"),
							@ApiResponse(code = 500, message = "Internal Server Error")
						})	 
	  @RequestMapping(value={"/v1"}, method=RequestMethod.DELETE)
	  public ResponseEntity<?> delete(@RequestBody List<Object> list) {
		  try {
			  service.delete(list);
			  return new ResponseEntity<String>("Success", HttpStatus.OK);
		  } catch (Exception e) {
			  e.printStackTrace();
			  return (new ResponseEntity<String>(ErrorCodes.SERVER_ERROR.getDescription(), HttpStatus.INTERNAL_SERVER_ERROR));
		  }
		  
	  }

	} // class ServiceController
