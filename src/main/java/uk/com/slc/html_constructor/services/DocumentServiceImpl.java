package uk.com.slc.html_constructor.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.support.Neo4jTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import uk.com.slc.html_constructor.entities.Document;

@Service
public class DocumentServiceImpl {

	@Autowired
	private Neo4jTemplate template;

	@Transactional
	public void save(Document doc) {
		template.save(doc);
	}

	@Transactional
	public List<Document> getAllDocuments() {
		return template.findAll(Document.class).as(List.class);
	}

	@Transactional
	public void deleteDocument(long id) {
		Document doc = template.findOne(id, Document.class);
		template.delete(doc);
	}
}
