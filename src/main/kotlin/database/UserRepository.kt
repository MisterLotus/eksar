package com.eksar.database

import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository  : JpaRepository<UserEntity, Long>