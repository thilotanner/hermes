package modules;

import com.google.code.morphia.Datastore;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import dao.ConfigurationDAO;
import dao.morphia.ConfigurationDAOImpl;
import morphia.MorphiaPlugin;
import play.Logger;
import play.Play;

public class DAOModule extends AbstractModule {

    @Override
    protected void configure() {
        try {
            bind(ConfigurationDAO.class).toConstructor(ConfigurationDAOImpl.class.getConstructor(Datastore.class));
        } catch (NoSuchMethodException e) {
            Logger.error("Error while creating service", e);
        }
    }

    @Provides
    Datastore provideDatastore() {
        MorphiaPlugin morphiaPlugin = Play.application().plugin(MorphiaPlugin.class);
        return morphiaPlugin.getDatastore();
    }
}
