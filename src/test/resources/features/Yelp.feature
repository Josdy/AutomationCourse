Feature: Search Yelp

  Background:

    Given user navigates to https://www.yelp.com/
    And selects Restaurant Option

    Scenario Outline: Detail of the first sushi restaurant search result

      Given User search restaurant <type>
      When filters by <distance>
      And select the first search result
      Then User views restaurant information

      Examples:
      |type|distance|
      |Sushi|Driving|

