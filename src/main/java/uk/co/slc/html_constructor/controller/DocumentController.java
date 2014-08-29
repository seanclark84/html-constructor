package uk.co.slc.html_constructor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import uk.co.slc.html_constructor.entities.Document;
import uk.co.slc.html_constructor.entities.HtmlSectionComponent;
import uk.co.slc.html_constructor.entities.Section;
import uk.co.slc.html_constructor.services.DocumentServiceImpl;

@Controller
public class DocumentController {

	@Autowired
	private DocumentServiceImpl docService;
	
	
	@RequestMapping(value = "/document/add", method = RequestMethod.GET)
	public String documentAddGet() {
		return "documents/addDocument";
	}
	
	@RequestMapping(value = "/document/add", method = RequestMethod.POST)
	public String documentAddPost(WebRequest webRequest) {
		Document doc = new Document();
		doc.setName(webRequest.getParameter("name"));
		doc.setDescription(webRequest.getParameter("description"));
		
		Section s = new Section();
		s.setTitle("Title 1");
		
		doc.getSections().add(s);
		
		HtmlSectionComponent component = new HtmlSectionComponent();
		component.setHtml("Some html");
		HtmlSectionComponent component1 = new HtmlSectionComponent();
		component1.setHtml("Some other html");
		
		s.getComponents().add(component);
		s.getComponents().add(component1);
		
		docService.save(doc);
		return "redirect:/document/list";
	}
	
	@RequestMapping(value = "/document/list", method = RequestMethod.GET)
	public String listDocuments(ModelMap map) {
		map.put("documents", docService.getAllDocuments());
		return "documents/listDocuments";
	}
	
	
	@RequestMapping(value = "/document/delete", method = RequestMethod.GET)
	public String listDocuments(@RequestParam("id") long id) {
		docService.deleteDocument(id);
		return "redirect:/document/list";
	}
}
