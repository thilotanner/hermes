package models;

import com.google.code.morphia.annotations.Id;
import org.bson.types.ObjectId;

public class Configuration {

    @Id
    public ObjectId id;

    public String name;
}
