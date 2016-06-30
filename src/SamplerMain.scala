import domain.{User, UserView}
import services.UserOps

/**
  * Created by vdias on 30-06-2016.
  */
object SamplerMain extends App {
  println("Test stuff")


  // use case:
  //  A resource can usually be uniquely identified by
  //  more than one identifier type, for example we always have
  //  around the internal ID of a resource and the External ID.
  //
  //  Now having that we also usually have a bunch of different case
  //  classes about some Resource when in different states. Example,
  //  a User usually has a User.Full (represents everything about it),
  //  a UserView (frontend), a UserCreate, a UserEdit, etc.
  //
  //  So, would be nice if we could have for example a generic
  //  requirement of a findUser function that could extract one of
  //  the identifiers for all the case classes that represent a User in the
  //  system, so we could interchange any of those values without implementing
  //  extra code.

  val x1 = UserOps.findUser(User(5, "somebody USER"))
  val x2 = UserOps.findUser(UserView("somebody USER VIEW"))
  val x3 = UserOps.findUser("somebody RAW")

  println(x1)
  println(x2)
  println(x3)
}
