package uk.co.slc.html_constructor.repositories;

import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.neo4j.repository.RelationshipOperationsRepository;
import org.springframework.transaction.annotation.Transactional;

import uk.co.slc.html_constructor.entities.Document;

@Transactional
public interface DocumentRepository extends GraphRepository<Document>, RelationshipOperationsRepository<Document> {
}