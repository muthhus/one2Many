package org.telekomatrix.data.service.Simple.data.Service.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name ="domain_category")
@AssociationOverrides({
	@AssociationOverride(name = "pk.domain", 
		joinColumns = @JoinColumn(name = "DOMAIN_ID")),
	@AssociationOverride(name = "pk.category", 
		joinColumns = @JoinColumn(name = "CATEGORY_ID")) })
public class DomainCategory implements Serializable{
	
	private DomainCategoryId pk = new DomainCategoryId();
	private Date createdDate;
	private String createdBy;
	
	public DomainCategory() {
		
	}
	
	@EmbeddedId
	public DomainCategoryId getPk() {
		return pk;
	}
	
	public void setPk(DomainCategoryId pk) {
		this.pk = pk;
	}
	
	@Transient
	public Domain getDoamin() {
		return getPk().getDomain();
	}

	public void setDomain(Domain domain) {
		getPk().setDomain(domain);
	}
	
	@Transient
	public Category getCategory() {
		return getPk().getCategory();
	}

	public void setCategory(Category category) {
		getPk().setCategory(category);
	}
	
	
	@Temporal(TemporalType.DATE)
	@Column(name = "CREATED_DATE", nullable = false, length = 10)
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name = "CREATED_BY", nullable = false, length = 10)
	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		DomainCategory that = (DomainCategory) o;

		if (getPk() != null ? !getPk().equals(that.getPk())
				: that.getPk() != null)
			return false;

		return true;
	}

	public int hashCode() {
		return (getPk() != null ? getPk().hashCode() : 0);
	}	
	
}
