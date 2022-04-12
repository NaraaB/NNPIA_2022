package cz.upce.nnpia.validationdemo.repository;

import cz.upce.nnpia.validationdemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
