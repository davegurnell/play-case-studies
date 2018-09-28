package controllers

import play.api._
import play.api.mvc._
import play.api.libs.Files._
import play.api.libs.json._
import javax.inject.Inject
import scala.xml._

class PostController @Inject() (val controllerComponents: ControllerComponents) extends BaseController {
  def any = Action { request =>
    val body: Option[String] =
      request.body.asText

    Ok(body.getOrElse("Nope"))
  }

  def json = Action(parse.json) { request =>
    val body: JsValue =
      request.body

    Ok(body)
  }

  def form = Action(parse.formUrlEncoded) { request =>
    val body: Map[String, Seq[String]] =
      request.body

    Ok(body.map { pair =>
      val (key, values) = pair
      val indent = " " * key.length
      key + " => " + values.mkString(indent + " => ")
    }.mkString)
  }

  def multipart = Action(parse.multipartFormData) { request =>
    val body: MultipartFormData[TemporaryFile] =
      request.body

    Ok {
      s"""
      |Multipart body posted:
      | - ${body.dataParts.size} form data keys
      | - ${body.files.length} files
      """.trim.stripMargin
    }
  }
}
