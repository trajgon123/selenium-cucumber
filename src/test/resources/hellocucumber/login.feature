Feature: Login user

  @Login
  Scenario Outline: Test user login
    Given I am on Login Page
    When I enter alias "<alias>"
    And I enter password "<password>"
    And I click logIn user
    Then User should be logged? "<isLogged>"


    Examples:
      | alias     | password       | isLogged |
      | solotest2 | qzeuiqzwieqwie | true     |
      | Friday    | qzeuiqzwieqwie | false    |
