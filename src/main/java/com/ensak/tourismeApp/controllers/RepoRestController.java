package com.ensak.tourismeApp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ensak.tourismeApp.beans.Repo;
import com.ensak.tourismeApp.service.IRepoService;
import com.ensak.tourismeApp.service.IRepoService;

@RestController
@RequestMapping(value =  "/users/{user}/repos")
public class RepoRestController {
	
	@Autowired
	private IRepoService repoService;
	
	@RequestMapping(value =  "/",method = RequestMethod.GET)
    public ResponseEntity<List<Repo>> test(@PathVariable("user") String user) {
		
		List<Repo> Repos= repoService.selectAll();
		if (Repos.isEmpty()) {
			return new ResponseEntity<List<Repo>>(HttpStatus.NO_CONTENT);
		}
		
	
		return new ResponseEntity<List<Repo>>(Repos, HttpStatus.OK);
    }

	
	

}
