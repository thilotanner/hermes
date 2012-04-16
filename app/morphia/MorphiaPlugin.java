package morphia;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.mongodb.Mongo;
import play.Application;
import play.Plugin;

public class MorphiaPlugin extends Plugin {

    private static final String MONGO_HOST_KEY_NAME = "morphia.mongo.host";
    private static final String MORPHIA_DATABASE_KEY_NAME = "morphia.database.name";

    private Application application;

    private Mongo mongo;

    private Datastore datastore;

    public MorphiaPlugin(Application application) {
        this.application = application;
    }

    @Override
    public boolean enabled() {
        return application.configuration().keys().contains(MONGO_HOST_KEY_NAME) &&
               application.configuration().keys().contains(MORPHIA_DATABASE_KEY_NAME);
    }

    @Override
    public void onStart() {
        try {
            String mongoHost = application.configuration().getString(MONGO_HOST_KEY_NAME);
            mongo = new Mongo(mongoHost);
            Morphia morphia = new Morphia();
            String databaseName = application.configuration().getString(MORPHIA_DATABASE_KEY_NAME);
            datastore = morphia.createDatastore(mongo, databaseName);
        } catch (Exception e) {
            throw new RuntimeException("Error while starting Morphia plugin", e);
        }
    }

    @Override
    public void onStop() {
        mongo.close();
    }

    public Datastore getDatastore() {
        if(datastore == null) {
            throw new IllegalStateException("Morphia not started");
        }
        return datastore;
    }
}

