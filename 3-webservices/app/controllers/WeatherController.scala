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
)(implicit val ec: ExecutionContext) extends BaseController {
  // TODO:
  // Make this WeatherController operational in the following steps:
  //
  // 1. Use the WSClient injected in the constructor above to
  //    call out to the Open Weather Map API and fetch
  //    the forecast/location for the relevant town
  //
  // 2. Create case classes representing Weather and Forecast data.
  //    Include at least three interesting fields from each source.
  //    Bonus points for including at least one field
  //    with its own internal structure.
  //
  // 3. Write appropriate JSON formats for parsing the incoming JSON.
  //
  // 4. (OPTIONAL) If you have time, perform some kind of
  //    interesting operation on the data as it comes through.
  //    Perhaps convert temperatures to farenheight,
  //    or calculate highs and lows from the series of values in the forecast.

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

  def fetchWeather(location: String): Future[JsValue] =
    // TODO: Rewrite me
    Future.successful(JsNull)

  def fetchForecast(location: String): Future[JsValue] =
    // TODO: Rewrite me
    Future.successful(JsNull)
}
