package org.telekomatrix.data.service.Simple.data.Service.request;

import java.util.List;

public class DomainNameVO {

	private String id;
	
	private String domainName;
	
	private List<DnsEntryVO> dnsEntryList;

	public DomainNameVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DomainNameVO(String id, String domainName, List<DnsEntryVO> dnsEntryList) {
		super();
		this.id = id;
		this.domainName = domainName;
		this.dnsEntryList = dnsEntryList;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDomainName() {
		return domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	public List<DnsEntryVO> getDnsEntryList() {
		return dnsEntryList;
	}

	public void setDnsEntryList(List<DnsEntryVO> dnsEntryList) {
		this.dnsEntryList = dnsEntryList;
	}
	
	
}
