package com.impostercorp.signuptest.repositories;

import com.impostercorp.signuptest.models.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * Created by sayeedm on 12/18/17.
 */
public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long>{
    VerificationToken findByToken(String token);
}
