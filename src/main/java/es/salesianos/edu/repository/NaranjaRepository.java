package es.salesianos.edu.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import es.salesianos.edu.model.Database;
import es.salesianos.edu.model.Menu;

public class NaranjaRepository {
	@Autowired
	Database database;

	public List<Menu> listar() {
		List<Menu> listBocatas = new ArrayList<>();
		List<Menu> list = database.getLista();
		for (Menu menu : list) {
			if (menu.getOrange().equals("Si")) {
				listBocatas.add(menu);
			}
		}
		return listBocatas;
	}
}
