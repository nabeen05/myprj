package com.gotomkt.svc.model;

import java.util.List;

import org.springframework.stereotype.Component;

/**
 * 
 * @author nabbeher
 *
 */

@Component
public class DocumentList {

	private List<Document> fileFolderList;

	public List<Document> getFileFolderList() {
		return fileFolderList;
	}

	public void setFileFolderList(List<Document> fileFolderList) {
		this.fileFolderList = fileFolderList;
	}
	
}
