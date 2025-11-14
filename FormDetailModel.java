package test.demo;

import java.util.ArrayList;
import java.util.List;

public class FormDetailModel {
	
	private String url;
	
	private String id;

	
	private  List<FieldDetails> fieldDetails = new ArrayList<>();
	

	public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
    	this.url = url;
    	
    }
	
	
	public List<FieldDetails> getfieldDetils(){
		return fieldDetails;
		
	}
	
	public void setfieldDetails(List<FieldDetails> fieldDetails) {
	 this.fieldDetails = fieldDetails;

	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

}
