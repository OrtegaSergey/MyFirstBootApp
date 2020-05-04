package ru.ortega.myTodoList.persist.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.ortega.myTodoList.persist.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
