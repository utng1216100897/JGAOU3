package jgao.dao;

import java.util.List;

import jgao.model.Die;

public interface DieDAO {
	
	void createDie(Die die);
	Die readDie(Long id);
	List<Die> readAllDies();
	void updateDie(Die die);
	void deleteDie(Long id);
	

}
