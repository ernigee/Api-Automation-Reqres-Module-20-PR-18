Feature: Test Automation Rest Api

  @api
  Scenario: Test get list data normal
    Given prepare URL for "LIST_USERS_REQRESS"
    And hit api get list users
    Then validation status code is equals 200
    Then validation response body get list users
    Then validation response json with JSONSchema "getlistUserNormal.json"

  @api
  Scenario: Test create new user
    Given prepare URL for "CREATE_NEW_USER"
    And hit api post create new user
    Then validation status code is equals 201
    Then validation response body post create new user
    Then validation response json with JSONSchema "postCreateNewUser.json"

    @api
    Scenario: Test delete user
      Given prepare URL for "DELETE_USER"
      And hit api post create new user
      Then validation status code is equals 201
      Then validation response body post create new user
      And hit api delete new
      Then validation status code is equals 204

      @api
      Scenario: Test Update User
        Given prepare URL for "CREATE_NEW_USER"
        And hit api post create new user
        Then validation status code is equals 201
        Then validation response body post create new user
        And hit api update data
        Then validation status code is equals 200
        Then validation response body update user
        
        @api
        Scenario: Invalid URL for User List
          Given prepare URL for "Invalid_URL"
          And hit api get list users
          Then validation status code is equals 404
          #failed to validate >> Then validation response message indicates "Not Found"

          @api
          Scenario: Create User with Missing Fields (password)
            Given prepare URL for "UNSUCSESSFUL_REGISTER"
            And hit api create a new user with missing "password" fields
            Then validation status code is equals 400
            Then validation response message "Missing password"