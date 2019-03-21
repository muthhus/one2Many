package org.telekomatrix.data.service.Simple.data.Service.request;

import java.util.Date;
import java.util.List;

public class DnsEntryVO {
	
	private String id;
	
	private List<DomainNameVO> domainName;
	
	private List<IpAddressVO> ipAddress;
	
	private Date timestamp;

	public DnsEntryVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}



	public DnsEntryVO(String id, List<DomainNameVO> domainName, List<IpAddressVO> ipAddress, Date timestamp) {
		super();
		this.id = id;
		this.domainName = domainName;
		this.ipAddress = ipAddress;
		this.timestamp = timestamp;
	}



	public List<DomainNameVO> getDomainName() {
		return domainName;
	}



	public void setDomainName(List<DomainNameVO> domainName) {
		this.domainName = domainName;
	}



	public List<IpAddressVO> getIpAddress() {
		return ipAddress;
	}



	public void setIpAddress(List<IpAddressVO> ipAddress) {
		this.ipAddress = ipAddress;
	}
	
	
	

}
