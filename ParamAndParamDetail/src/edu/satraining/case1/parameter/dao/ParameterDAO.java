package edu.satraining.case1.parameter.dao;

import java.sql.SQLException;
import java.util.List;

import edu.satraining.case1.dao.BaseDAO;
import edu.satraining.case1.parameter.model.Parameter;

public interface ParameterDAO extends BaseDAO{
	int insert(Parameter parameter) throws SQLException;
	int update(Parameter parameter) throws SQLException;
	int delete(Parameter parameter) throws SQLException;
	int deleteChild(Parameter parameter) throws SQLException;
	List<Parameter> search() throws SQLException;
	Parameter findById(String paramCode) throws SQLException;
}	
