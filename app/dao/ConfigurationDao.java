package dao;

import com.google.code.morphia.dao.DAO;
import models.Configuration;
import org.bson.types.ObjectId;

public interface ConfigurationDAO extends DAO<Configuration, ObjectId> {
}
