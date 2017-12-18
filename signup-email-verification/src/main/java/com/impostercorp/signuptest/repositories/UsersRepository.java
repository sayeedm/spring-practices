package com.impostercorp.signuptest.repositories;

import com.impostercorp.signuptest.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * Created by sayeedm on 12/17/17.
 */
@SuppressWarnings( { "SpellCheckingInspection", "unused" })
public interface UsersRepository extends JpaRepository<User, String>{
}
