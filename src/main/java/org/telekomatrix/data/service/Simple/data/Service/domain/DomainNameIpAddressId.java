package org.telekomatrix.data.service.Simple.data.Service.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Embeddable
public class DomainNameIpAddressId implements Serializable{
	
	private DomainName domainName;
	private IpAddress ipAddress;
	
	@ManyToOne
	@JsonBackReference
	public DomainName getDomainName() {
		return domainName;
	}
	public void setDomainName(DomainName domainName) {
		this.domainName = domainName;
	}
	
	@ManyToOne
	@JsonBackReference
	public IpAddress getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(IpAddress ipAddress) {
		this.ipAddress = ipAddress;
	}
	
	
	public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DomainNameIpAddressId that = (DomainNameIpAddressId) o;

        if (domainName != null ? !domainName.equals(that.domainName) : that.domainName != null) return false;
        if (ipAddress != null ? !ipAddress.equals(that.ipAddress) : that.ipAddress != null)
            return false;

        return true;
    }

    public int hashCode() {
        int result;
        result = (domainName != null ? domainName.hashCode() : 0);
        result = 31 * result + (ipAddress != null ? ipAddress.hashCode() : 0);
        return result;
    }
}
