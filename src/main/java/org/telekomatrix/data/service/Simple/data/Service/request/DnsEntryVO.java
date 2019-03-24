package org.telekomatrix.data.service.Simple.data.Service.request;

import java.util.Date;
import java.util.List;

public class DnsEntryVO {
	
	private String id;
	
	private DomainNameVO domainName;
	
	private IpAddressVO ipAddress;
	
	private Long timestamp;
	
	private String requestSourceType;

	public DnsEntryVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DnsEntryVO(String id, DomainNameVO domainName, IpAddressVO ipAddress, Long timestamp,
			String requestSourceType) {
		super();
		this.id = id;
		this.domainName = domainName;
		this.ipAddress = ipAddress;
		this.timestamp = timestamp;
		this.requestSourceType = requestSourceType;
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

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		Date date = new Date();
		this.timestamp = date.getTime();
	}

	public String getRequestSourceType() {
		return requestSourceType;
	}

	public void setRequestSourceType(String requestSourceType) {
		this.requestSourceType = requestSourceType;
	}

	
	

}
