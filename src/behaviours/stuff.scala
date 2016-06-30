package behaviours

import domain.{User, UserView}

trait Identifiable[Resource, Id] {
  def id(o: Resource): Id
}

object Identifiable {
  def apply[A, B](implicit I: Identifiable[A, B]) = I

  implicit val identifiableById = new Identifiable[User, Int] {
    override def id(o: User): Int = o.id
  }

  implicit val idUserByExternalId = new Identifiable[User, String] {
    override def id(o: User): String = o.externalId
  }

  implicit val idUserViewExternalId = new Identifiable[UserView, String] {
    override def id(o: UserView): String = o.externalId
  }

  implicit val idStringExternalId = new Identifiable[String, String] {
    override def id(o: String): String = o
  }
}

trait Fetchable[Lookup, Resource] {
  def fetch(by: Lookup): Resource
}

object Fetchable {
  def apply[A, B](implicit F: Fetchable[A, B]) = F

  implicit def fetcher[A](implicit ev: Identifiable[A, String]) = new Fetchable[A, User] {
    override def fetch(by: A): User = {
      val id = Identifiable[A, String].id(by)

      User(0, id)
    }
  }

//  implicit def fetcher[A](implicit ev: Identifiable[A, Int]) = new Fetchable[A, User] {
//    override def fetch(by: A): User = {
//      val id = Identifiable[A, Int].id(by)
//
//      User(1, s"from ID: $id")
//    }
//  }
}

