package br.edu.fatecfranca.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.edu.fatecfranca.api.dtos.UserRequest;
import br.edu.fatecfranca.api.entities.User;
import br.edu.fatecfranca.api.repositories.UserRepository;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    private void copyToEntity(UserRequest request, User user) {
        user.setName(request.name());
        user.setEmail(request.email());
        user.setPassword(request.password());
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public Optional<User> findById(Long id) {
        return repository.findById(id);
    }

    public User create(UserRequest request) {
        User user = new User();
        copyToEntity(request, user);
        return repository.save(user);
    }

    public User update(Long id, UserRequest request) {
        User user = new User();
        copyToEntity(request, user);
        user.setId(id);
        return repository.save(user);
    }

    public boolean existsById(Long id) {
        return repository.existsById(id);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}