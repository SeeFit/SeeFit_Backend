package com.carespoon.Repository;

import com.carespoon.domain.User;
import com.carespoon.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {
    UserInfo findByUser(User user);
}
