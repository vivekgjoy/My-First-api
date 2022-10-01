package com.vivek.app.Rest.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vivek.app.Rest.User.User;

public interface Repo extends JpaRepository<User, Long>{

}
