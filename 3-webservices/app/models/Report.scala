package models

import play.api.libs.json._

// A class to hold the two responses from Open Weather Map:
// the "weather" response" and the "forecast" response.
case class Report(
  location: String,
  weather: JsValue,
  forecast: JsValue,
)

object Report {
  implicit val format: OFormat[Report] =
    Json.format[Report]
}