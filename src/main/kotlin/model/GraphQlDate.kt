package com.eksar.model

import graphql.language.StringValue
import graphql.schema.Coercing
import graphql.schema.GraphQLScalarType
import org.springframework.stereotype.Component
import java.time.LocalDate
import java.time.format.DateTimeFormatter

/**
 * constructor.
 */
@Component
class GraphQlDate : GraphQLScalarType("Date", "Date", object : Coercing<LocalDate, String> {

  internal var dateFormat = DateTimeFormatter.ISO_LOCAL_DATE

  override fun serialize(input: Any): String? {
    return if (input is LocalDate) {
      dateFormat.format(input)
    } else {
      null
    }
  }

  override fun parseValue(input: Any): LocalDate? {
    return if (input is String) {
      LocalDate.from(dateFormat.parse(input))
    } else null
  }

  override fun parseLiteral(input: Any): LocalDate? {
    return if (input is StringValue) {
      LocalDate.from(dateFormat.parse(input.value))
    } else null
  }
})
