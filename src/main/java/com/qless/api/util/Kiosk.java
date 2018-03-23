package com.qless.api.util;

import javax.xml.bind.annotation.XmlRootElement;

public class Kiosk {

	
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
}
