package model;

import java.sql.SQLException;
import java.util.List;

/**
 * <h1>The Interface IModel.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public interface IModel {
	
	
    Example getExampleById(int id) throws SQLException;

    Example getExampleByName(String name) throws SQLException;

    List<Example> getAllExamples() throws SQLException;
}
