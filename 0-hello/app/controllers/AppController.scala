package controllers

import play.api.Logger
import play.api.Play.current
import play.api.mvc._
import javax.inject.Inject

import models._

class AppController @Inject() (val controllerComponents: ControllerComponents) extends BaseController {
  def index = Action { request =>
    Ok("Hello world!")
  }
}
