package uk.co.slc.html_constructor.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.support.Neo4jTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import uk.co.slc.html_constructor.entities.Document;
import uk.co.slc.html_constructor.repositories.DocumentRepository;

@Service
@Transactional
public class DocumentServiceImpl {

	@Autowired
	private DocumentRepository documentRepository;

	public void save(Document doc) {
		documentRepository.save(doc);
	}

	public List<Document> getAllDocuments() {
		return documentRepository.findAll().as(List.class);
	}

	public void deleteDocument(long id) {
		documentRepository.delete(id);
	}
}
