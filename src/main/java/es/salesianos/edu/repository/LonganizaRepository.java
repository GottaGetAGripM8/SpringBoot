package es.salesianos.edu.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.salesianos.edu.model.Database;
import es.salesianos.edu.model.Menu;

@Repository
public class LonganizaRepository {
	@Autowired
	Database database;

	public List<Menu> listar() {
		List<Menu> listBocatas = new ArrayList<>();
		List<Menu> list = database.getLista();
		for (Menu menu : list) {
			if (menu.getType().equals("Longaniza")) {
				listBocatas.add(menu);
			}
		}
		return listBocatas;
	}
}
