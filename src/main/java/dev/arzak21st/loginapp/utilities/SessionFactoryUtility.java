package dev.arzak21st.loginapp.utilities;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryUtility {

    /* ========== VARIABLES ========== */
    private static final String configFile = "hibernate-config.xml";
    private static final Configuration configuration = new Configuration().configure(configFile);
    private static final SessionFactory sessionFactory = configuration.buildSessionFactory();

    /* ========== METHODS ========== */
    protected static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
