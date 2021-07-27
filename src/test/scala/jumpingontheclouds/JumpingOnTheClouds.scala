package jumpingontheclouds

import org.scalatest.{FunSuite, Matchers}

class JumpingOnTheClouds extends FunSuite with Matchers {

  test("jumpingOnClouds 0 0 0 0 1 0 should be 3") {
    Result.jumpingOnClouds(Array(0,0,0,0,1,0)) should be (3)
  }
  test("jumpingOnClouds 0 0 1 0 0 1 0 should be 4") {
    Result.jumpingOnClouds(Array(0,0,1,0,0,1,0)) should be (4)
  }

  test("jumpingOnClouds 0 0 0 1 0 0 should be 3") {
    Result.jumpingOnClouds(Array(0,0,0,1,0,0)) should be (3)
  }

  test("jumpingOnClouds 0 0 1 0 0 0 0 1 0 0 should be 6") {
    Result.jumpingOnClouds(Array(0,0,1,0,0,0,0,1,0,0)) should be (6)
  }

}
