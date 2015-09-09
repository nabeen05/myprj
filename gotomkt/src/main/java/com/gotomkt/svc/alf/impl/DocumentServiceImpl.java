package com.gotomkt.svc.alf.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;



import com.gotomkt.svc.alf.IDocumentService;
import com.gotomkt.svc.model.Document;
import com.gotomkt.svc.model.DocumentList;

@Component
public class DocumentServiceImpl implements IDocumentService {

	public Document getMetaData(String documentID) {
		
		//connect to Doc Central and get metadata
		Document doc = new Document();
		doc.setId(documentID);
		doc.setKind("file");
		return doc;
	}

	public Document getDocumentByID(String documentId) {
		
		return null;
	}


	public DocumentList getFilesandFolders(String documentId, int maxInt,
			int offsetInt) {
		
		DocumentList list = new DocumentList();
		List<Document> fileFolderList = new ArrayList<Document>();
		int i =0;
		while (i < 5){
			Document doc = new Document();
			doc.setId(""+i);
			doc.setKind("file");
			doc.setSize(10);
			doc.setTitle("doc-"+i);
			fileFolderList.add(doc);
			i++;
		}
		list.setFileFolderList(fileFolderList);
		
		return list;
	}

	
	

}
