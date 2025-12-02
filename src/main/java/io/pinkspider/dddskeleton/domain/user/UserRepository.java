package io.pinkspider.dddskeleton.domain.user;

public interface UserRepository {
    User findById(Long id);
    void save(User user);
}
