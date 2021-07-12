package by.bakhar.project.util;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordHash {
    public String generatePassword(String password) {
        String encryptPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        return encryptPassword;
    }

    public boolean checkPassword(String password, String hash) {
        boolean isCorrect = BCrypt.checkpw(password, hash);
        return isCorrect;
    }
}
