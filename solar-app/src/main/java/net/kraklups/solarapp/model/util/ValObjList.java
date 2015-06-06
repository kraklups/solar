package net.kraklups.solarapp.model.util;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ValObjList {
	
	@JsonProperty("_embedded")
	private List<ValueObject> valObj;

	public List<ValueObject> getValObj() {
		return valObj;
	}

	public void setValObj(List<ValueObject> valObj) {
		this.valObj = valObj;
	}
	
}
