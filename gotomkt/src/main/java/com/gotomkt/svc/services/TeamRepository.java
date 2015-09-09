package com.gotomkt.svc.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.gotomkt.svc.alf.model.Team;

/**
 * 
 * @author nabbeher
 *
 */
@Repository
public class TeamRepository {

	private static final Logger logger = Logger.getLogger(TeamRepository.class);
	
	@Autowired
	
	MongoTemplate mongoTemplate;
	
	public List getTeams(){
		List list = mongoTemplate.findAll(Team.class, "teams");
		logger.info(list.size());
		return list;
	}
	
}
