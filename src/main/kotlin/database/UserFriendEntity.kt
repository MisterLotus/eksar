package com.eksar.database

import javax.persistence.*

@Entity
@Table(name = "user_friend")
class UserFriendEntity constructor(

) {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false, unique = true)
  var id:Long = 0L
  @Column(name = "user_id", nullable = false)
  var userId: Long = 0L
  @Column(name = "user_friend_id", nullable = false)
  var userFriendId: Long = 0L
}

