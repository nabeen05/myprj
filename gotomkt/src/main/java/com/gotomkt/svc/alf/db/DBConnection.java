package com.gotomkt.svc.alf.db;

import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

/**
 * 
 * @author nabbeher
 *
 */
public class DBConnection {
	
	public static void main(String []args){
		
		MongoClient mongo = new MongoClient( "alfurdapp-dev-001" , 27017 );
		List<String> dbs = mongo.getDatabaseNames();
		for(String db : dbs){
			System.out.println(db);
		}
		
		DB db = mongo.getDB("gotomkt");
		
		DBCollection table = db.getCollection("teams");
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("country","England");
		
		// for all the colection for this group
		//DBCursor cursor = table.find();

		//predicate
		DBCursor cursor = table.find(searchQuery);
		while (cursor.hasNext()) {
			System.out.println(cursor.next());
		}
	}

}
