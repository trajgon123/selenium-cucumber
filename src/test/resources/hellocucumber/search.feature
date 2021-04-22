Feature: Fulltext search

  @Search
  Scenario Outline: Page tittle test after search
    Given I am on the Home Page
    When I search for "<searchText>"
    Then the page title should contain with "<searchText>"

    Examples:
      | searchText |
      | sluchátka  |
      | lenovo     |

