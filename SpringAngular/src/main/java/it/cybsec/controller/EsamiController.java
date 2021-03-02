package it.cybsec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import it.cybsec.model.Esami;
import it.cybsec.model.Skill;
import it.cybsec.service.EsamiService;

@RestController
@RequestMapping("/esami")
public class EsamiController {
	
	@Autowired
	private EsamiService attservice;
	
	@GetMapping("/all")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Esami> findAll(){
		return attservice.findAll();
	}

	@GetMapping("/findid/{id}")
	public Esami findById(@PathVariable("id") Integer id){
		return attservice.findById(id);
	}
	
	@PostMapping("/new")
	public List<Esami> newEl(@RequestBody Esami esami){
		attservice.newEl(esami);
		return findAll();
	}
	
	@DeleteMapping("/delid/{id}")
	public List<Esami> delEl(@PathVariable("id") Integer id){
		return attservice.delEl(id);
	}
	
	@PutMapping("/modify/{id}")
	public List<Esami> upDate(@PathVariable("id") Integer id,@RequestBody Esami esami){
		attservice.upDate(id, esami);
		return findAll();
	}
	
	@GetMapping("/esaminskill/{id}")
	public List<Skill> getFilmtoAttori(@PathVariable("id") Integer id){
		return attservice.getFilmtoAttori(id);	
	}
	
}
