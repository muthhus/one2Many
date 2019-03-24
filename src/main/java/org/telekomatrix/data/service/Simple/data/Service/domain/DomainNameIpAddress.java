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
@Table(name = "domain_name_ip_address")
@AssociationOverrides({
	@AssociationOverride(name = "pk.domainName", 
		joinColumns = @JoinColumn(name = "DOMAIN_NAME_ID")),
	@AssociationOverride(name = "pk.ipAddress", 
		joinColumns = @JoinColumn(name = "IP_ADDRESS_ID")) })
public class DomainNameIpAddress implements Serializable{
	
	private DomainNameIpAddressId pk = new DomainNameIpAddressId();
	
	private Date createdDate;
	private String createdBy;
	
	public DomainNameIpAddress() {

	}
	
	@EmbeddedId
	public DomainNameIpAddressId getPk() {
		return pk;
	}
	
	public void setPk(DomainNameIpAddressId pk) {
		this.pk = pk;
	}
	
	@Transient
	public DomainName getDoaminName() {
		return getPk().getDomainName();
	}

	public void setDomainName(DomainName domainName) {
		getPk().setDomainName(domainName);
	}
	
	@Transient
	public IpAddress getCategory() {
		return getPk().getIpAddress();
	}

	public void setIpAddress(IpAddress ipAddress) {
		getPk().setIpAddress(ipAddress);
	}
	
	
	@Temporal(TemporalType.DATE)
	@Column(name = "CREATED_DATE", nullable = false, length = 10)
	public Date getCreatedDate() {
		return createdDate;
	}
	
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	@Column(name = "CREATED_BY", nullable = false, length = 10)
	public String getCreatedBy() {
		return createdBy;
	}
	
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		DomainNameIpAddress that = (DomainNameIpAddress) o;

		if (getPk() != null ? !getPk().equals(that.getPk())
				: that.getPk() != null)
			return false;

		return true;
	}

	public int hashCode() {
		return (getPk() != null ? getPk().hashCode() : 0);
	}	
	
	
}
