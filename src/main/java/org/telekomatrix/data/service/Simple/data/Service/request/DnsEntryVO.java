package org.telekomatrix.data.service.Simple.data.Service.request;

import java.util.Date;

public class DnsEntryVO {
	
	private String id;
	
	private DomainNameVO domainName;
	
	private IpAddressVO ipAddress;
	
	private Date timestamp;

	public DnsEntryVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DnsEntryVO(String id, DomainNameVO domainName, IpAddressVO ipAddress, Date timestamp) {
		super();
		this.id = id;
		this.domainName = domainName;
		this.ipAddress = ipAddress;
		this.timestamp = timestamp;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public DomainNameVO getDomainName() {
		return domainName;
	}

	public void setDomainName(DomainNameVO domainName) {
		this.domainName = domainName;
	}

	public IpAddressVO getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(IpAddressVO ipAddress) {
		this.ipAddress = ipAddress;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
	
	

}
