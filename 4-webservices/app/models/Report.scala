package models

import play.api.libs.json._

case class Report(
  location: String,
  weather: Weather,
  forecast: Forecast,
)

object Report {
  implicit val writes: OWrites[Report] =
    Json.writes[Report]
}