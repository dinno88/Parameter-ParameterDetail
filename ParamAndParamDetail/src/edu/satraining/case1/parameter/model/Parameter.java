package edu.satraining.case1.parameter.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.satraining.case1.model.BaseModel;

public class Parameter extends BaseModel{
	private String paramCode;
	private String paramName;
	private String description;
	
	List<ParameterDetail> details = new ArrayList<ParameterDetail>();
	
	public Parameter() {
		super();
	}
	
	public Parameter(String paramCode) {
		super();
		this.paramCode = paramCode;
	}
	
	public Parameter(String paramCode, String paramName, String description) {
		super();
		this.paramCode = paramCode;
		this.paramName = paramName;
		this.description = description;
	}
	public Parameter(String paramCode, String paramName, String description, String createdBy, Date createdTime, String updatedBy, Date updatedTime) {
		super(createdBy, createdTime, updatedBy, updatedTime);
		this.paramCode = paramCode;
		this.paramName = paramName;
		this.description = description;
	}
	public Parameter(String paramCode, String paramName, String description, String createdBy, Date createdTime) {
		super(createdBy, createdTime);
		this.paramCode = paramCode;
		this.paramName = paramName;
		this.description = description;
	}
	
	public String getParamCode() {
		return paramCode;
	}
	public void setParamCode(String paramCode) {
		this.paramCode = paramCode;
	}
	
	public String getParamName() {
		return paramName;
	}
	public void setParamName(String paramName) {
		this.paramName = paramName;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public List<ParameterDetail> getDetails(){
		return details;
	}
	public void setDetails(List<ParameterDetail>details) {
		this.details = details;
	}
	
	public void addDetail(ParameterDetail paramDetail) {
		details.add(paramDetail);
		paramDetail.setParameter(this);
	}
	public void removeDetail(ParameterDetail paramDetail) {
		details.remove(paramDetail);
		paramDetail.setParameter(null);
	}
	public String toString() {
		return String.format("Parameter [paramCode=%s, paramName=%s, description=%s]", paramCode, paramName, description);
	}
	
	public Object clone() {
		Parameter parameter = new Parameter();
		parameter.setParamCode(paramCode);
		parameter.setParamName(paramName);
		parameter.setDescription(description);
		
		return parameter;
	}
	public boolean equalsData(Parameter compareObject) {
		boolean result = false;
		if(this.getParamCode().trim().equals(compareObject.getParamCode().trim())&&
				this.getParamName().trim().equals(compareObject.getParamName().trim())&&
				this.getDescription().trim().equals(compareObject.getDescription().trim())) {
			result = true;
		}
		return result;
	}
	
}
