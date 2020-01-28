package com.eksar.resolvers

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.eksar.database.UserFriendRepository
import com.eksar.database.UserRepository
import com.eksar.model.MultiUserSearch
import com.eksar.model.UserModel
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.util.*

@Component
class QueryResolver @Autowired constructor(
  var userRepository: UserRepository,
  var userFriendRepository: UserFriendRepository
) : GraphQLQueryResolver {

  fun getUserById(userId: Long): Optional<UserModel> {
    return userRepository.findById(userId).map {
      return@map UserModel(
        userId = it.userId,
        email = it.email,
        name = it.name,
        specialInfo = it.specialInfo
      )
    }
  }

  fun getUserFriends(userId: Long): List<UserModel> {
    return userFriendRepository.getAllByUserId(userId)
      .map {
        return@map userRepository.findById(it.userFriendId).map {
          return@map UserModel(
            userId = it.userId,
            email = it.email,
            name = it.name,
            specialInfo = it.specialInfo
          )
        }.orElseThrow { Exception("Unable to load userFriend, may be friend not exists?") }
      }
  }

  fun getAllUsers(): List<UserModel> {
    return userRepository.findAll().map {
      return@map UserModel(
        userId = it.userId,
        email = it.email,
        name = it.name,
        specialInfo = it.specialInfo
      )
    }
  }

  fun getAllByIdList(input: MultiUserSearch): List<UserModel>{
    return input.idList.map {
      return@map userRepository.findById(it).map {
        return@map UserModel(
          userId = it.userId,
          email = it.email,
          name = it.name,
          specialInfo = it.specialInfo
        )
      }.orElse(null)
    }
  }
}