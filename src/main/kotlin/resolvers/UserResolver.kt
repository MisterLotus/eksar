package com.eksar.resolvers

import com.coxautodev.graphql.tools.GraphQLResolver
import com.eksar.database.UserFriendRepository
import com.eksar.database.UserRepository
import com.eksar.model.GraphQlDate
import com.eksar.model.UserModel
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.time.LocalDate
import java.util.*

@Component
class UserResolver @Autowired constructor(
  var userRepository: UserRepository,
  var userFriendRepository: UserFriendRepository
) : GraphQLResolver<UserModel>  {

 /* Property - friend or resolver possible methods:
  friends()
  getFriends()*/
  fun getFriends(userModel: UserModel):List<UserModel>{
   return userFriendRepository.getAllByUserId(userModel.userId)
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
  fun getCurrentDate(userModel: UserModel): LocalDate {
    return LocalDate.now()
  }
}