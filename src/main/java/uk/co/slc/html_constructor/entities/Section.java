package uk.co.slc.html_constructor.entities;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

@NodeEntity
public class Section {
	@GraphId
	private Long nodeId;
	
	private String title;
	@RelatedTo
	@Fetch
	private Set<SectionComponent> components = new LinkedHashSet<SectionComponent>();

	public Long getNodeId() {
		return nodeId;
	}

	public void setNodeId(Long nodeId) {
		this.nodeId = nodeId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public Set<SectionComponent> getComponents() {
		return components;
	}

	public void setComponents(Set<SectionComponent> components) {
		this.components = components;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Section sec = (Section) o;
        if (nodeId == null) return super.equals(o);
        return nodeId.equals(sec.nodeId);

    }

    @Override
    public int hashCode() {
        return nodeId != null ? nodeId.hashCode() : super.hashCode();
    }
}
