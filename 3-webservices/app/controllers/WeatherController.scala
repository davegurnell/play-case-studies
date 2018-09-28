package controllers

import javax.inject.Inject
import play.api._
import play.api.Play.current
import play.api.libs.json._
import play.api.libs.ws._
import play.api.mvc._
import play.twirl.api.Html
import scala.concurrent._
import scala.concurrent.duration._
import models._

class WeatherController @Inject() (
  val controllerComponents: ControllerComponents,
  val ws: WSClient
)(
  implicit
  val ec: ExecutionContext
) extends BaseController {
  def apiKey: String =
    ??? // TODO: You'll have to sign up for an API key at http://openweathermap.org

  def index = Action { request =>
    Ok(Json.toJson(List(
      "Birmingham",
      "Brighton",
      "London",
      "Worthing"
    )))
  }

  def report(location: String) =
    Action.async { request =>
      val weather  = fetchWeather(location)
      val forecast = fetchForecast(location)
      for {
        weather  <- weather
        forecast <- forecast
      } yield Ok(Json.toJson(Report(location, weather, forecast)))
    }

  def fetchWeather(location: String): Future[Weather] =
    fetch[Weather]("weather", location)

  def fetchForecast(location: String): Future[Forecast] =
    fetch[Forecast]("forecast", location)

  def fetch[A: Reads](endpoint: String, location: String): Future[A] =
    ws.url(s"http://api.openweathermap.org/data/2.5/$endpoint?q=$location,uk&appid=$apiKey")
      .withFollowRedirects(true)
      .withRequestTimeout(500.milliseconds)
      .get()
      .map(_.json.as[A]) // TODO: No error handling here! D:
}
