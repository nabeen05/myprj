package com.gotomkt.svc.alf;

import com.gotomkt.svc.model.Document;
import com.gotomkt.svc.model.DocumentList;

public interface IDocumentService {
	public Document getMetaData(String documentID);
	public Document getDocumentByID(String documentId);
	public DocumentList getFilesandFolders(String documentId, int maxInt, int offsetInt);
}
