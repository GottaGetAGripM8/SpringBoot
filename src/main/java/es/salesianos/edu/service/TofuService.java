package es.salesianos.edu.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import es.salesianos.edu.model.Menu;
import es.salesianos.edu.repository.TofuRepository;

public class TofuService {

	@Autowired
	TofuRepository repository;

	public List<String> listar() {
		List<String> show = new ArrayList<>();
		List<Menu> menus = repository.listar();
		for (Menu menu : menus) {
			show.add(menu.getName() + " || " + menu.getPrice());
		}
		return show;
	}

	public int getTotal() {
		int total = 0;
		List<Menu> menus = repository.listar();
		for (Menu menu : menus) {
			total += menu.getPrice();
		}
		return total;
	}

}
