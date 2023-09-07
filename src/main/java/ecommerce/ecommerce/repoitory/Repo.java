package ecommerce.ecommerce.repoitory;

import ecommerce.ecommerce.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface Repo extends JpaRepository<User, Long> {
    UserDetails findByEmail(String email);
}
