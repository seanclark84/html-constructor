package uk.co.slc.html_constructor.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import uk.co.slc.html_constructor.entities.Document;
import uk.co.slc.html_constructor.entities.Section;

@Controller
@SessionAttributes("section")
public class SectionController {
	
	@RequestMapping( value = "/document/section/manage", method = RequestMethod.GET)
	public String sectionGet(HttpSession session, ModelMap map) {
		map.put("section", new Section());
		return "documents/section/manageSection";
	}
	
	@RequestMapping( value = "/document/section/manage", method = RequestMethod.POST)
	public String sectionPost(HttpSession session, @ModelAttribute("section") Section section, ModelMap map) {
		Document document = (Document) session.getAttribute("document");
		document.getSections().add(section);
		return "redirect:/document/edit";
	}
}
