package ecommerce.ecommerce.config;

import ecommerce.ecommerce.repoitory.Repo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomerUserDetailService implements UserDetailsService {

   private final Repo repo;
   public CustomerUserDetailService(Repo repo){
       this.repo=repo;
   }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return repo.findByEmail(username);
    }
}
