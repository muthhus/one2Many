package org.telekomatrix.data.service.Simple.data.Service.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Embeddable
public class DomainCategoryId implements Serializable {
	
	private Domain domain;
	private Category category;
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.TABLE)
	    @Column(name = "id", nullable = false)
	    private Integer id;
	
	@ManyToOne
	@JsonBackReference
	public Domain getDomain() {
		return domain;
	}

	public void setDomain(Domain domain) {
		this.domain = domain;
	}

	@ManyToOne
	@JsonBackReference
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	
	
	public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DomainCategoryId that = (DomainCategoryId) o;

        if (domain != null ? !domain.equals(that.domain) : that.domain != null) return false;
        if (category != null ? !category.equals(that.category) : that.category != null)
            return false;

        return true;
    }

    public int hashCode() {
        int result;
        result = (domain != null ? domain.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        return result;
    }
    

}
