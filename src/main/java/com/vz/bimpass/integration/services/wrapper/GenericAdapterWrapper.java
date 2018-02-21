package com.vz.bimpass.integration.services.wrapper;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GenericAdapterWrapper extends IGenericWrapper {

	private static final Logger LOG = LoggerFactory.getLogger(GenericAdapterWrapper.class);

	// Mongodb adapter template code 
	//@Autowired private DocumentRepository documentRepository;
	
	// SOAP adapter template code
	//@Autowired private SoapClient soapClient;
	
	public List<Object> find(String criteria) {
		
		LOG.info("GenericAdapterWrapper : find started...");
		List<Object> list = new ArrayList<Object>();
		
		//Generic code template
		String msg = "Resources for a given Criteria";
		list.add((Object)msg);
		
		// Mongodb adapter template code
		//list.add(documentRepository.findOne(criteria));
		
		return list;
	}
	
	public List<Object> findAll() {
		LOG.info("GenericAdapterWrapper : findAll started...");
		List<Object> list = new ArrayList<Object>();
		
		//Generic code template
		String msg = "All Resources";
		list.add((Object)msg);
		
		//Mongodb adapter template code
		//list.addAll(documentRepository.findAll());
		
		//SOAP adapter template code
		/*Request request = new Request();
		request.setCustomerId("1");
		list.add(soapClient.invokeService(request));*/
		
		return list;
	}


	public Object save(List<Object> list) {
		LOG.info("GenericAdapterWrapper : save started...");
		
		//Generic code template
		return "Save a Resource";
		
		//Mongodb adapter template code
		//List<SampleDocument> documentList = (List<SampleDocument>)(List<?>) list;
		//return documentRepository.save(documentList);

	}
	
	public Object delete(List<Object> list) {
		LOG.info("GenericAdapterWrapper : delete started...");
		
		//Generic code template
		return "Success";
				
		//Mongodb adapter template code
		/*List<String> documentIdList = (List<String>)(List<?>) list;
		documentRepository.delete(documentRepository.findAll(documentIdList));
		return "Success";*/
	}
		
}
