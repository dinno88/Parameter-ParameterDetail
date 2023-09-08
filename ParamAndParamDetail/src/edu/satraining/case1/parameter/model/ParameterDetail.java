package edu.satraining.case1.parameter.model;

import java.util.Date;

public class ParameterDetail extends BaseModel {
	private String detailCode;
	private String detailName;
	private Parameter parameter;
	private String detailValue;
	
	public ParameterDetail() {
		super();
	}
	public ParameterDetail(String detailCode) {
		this.detailCode = detailCode;
	}
	public ParameterDetail(String detailCode, String detailName, Parameter parameter, String detailValue) {
		super();
		this.detailCode = detailCode;
		this.detailName = detailName;
		this.parameter = parameter;
		this.detailValue = detailValue;
	}
	public ParameterDetail(String detailCode, String detailName, Parameter parameter, String detailValue, String createdBy, Date createdTime, String updatedBy, Date updatedTime) {
		super(createdBy, createdTime, updatedBy, updatedTime);
		this.detailCode = detailCode;
		this.detailName = detailName;
		this.parameter = parameter;
		this.detailValue = detailValue;
	}
	public ParameterDetail(String detailCode, String detailName, Parameter parameter, String detailValue, String createdBy, Date createdTime) {
		super(createdBy, createdTime);
		this.detailCode = detailCode;
		this.detailName = detailName;
		this.parameter = parameter;
		this.detailValue = detailValue;
	}
	
	public String getDetailCode() {
		return detailCode;
	}
	public void setDetailCode(String detailCode) {
		this.detailCode = detailCode;
	}
	
	public String getDetailName() {
		return detailName;
	}
	public void setDetailName(String detailName) {
		this.detailName = detailName;
	}
	
	public Parameter getParameter() {
		return parameter;
	}
	public void setParameter(Parameter parameter) {
		this.parameter = parameter;
	}
	
	public String getDetailValue() {
		return detailValue;
	}
	public void setDetailValue(String detailValue) {
		this.detailValue = detailValue;
	}
	
	public String toString() {
		return String.format("ParameterDetail [detailCode=%s, detailName=%s, parameter=%s, detailValue=%s]", detailCode, detailName, parameter, detailValue);
	}
	public Object clone() {
		ParameterDetail cloneObject = new ParameterDetail();
		
		cloneObject.setDetailCode(detailCode);
		cloneObject.setDetailName(detailName);
		
		if(parameter != null) {
			cloneObject.setParameter((Parameter)parameter.clone());
		}
		cloneObject.setDetailValue(detailValue);
		
		return cloneObject;
	}
	
	public boolean equalsData(ParameterDetail compareObject) {
		if(this.getDetailCode().trim().equals(compareObject.getDetailCode().trim())&&
				this.getDetailName().trim().equals(compareObject.getDetailName().trim())&&
				this.getDetailValue().trim().equals(compareObject.getDetailValue().trim())&&
				this.getParameter().getParamCode().trim().equals(compareObject.getParameter().getParamCode().trim())){
					return true;
				}
		return false;
	
	}
	
}
