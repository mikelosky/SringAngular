package it.cybsec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import it.cybsec.service.SkillService;

@RestController
@RequestMapping("/skill")
public class SkillController {
	
	
	@Autowired
	private SkillService filmservice;

	@GetMapping("/all")
	public List<Skill> findAll(){
		return filmservice.findAll();
	}
	
	@GetMapping("/findid/{id}")
	public Skill findById(@PathVariable("id") Integer id){
		return filmservice.findById(id);
	}
	
	@PostMapping("/new")
	public List<Skill> newEl(@RequestBody Skill skill){
		filmservice.newEl(skill);
		return findAll();
	}
	
	@DeleteMapping("/delid/{id}")
	public List<Skill> delEl(@PathVariable("id") Integer id){
		return filmservice.delEl(id);
	}
	
	@PutMapping("/modify/{id}")
	public List<Skill> upDate(@PathVariable("id") Integer id,@RequestBody Skill skill){
		filmservice.upDate(id, skill);
		return findAll();
	}
	
	@GetMapping("/skillinesami/{id}")
	public List<Esami> getFilmtoAttori(@PathVariable("id") Integer id){
		return filmservice.getEsamiToSkill(id);	
	}
	
}
