package socialNetworkingService.repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import socialNetworkingService.model.*;

public class UserRepository {
    private static final UserRepository INSTANCE = new UserRepository();
    private final Map<String, User> users = new ConcurrentHashMap<>();

    private UserRepository() {}

    public static UserRepository getInstance() {
        return INSTANCE;
    }

    public void save(User user) {
        users.put(user.getId(), user);
    }

    public User findById(String id) {
        return users.get(id);
    }
    
}
