package com.example.chattapppp.user;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
    private final UserRepository repository;
   
	public UserService(UserRepository repository) {
        this.repository = repository;
    }
    public void saveUser(User user) {
        user.setStatus(Status.ONLINE);
        repository.save(user);
    }

    public void disconnect(User user) {
        var storedUser = repository.findById(user.getNickName()).orElse(null);
        if (storedUser != null) {
            storedUser.setStatus(Status.OFFLINE);
            repository.save(storedUser);
        }
    }

    public List<User> findConnectedUsers() {
        return repository.findAllByStatus(Status.ONLINE);
    }
}
