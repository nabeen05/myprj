package com.gotomkt.svc.services;
import java.lang.annotation.Annotation;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.gotomkt.svc.alf.IDocumentService;
import com.gotomkt.svc.model.Document;
import com.gotomkt.svc.model.DocumentList;
import com.gotomkt.svc.security.CacheUserDataManager;


/**
 * 
 * @author nabbeher
 *
 */
@Controller
@RequestMapping("/rest/api")
public class DocumentController {
	
	private static final Logger logger = Logger.getLogger(DocumentController.class);

	private static final int defaultMaxCount = 100;
	private IDocumentService documentService;
	
	@Autowired
	public DocumentController(IDocumentService documentService) {
		this.documentService = documentService;
	}
	
	@Autowired
	private CacheUserDataManager dataManager;
	
	/**
	 * Get document metadata based on document id.
	 * @param documentId Unique document identification generated by the app. Required for the api.
	 * @return document metadata in response.
	 */
	@RequestMapping(value = "/metadata",
					method = RequestMethod.GET, produces = "application/json")
	
	public ResponseEntity<Document> getMetadata(@RequestParam(value = "id", required = true) String documentId){
		/*if (!accountController.authenticate()) { // check for authorization
			return new ResponseEntity<DocumentResponse>(new DocumentResponse(), HttpStatus.FORBIDDEN);
		}*/
		
		// add the tickets to cache
		if(dataManager.getUserData("acme") == null){
			logger.info("adding to cache");
			dataManager.addUserData("acme", "some1233");
		}
		else{
			//just get the ticket from cache and use
			logger.info(dataManager.getUserData("acme"));
			
		}
			Document document = documentService.getMetaData(documentId);
			
		if (document != null) {
			
			return new ResponseEntity<Document>(document, HttpStatus.OK);
		} else {
			return new ResponseEntity<Document>(HttpStatus.NOT_FOUND);
		}
	}
	
	/**
	 *  Get a list of files and folders.
	 * @param parentID The folder ID to which documents should be gotten from.  It's not required parameter.  If no data provided, root folder will be used.
	 * @param max Maximum number of returned items.  Not required.  If not provided, defaultMaxCount (100) will be used.
	 * @param offset Starting offset of documents to retrieve. Not required.  Default to 0 as starting offset.
	 * @return An array of document metadata
	 */
	@RequestMapping(value = "/files",
					method = RequestMethod.GET)
	public ResponseEntity<DocumentList> getFiles(@RequestParam(value = "parentId", required = false) String parentID,
													   @RequestParam(value = "max", required = false) Integer max,
													   @RequestParam(value = "offset", required = false) Integer offset){

		/*if (!accountController.authenticate()) {
			//return new ResponseEntity<DocumentResponse[]>(HttpStatus.FORBIDDEN);
			return new ResponseEntity<DocumentResponse[]>(new DocumentListResource().toDocumentResponseArray(), HttpStatus.FORBIDDEN);
		}*/
		
		System.out.println("files......");
		int maxInt = (max == null) ? defaultMaxCount : max.intValue();
		int offsetInt = (offset == null || offset.intValue() < 0) ? 0 : offset.intValue();
		DocumentList list =  documentService.getFilesandFolders(parentID, maxInt,offsetInt);
		return new ResponseEntity<DocumentList>(list, HttpStatus.OK);
	}

}
