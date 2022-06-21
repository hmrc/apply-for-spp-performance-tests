/*
 * Copyright 2022 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov

import uk.gov.hmrc.Page.{ContentPage, FormPage}
import uk.gov.hmrc.performance.conf.ServicesConfiguration

import java.time.LocalDate

package object hmrc extends ServicesConfiguration {

  val baseUrl: String = baseUrlFor("apply-for-statutory-paternity-pay-frontend")
  val route: String   = "/fill-online/apply-for-statutory-paternity-pay"

  private val dobToday: LocalDate = LocalDate.now


  val journey: List[Page] = List(
    ContentPage("Navigate To Start Page", ""),
    FormPage("Becoming Adoptive Or Parental Order Parents", "becoming-adoptive-or-parental-order-parents", "value" -> "false"),
    FormPage("Are You The Child’s Biological Father?", "are-you-the-biological-father", "value" -> "true"),
    FormPage("Responsibility Caring For Child?", "will-you-have-responsibility-for-caring", "value" -> "true"),
    FormPage("Time Off Work To Care For Child?", "take-time-off-to-care-for-child", "value" -> "true"),
    FormPage("What Is Your Name?", "what-is-your-name", "firstName" -> "foo", "lastName" -> "bar"),
    FormPage("What Is Your Nino?", "what-is-your-national-insurance-number", "value" -> "AA123456A"),
    FormPage("Has The Baby Been Born Yet?", "has-the-baby-been-born", "value" -> "true"),
    FormPage("What date was the baby born?", "what-date-was-the-baby-born", fieldsForDate(dobToday): _*),
    FormPage("Statutory Paternity Pay Start On Day Baby Was Born?", "want-pay-to-start-on-birth-date", "value" -> "true"),
    FormPage("How Long Will You Be On Paternity Leave For?", "how-long-will-you-be-on-leave", "value" -> "twoWeeks"),
    ContentPage("Check Your Answers", "check-your-answers"),
    ContentPage("Next Steps Page", "next-steps"),
    ContentPage("Print Form Page", "print-form")

  )


  private def fieldsForDate(date: LocalDate): List[(String, String)] = List(
    "value.day"   -> date.getDayOfMonth.toString,
    "value.month" -> date.getMonthValue.toString,
    "value.year"  -> date.getYear.toString
  )
}
