package com.lzh.template.repository;

import com.lzh.template.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 用户仓库
 */
public interface UserRepository extends JpaRepository<User, Integer>
{
}
