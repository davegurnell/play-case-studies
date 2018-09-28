package controllers

import org.scalatestplus.play._
import play.api.inject.guice._
import play.api.mvc._
import play.api.test._
import play.api.test.Helpers._
import scala.concurrent._

class ApplicationSpec extends PlaySpec with Results {
  val injector = new GuiceApplicationBuilder()
    .injector

  val appController = injector.instanceOf[AppController]

  "AppController" must {
    "respond with a friendly message" in {
      val result: Future[Result] =
        appController.index().apply(FakeRequest())

      val bodyText: String =
        contentAsString(result)

      bodyText must startWith("Hello")
    }
  }
}
