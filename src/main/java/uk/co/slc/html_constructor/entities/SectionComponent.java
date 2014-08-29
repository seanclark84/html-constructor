package uk.co.slc.html_constructor.entities;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;

@NodeEntity
public abstract class SectionComponent {
	@GraphId
	private Long nodeId;
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SectionComponent sc = (SectionComponent) o;
        if (nodeId == null) return super.equals(o);
        return nodeId.equals(sc.nodeId);

    }

    @Override
    public int hashCode() {
        return nodeId != null ? nodeId.hashCode() : super.hashCode();
    }
}
