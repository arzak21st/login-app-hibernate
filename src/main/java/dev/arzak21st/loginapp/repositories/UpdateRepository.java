package dev.arzak21st.loginapp.repositories;

import dev.arzak21st.loginapp.models.User;
import dev.arzak21st.loginapp.models.UserCredential;
import dev.arzak21st.loginapp.utilities.SessionFactoryUtility;
import org.hibernate.Session;

public class UpdateRepository extends SessionFactoryUtility {

    /* ========== VARIABLES ========== */
    boolean userIsUpdated;
    boolean passwordIsUpdated;

    Session session;

    /* ========== METHODS ========== */
    public boolean updateUser(User user) {

        userIsUpdated = false;
        session = null;

        try {

            session = getSessionFactory().openSession();
            session.beginTransaction();

            User newUser = session.get(User.class, user.getUserId());
            newUser.setFirstName(user.getFirstName());
            newUser.setLastName(user.getLastName());
            newUser.setDateOfBirth(user.getDateOfBirth());
            newUser.setGender(user.getGender());
            newUser.setCountry(user.getCountry());

            session.merge(newUser);
            session.getTransaction().commit();

            userIsUpdated = true;
        }
        catch(Exception exception) {
            userIsUpdated = false;
        }
        finally {
            session.close();
        }

        return userIsUpdated;
    }

    public boolean updatePassword(String newPassword, Integer userId) {

        passwordIsUpdated = false;
        session = null;

        try {

            session = getSessionFactory().openSession();
            session.beginTransaction();

            UserCredential newUserCredential = session.get(UserCredential.class, userId);
            newUserCredential.setPassword(newPassword);

            session.merge(newUserCredential);
            session.getTransaction().commit();

            passwordIsUpdated = true;
        }
        catch(Exception exception) {
            passwordIsUpdated = false;
        }
        finally {
            session.close();
        }
        
        return passwordIsUpdated;
    }
}
