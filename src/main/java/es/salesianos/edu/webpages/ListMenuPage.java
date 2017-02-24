package es.salesianos.edu.webpages;

import java.util.Collections;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;

import es.salesianos.edu.model.Author;
import es.salesianos.edu.service.BocadillosService;
import es.salesianos.edu.service.LonganizaService;
import es.salesianos.edu.service.NaranjaService;
import es.salesianos.edu.service.TofuService;

public class ListMenuPage extends WebPage {

	private static final long serialVersionUID = -1935854748907274886L;

	@SpringBean
	BocadillosService bocadillos;
	@SpringBean
	TofuService tofu;
	@SpringBean
	LonganizaService longaniza;
	@SpringBean
	NaranjaService naranjas;

	private static final Logger logger = LogManager.getLogger(ListMenuPage.class.getName());


	private List<String> show = Collections.emptyList();
	private int total = 0;

	public ListMenuPage(PageParameters parameters) {
		total = parameters.get("total").toInt();
		show = parameters.get("list").to(List.class);
		initComponents();
	}

	public ListMenuPage() {
		initComponents();
	}

	private void initComponents() {
		addForm();
		addFeedBackPanel();
		addListAuthorView();
	}

	private void addForm() {
		PageParameters pageParameters = new PageParameters();
		Form form = new Form("formListMenu", new CompoundPropertyModel(new Author())) {

		};
		Button listLonganiza = new Button("longanizabutton") {
			public void onSubmit() {
				show = longaniza.listar();
				total = longaniza.getTotal();
				addPrameters(pageParameters);
			}


		};
		Button listTofu = new Button("tofubutton") {
			public void onSubmit() {
				show = tofu.listar();
				total = tofu.getTotal();
				addPrameters(pageParameters);
			}
		};
		Button listNaranja = new Button("naranjabutton") {
			public void onSubmit() {
				show = naranjas.listar();
				total = naranjas.getTotal();
				addPrameters(pageParameters);
			}
		};
		Button listTotal = new Button("totalbutton") {
			public void onSubmit() {
				show = bocadillos.listar();
				total = bocadillos.getTotal();
				addPrameters(pageParameters);
			}
		};
		form.add(listLonganiza);
		form.add(listTofu);
		form.add(listNaranja);
		form.add(listTotal);

		form.add(new TextField("nameAuthor"));
		add(form);
	}

	private void addPrameters(PageParameters pageParameters) {
		pageParameters.add("list", show);
		pageParameters.add("total", total);
	}

	private void addFeedBackPanel() {
		FeedbackPanel feedbackPanel = new FeedbackPanel("feedbackMessage");
		add(feedbackPanel);
	}

	private void addListAuthorView() {
		ListView listview = new ListView("element-group", show) {
			@Override
			protected void populateItem(ListItem item) {
				String element = (String) item.getModelObject();
				item.add(new Label("text", element));
			}
		};
		add(listview);
	}


}
