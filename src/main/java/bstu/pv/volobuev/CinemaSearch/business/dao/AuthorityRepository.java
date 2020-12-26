package bstu.pv.volobuev.CinemaSearch.business.dao;

import bstu.pv.volobuev.CinemaSearch.business.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    Authority getAuthorityByName(String authorityName);
}
