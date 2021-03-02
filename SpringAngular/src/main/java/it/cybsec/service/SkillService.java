package it.cybsec.service;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.cybsec.model.Esami;
import it.cybsec.model.Skill;
import it.cybsec.repository.SkillRepository;

@Service
public class SkillService {
	
	@Autowired
	private SkillRepository skillrep;
	
	public List<Skill> findAll() {
		return (ArrayList<Skill>) skillrep.findAll();
	}
	
	public Skill findById(int id) {
		return skillrep.findById(id).get();
	}
	
	public void newEl(@Valid Skill film){
		skillrep.save(film);
	}
	
	public ArrayList<Skill> delEl(int id){
		skillrep.deleteById(id);
		return (ArrayList<Skill>) skillrep.findAll();
	}
	
	public void upDate(Integer id, Skill skill) {
		skill.setId(id);
		skillrep.save(skill);
	}
	
	public List<Esami> getEsamiToSkill(int id) {
		List<Esami> esami = new ArrayList<Esami>();
		Skill skillfin = skillrep.findById(id).get();
		esami = skillfin.getEsami();
		return esami;
	}

}
