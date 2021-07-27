package salesbymatch

import org.scalatest.{FunSuite, Matchers}

class SalesByMatchTest extends FunSuite with Matchers {

  test("sockMerchant 10 20 20 10 10 30 50 10 20 should be 3") {
    Result.sockMerchant(9, Array(10,20,20,10,10,30,50,10,20)) should be (3)
  }
}
