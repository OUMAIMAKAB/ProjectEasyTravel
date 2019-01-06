package com.ensak.tourismeApp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.ensak.tourismeApp.beans.Banque;
import com.ensak.tourismeApp.beans.Post;
import com.ensak.tourismeApp.beans.Utilisateur;
import com.ensak.tourismeApp.service.IPostService;
import com.ensak.tourismeApp.service.IUtilisateurService;

@RestController
@RequestMapping(value =  "utilisateurs/{idUtilisateur}/post")
public class PostRestController {

	@Autowired
	private IPostService postService;
	@Autowired
	private IUtilisateurService utilisateurService;
	
	
	@RequestMapping(value =  "/",method = RequestMethod.GET)
    public ResponseEntity<List<Post>> getListPost(@PathVariable("idUtilisateur") int idUtilisateur) {
		
		List <Post> posts= postService.getUtilisateurPost(idUtilisateur);
		if (posts.isEmpty()) {
			return new ResponseEntity<List<Post>>(HttpStatus.NO_CONTENT);
		}
		
	
		return new ResponseEntity<List<Post>>(posts, HttpStatus.OK);
    }
	// get un  post
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Post> getPost(@PathVariable("id") int id,@PathVariable("idUtilisateur") int idUtilisateur) {

		Post post = postService.getByIdAndIdUtilisateur(idUtilisateur, id);
		if (post == null) {
			return new ResponseEntity<Post>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Post>(post, HttpStatus.OK);
	
	}
	
	
	
	// Add un post
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<Post> addPost(@RequestBody Post post, UriComponentsBuilder ucb,@PathVariable("idUtilisateur") int idUtilisateur) {
		
            Utilisateur utilisateur = utilisateurService.getById(idUtilisateur);
            System.out.print("text"+post.getTexte());
            post.setUtilisateur(utilisateur);
			postService.save(post);
			//HttpHeaders headers = new HttpHeaders();
			//headers.setLocation(ucb.path("utilisateurs/{idUtilisateur}/post/{id}").buildAndExpand(post.getId()).toUri());
			return new ResponseEntity<Post>(post,HttpStatus.CREATED);
            
		}
	
	// remove post
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Post> deletePost(@PathVariable("id") int id) {

		Post  post = postService.getById(id);
		if (post == null) {
			return new ResponseEntity<Post>(HttpStatus.NOT_FOUND);
		}

		postService.remove(id);
		return new ResponseEntity<Post>(HttpStatus.NO_CONTENT);
	}
	
	// update post
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Post> updateCustomer(@PathVariable("idUtilisateur") int idUtilisateur,@PathVariable("id") int id, @RequestBody Post cus) {

		Post post= postService.getById(id);

		if (post == null) {
			return new ResponseEntity<Post>(HttpStatus.NOT_FOUND);
		};
        System.out.println("text"+cus.getTexte());
		post.setTexte(cus.getTexte());
		
		

		postService.update(post);
		return new ResponseEntity<Post>(post, HttpStatus.OK);
	}
	
	
}

