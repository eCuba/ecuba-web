package com.ecuba.solr.repository;

import com.ecuba.domain.User;
import org.springframework.data.solr.repository.SolrCrudRepository;

/**
 * Created by rolando on 2014-08-25.
 */
public interface IUserRepository extends SolrCrudRepository<User,String> {
}
