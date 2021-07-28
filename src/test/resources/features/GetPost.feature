Feature: Verify different GET operations using REST-assured

  @test
  Scenario: Verify one author of the post
    Given I perform GET API for "/posts"
    And I perform GET for the post number "1"
    Then I should see author name as "XXX"



  @test
  Scenario: Verify XXXXXX
    Given I perform GET API for "/posts"
    And I perform GET for the post number "1"
    Then I should see author name as "XXX"