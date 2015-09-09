package com.gotomkt.svc.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.mongodb.InvalidMongoDbApiUsageException;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.gotomkt.svc.alf.ICategoryService;
import com.gotomkt.svc.alf.model.Team;
import com.gotomkt.svc.model.Category;
import com.gotomkt.svc.model.CategoryList;


/**
 * 
 * @author nabbeher
 *
 */
@Controller
@RequestMapping("/v1/services")

public class CategoryController {
	private static final Logger logger = Logger.getLogger(CategoryController.class);
	
	@Autowired
	private ICategoryService categoryService;
	
	@Autowired
	TeamRepository teamRepo;
	
	/*@Autowired
	public CategoryController(ICategoryService categoryService, MongoTemplate mongoTemplate){
		this.categoryService = categoryService ;
		this.mongoTemplate = mongoTemplate;
		
	}*/
	
	
	
	@RequestMapping(value = "/category",
			method = RequestMethod.GET, produces = "application/json")

public ResponseEntity<Category> getCategory(@RequestParam(value = "name", required = true) String category){
		
		System.out.println(category);
		Category cate = categoryService.getCategory(category);
		
		if(cate !=null){
			
			return new ResponseEntity<Category>( cate,HttpStatus.OK);
		}else {
			return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
		}
		
		
	}

	@RequestMapping(value = "/categories",
			method = RequestMethod.GET, produces = "application/json")
	
public ResponseEntity<CategoryList> getCategories(@RequestParam(value = "name", required = true) String category){
		
		System.out.println(category);
		CategoryList cate = categoryService.getCategories(category);
		
		if(cate !=null){
			
			return new ResponseEntity<CategoryList>( cate,HttpStatus.OK);
		}else {
			return new ResponseEntity<CategoryList>(HttpStatus.NOT_FOUND);
		}
		
		
	}
	
	@RequestMapping(value = "/teams",
			method = RequestMethod.GET, produces = "application/json")
	
	public ResponseEntity<List> getTeams(@RequestParam(value = "name", required = false)String category){
		
		
		return new ResponseEntity<List>(teamRepo.getTeams(), HttpStatus.OK);
	}
	

}
