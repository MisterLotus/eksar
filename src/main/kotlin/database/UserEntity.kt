package com.eksar.database

import com.eksar.model.UserModel
import javax.persistence.*

@Entity
@Table(name = "user")
class UserEntity constructor(

) {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false, unique = true)
  var userId: Long = 0L

  @Column(name = "name", nullable = false, length = 50)
  var name: String = ""

  @Column(name = "email", nullable = false, length = 50)
  var email: String = ""

  @Column(name = "special_info", nullable = true, length = 50)
  var specialInfo: String = ""
}