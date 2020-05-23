package com.example.demo.controller;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Shringer;
import com.example.demo.repository.ShringerRepository;





@RestController
public class ShringerController {
    	
	@Autowired
	ShringerRepository repo;
	static final Logger log = Logger.getLogger(ShringerController.class.getName());
	
	@RequestMapping(method=RequestMethod.GET,value="/getAll")
	public List<Shringer> getAll(){
		
		List<Shringer> update=null;
		
		return update;
		
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/create")
	public Shringer PostByID(@RequestBody Shringer shrin) {
		
		Shringer shri=repo.save(shrin);
		return shri;
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/update")
	public Shringer UpdateByid(@RequestBody Shringer shrin) {
		
		Shringer shri=repo.save(shrin);
		return shri;
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/delete")	
	public void DeleteById(Integer id) {
		 repo.deleteById(id);
		
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/register")
	public Shringer Register(@RequestBody Shringer shrin) {
		Shringer s1 = null;
		try {
		if(shrin.getEmail()!=null && shrin.getName()!=null) {
			
			s1=repo.save(shrin);
			 
		}else {
			
			log.info("email not found");
		}
		
		
		}
		catch(Exception e) {
			System.out.println("User details should be provided");
		}
		return s1;
		
		
	}
		
}
