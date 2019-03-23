package org.telekomatrix.data.service.Simple.data.Service.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class DomainCategoryId implements Serializable {
	
	@Column(name = "domain_id")
	private Long domainId;
	

	@Column(name = "category_id")
	private Long categoryId;
	
	public DomainCategoryId() {}

	public DomainCategoryId(Long domainId, Long categoryId) {
		super();
		this.domainId = domainId;
		this.categoryId = categoryId;
	}

	public Long getDomainId() {
		return domainId;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	@Override
	public boolean equals(Object o) {
	if (this == o) return true;
	if (o == null || getClass() != o.getClass()) return false;
	DomainCategoryId that = (DomainCategoryId) o;
	return Objects.equals(domainId, that.domainId) &&
	Objects.equals(categoryId, that.categoryId);
	}
	@Override
	public int hashCode() {
	return Objects.hash(domainId, categoryId);
	}
	
	

}
