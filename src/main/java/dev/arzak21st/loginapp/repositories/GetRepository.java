package dev.arzak21st.loginapp.repositories;

import dev.arzak21st.loginapp.models.User;
import dev.arzak21st.loginapp.models.UserCredential;
import dev.arzak21st.loginapp.utilities.SessionFactoryUtility;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class GetRepository extends SessionFactoryUtility {

    /* ========== VARIABLES ========== */
    User user;
    UserCredential userCredential;

    Integer lastSavedUserId;
    boolean userCredentialExists;

    Session session;

    /* ========== METHODS ========== */
    public Integer getLastSavedUserId() {

        lastSavedUserId = null;
        session = null;

        try {

            session = getSessionFactory().openSession();

            String hqlQuery = "SELECT MAX(userId) FROM User";
            Query query = session.createQuery(hqlQuery);

            lastSavedUserId = (Integer) query.uniqueResult();
        }
        catch(Exception exception) {
            lastSavedUserId = null;
        }
        finally {
            session.close();
        }

        return lastSavedUserId;
    }

    public User getUserById(Integer userId) {

        user = null;
        session = null;

        try {

            session = getSessionFactory().openSession();

            user = session.get(User.class, userId);
        }
        catch(Exception exception) {
            user = null;
        }
        finally {
            session.close();
        }

        return user;
    }

    public UserCredential getUserCredentialById(Integer userId) {

        userCredential = null;
        session = null;

        try {

            session = getSessionFactory().openSession();

            userCredential = session.get(UserCredential.class, userId);
        }
        catch(Exception exception) {
            userCredential = null;
        }
        finally {
            session.close();
        }

        return userCredential;
    }

    public UserCredential getUserCredentialByEmail(String email) {

        userCredential = null;
        session = null;

        try {

            session = getSessionFactory().openSession();

            String hqlQuery = "FROM UserCredential WHERE email = ?1";
            Query query = session.createQuery(hqlQuery);
            query.setParameter(1, email);

            userCredential = (UserCredential) query.uniqueResult();
        }
        catch(Exception exception) {
            userCredential = null;
        }
        finally {
            session.close();
        }

        return userCredential;
    }

    public UserCredential getUserCredentialByEmailAndPassword(String email, String password) {

        userCredential = null;
        session = null;

        try {

            session = getSessionFactory().openSession();

            String hqlQuery = "FROM UserCredential WHERE email = ?1 AND password = ?2";
            Query query = session.createQuery(hqlQuery);
            query.setParameter(1, email);
            query.setParameter(2, password);

            userCredential = (UserCredential) query.uniqueResult();
        }
        catch(Exception exception) {
            userCredential = null;
        }
        finally {
            session.close();
        }

        return userCredential;
    }

    public UserCredential getUserCredentialByUsernameOrEmail(String username, String email) {

        userCredential = null;
        session = null;

        try {

            session = getSessionFactory().openSession();

            String hqlQuery = "FROM UserCredential WHERE username = ?1 OR email = ?2";
            Query query = session.createQuery(hqlQuery);
            query.setParameter(1, username);
            query.setParameter(2, email);

            userCredential = (UserCredential) query.uniqueResult();
        }
        catch(Exception exception) {
            userCredential = null;
        }
        finally {
            session.close();
        }

        return userCredential;
    }

    public boolean getUserCredentialByIdAndPassword(Integer userId, String password) {

        userCredentialExists = false;
        session = null;

        try {

            session = getSessionFactory().openSession();

            String hqlQuery = "FROM UserCredential WHERE userId = ?1 AND password = ?2";
            Query query = session.createQuery(hqlQuery);
            query.setParameter(1, userId);
            query.setParameter(2, password);

            UserCredential userCredential = (UserCredential) query.uniqueResult();

            if(userCredential != null) {
                userCredentialExists = true;
            }
        }
        catch(Exception exception) {
            userCredentialExists = false;
        }
        finally {
            session.close();
        }

        return userCredentialExists;
    }
}
