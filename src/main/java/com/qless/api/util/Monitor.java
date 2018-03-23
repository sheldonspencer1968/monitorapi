package com.qless.api.util;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Monitor {

	String userid;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

}
