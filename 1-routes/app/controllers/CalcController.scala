package controllers

import play.api._
import play.api.mvc._
import javax.inject.Inject

class CalcController @Inject() (val controllerComponents: ControllerComponents) extends BaseController {
  // TODO:
  // Write action methods for the routes in the routes file (also listed below).
  //
  // GET /add/:a/to/:b       controllers.CalcController.add(a: Int, b: Int)
  // GET /and/:a/with/:b     controllers.CalcController.and(a: Boolean, b: Boolean)
  // GET /concat/*args       controllers.CalcController.concat(args: String)
  // GET /sort               controllers.CalcController.sort(num: List[Int])
  // GET /howto/add/:a/to/:b controllers.CalcController.howToAdd(a: Int, b: Int)
  //
  // HINT:
  // Write the methods one at a time.
  // Get each working before moving on to the next.

  private def decode(str: String) =
    java.net.URLDecoder.decode(str, "UTF-8")
}
