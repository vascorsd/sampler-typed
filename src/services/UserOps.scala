package services

import behaviours.Fetchable
import domain.User

/**
  * Created by vdias on 30-06-2016.
  */
object UserOps {
  def findUser[A](o: A)(implicit ev: Fetchable[A, User]): User = {
    Fetchable[A, User].fetch(o)
  }
}
