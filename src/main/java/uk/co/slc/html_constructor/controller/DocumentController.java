package uk.co.slc.html_constructor.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import uk.co.slc.html_constructor.entities.Document;
import uk.co.slc.html_constructor.services.DocumentServiceImpl;

@Controller
@SessionAttributes("document")
public class DocumentController {

	@Autowired
	private DocumentServiceImpl docService;
	
	
	@RequestMapping(value = "/document/add", method = RequestMethod.GET)
	public String documentAddGet(ModelMap map) {
		map.put("document", new Document());
		return "documents/addDocument";
	}
	
	@RequestMapping(value = "/document/add", method = RequestMethod.POST)
	public String documentAddPost(@ModelAttribute("document") Document doc) {
		docService.save(doc);
		return "redirect:/document/list";
	}
	
	@RequestMapping(value = "/document/edit/{id}", method = RequestMethod.POST)
	public String documentEditPost(@ModelAttribute("document") Document doc) {
		docService.save(doc);
		return "redirect:/document/list";
	}

	@RequestMapping(value = "/document/edit/{id}", method = RequestMethod.GET)
	public String documentEditGet( @PathVariable("id") Long id, ModelMap map ) {
		Document d = docService.getDocumentById(id);
		map.put("document", d);
		return "documents/addDocument";
	}
	
	@RequestMapping(value = "/document/edit", method = RequestMethod.GET)
	public String documentEditGetSession( @ModelAttribute("document") Document doc, ModelMap map ) {
		map.put("document", doc);
		return "documents/addDocument";
	}
	
	@RequestMapping(value = {"/document/edit/{id}","/document/add"}, method = RequestMethod.POST, params="section")
	public String documentAddSection(Document doc, HttpSession session) {
		session.setAttribute("document", doc);
		return "redirect:/document/section/manage";
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
