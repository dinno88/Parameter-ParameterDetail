package edu.satraining.case1.parameter;
import java.util.List;

import edu.satraining.casel.parameter.model.Parameter; 
import edu.satraining.casel.parameter.model.ParameterDetail; 
import edu.satraining.casel.utility.ServiceException;

public interface ParameterService
{
	int addParameter(Parameter parameter) throws ServiceException; 
	int updateParameter(Parameter parameter) throws ServiceException; 
	int deleteParameter(Parameter parameter) throws ServiceException; 
	List<Parameter> searchParameter() throws ServiceException; 
	Parameter findById(String paramCode) throws ServiceException;
	ParameterDetail findDetailById(String detailCode) throws ServiceException; 
	List<ParameterDetail> getChild(Parameter parameter) throws ServiceException;
}
