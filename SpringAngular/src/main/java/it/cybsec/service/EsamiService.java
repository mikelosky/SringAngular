package it.cybsec.service;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.cybsec.model.Esami;
import it.cybsec.model.Skill;
import it.cybsec.repository.EsamiRepository;

@Service
public class EsamiService {
	
	@Autowired
	private EsamiRepository esamirep;
	
	public List<Esami> findAll() {
		return (ArrayList<Esami>)esamirep.findAll();
		
	}
	
	public Esami findById(int id) {
		return esamirep.findById(id).get();
	}
	
	public void newEl(@Valid Esami esami){
		esamirep.save(esami);
	}
	
	public List<Esami> delEl(int id){
		esamirep.deleteById(id);
		return (List<Esami>) esamirep.findAll();
	}
	
	public void upDate(Integer id, Esami esami) {
		esami.setId(id);
		esamirep.save(esami);
	}
	
	public List<Skill> getFilmtoAttori(int id) {
		List<Esami> esami = esamirep.findAll();
		List<Skill> skillfin = new ArrayList<Skill>();
		for (Esami esame : esami) {
	        if (esame.getId()==id) {
	        	skillfin = esame.getSkill();
	        	return skillfin;
	        }
		}
		return skillfin;
	}
	
	
}
