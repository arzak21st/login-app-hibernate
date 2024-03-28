package dev.arzak21st.loginapp.repositories;

import dev.arzak21st.loginapp.models.User;
import dev.arzak21st.loginapp.utilities.SessionFactoryUtility;
import org.hibernate.Session;

public class RemoveRepository extends SessionFactoryUtility {

    /* ========== VARIABLES ========== */
    User user;

    boolean userIsRemoved;

    Session session;

    /* ========== METHODS ========== */
    public boolean removeUserById(Integer userId) {

        userIsRemoved = false;
        session = null;

        try {

            session = getSessionFactory().openSession();
            session.beginTransaction();

            user = session.get(User.class, userId);

            session.remove(user);
            session.getTransaction().commit();

            userIsRemoved = true;
        }
        catch(Exception exception) {
            userIsRemoved = false;
        }
        finally {
            session.close();
        }
        
        return userIsRemoved;
    }
}
