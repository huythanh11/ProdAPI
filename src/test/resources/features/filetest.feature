Feature: Verify Testcase no 2

  @test
  Scenario: Verify testcase no 2
    Given I perform GET API for "/posts"
    And I run  GET for the post number "1"
    Then I run see author name as "XXX"
