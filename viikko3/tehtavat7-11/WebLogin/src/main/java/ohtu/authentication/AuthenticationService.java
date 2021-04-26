package ohtu.authentication;

import ohtu.data_access.UserDao;
import ohtu.domain.User;
import ohtu.util.CreationStatus;

public class AuthenticationService {

    private UserDao userDao;

    public AuthenticationService(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean logIn(String username, String password) {
        for (User user : userDao.listAll()) {
            if (user.getUsername().equals(username)
                    && user.getPassword().equals(password)) {
                return true;
            }
        }

        return false;
    }

    public CreationStatus createUser(String username, String password, String passwordConfirmation) {
        CreationStatus status = new CreationStatus();
        char[] name = username.toCharArray();
        char[] pass = password.toCharArray();
        
        if (userDao.findByName(username) != null) {
            status.addError("username is already taken");
        }

        if (username.length()<3 ) {
            status.addError("username should have at least 3 characters");
        }
        
        if (password.length() < 8) {
            status.addError("password should have at least 8 characters");
        }
        
        if(!password.equals(passwordConfirmation)) {
            status.addError("password and password confirmation do not match");
        }
        
        for (char c : name) {
            if(!Character.isLetter(c)) {
                status.addError("password should only contain letters a-z");
                break;
            }
        }
        int i = 0;
        for (char c : pass) {
            if(!Character.isLetter(c)) {
                i++;
                break;
            }
        }
        if (i == 0) {
            status.addError("password should contain at least one non-letter character");
        }

        if (status.isOk()) {
            userDao.add(new User(username, password));
        }
        
        return status;
    }

}
