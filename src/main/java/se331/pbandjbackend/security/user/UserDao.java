package se331.pbandjbackend.security.user;

public interface UserDao {
    User findByUsername(String username);

    User save(User user);
}