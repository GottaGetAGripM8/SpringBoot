package es.salesianos.edu.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.salesianos.edu.model.Database;
import es.salesianos.edu.model.Menu;

@Repository
public class BocadilloRepository {

	@Autowired
	Database database;

	public void insertar(Menu menu){
		database.add(menu);
		
	}

	public List<Menu> listar() {
		List<Menu> listBocatas = new ArrayList<>();
		List<Menu> list = database.getLista();
		for (Menu menu : list) {
				listBocatas.add(menu);
		}
		return listBocatas;
	}



}
