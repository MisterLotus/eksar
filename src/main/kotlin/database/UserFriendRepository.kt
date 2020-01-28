package com.eksar.database

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


interface UserFriendRepository : JpaRepository<UserFriendEntity, Long> {
  fun getAllByUserId(userId: Long): List<UserFriendEntity>
}