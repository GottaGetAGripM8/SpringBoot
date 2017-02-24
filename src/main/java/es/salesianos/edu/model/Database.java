package es.salesianos.edu.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Database {

	private List<Menu> lista = new ArrayList<>();

	public void add(Menu menu) {
		getLista().add(menu);
	}

	public List<Menu> getLista() {
		return lista;
	}

	public void setLista(List<Menu> lista) {
		this.lista = lista;
	}
}
