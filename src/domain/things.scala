package domain

case class User(id: Int, externalId: String)
case class UserView(externalId: String)

case class Client(id: Int, externalId: String)
case class Account(id: Int, externalId: String)


