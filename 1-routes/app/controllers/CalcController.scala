package controllers

import play.api._
import play.api.mvc._
import javax.inject.Inject

class CalcController @Inject() (val controllerComponents: ControllerComponents) extends BaseController {
  def add(a: Int, b: Int) = Action { request =>
    Ok((a + b).toString)
  }

  def and(a: Boolean, b: Boolean) = Action { request =>
    Ok((a && b).toString)
  }

  def concat(args: String) = Action { request =>
    Ok(args.split("/").map(decode).mkString)
  }

  def sort(numbers: List[Int]) = Action { request =>
    Ok(numbers.sorted mkString " ")
  }

  def howToAdd(a: Int, b: Int) = Action { request =>
    val call = routes.CalcController.add(a, b)
    Ok(call.method + " " + call.url)
  }

  private def decode(str: String) =
    java.net.URLDecoder.decode(str, "UTF-8")
}
