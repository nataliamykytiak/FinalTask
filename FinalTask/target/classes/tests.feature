Feature: Tests

  Background:

    Given User opens 'https://www.amazon.com/' page

  Scenario Outline: Check number of found elements by keyword
    When User checks search input field visibility
    And User makes search by keyword '<keyword>'
    And User clicks search button
    And User checks search results visibility
    Then User checks number of found products equals '<numberOfFoundProducts>'

    Examples:
      | keyword | numberOfFoundProducts |
      | robot   | 48                    |


  Scenario Outline: Check search results first item name by keyword
    When User checks search input field visibility
    And User makes search by keyword '<keyword>'
    And User clicks search button
    And User checks search results visibility
    Then User checks search results first item name contains '<keyword>'

    Examples:
      | keyword |
      | robot   |


  Scenario Outline: Check the email error message in the sing in form
    When User checks Sign In link visibility
    And User clicks Sign In link
    And User checks Email or mobile phone number field visibility on sign in page
    And User checks Continue button visibility on sign in page
    And User clicks Continue button
    Then User checks that current error message is '<errorMessage>'

    Examples:
      | errorMessage                            |
      | Enter your email or mobile phone number |


  Scenario Outline: Check user can sign in with incorrect password
    When User checks Sign In link visibility
    And User clicks Sign In link
    And User checks Email or mobile phone number field visibility on sign in page
    And User enters his email in Email or mobile phone number field '<userEmail>'
    And User checks Continue button visibility on sign in page
    And User clicks Continue button
    And User checks Password field visibility on sign in page
    And User enters password '<userPassword>'
    And User checks Sign-In button visibility on sign in page
    And User clicks Sign-In button on sign in page
    Then User checks that current error password message is '<errorPasswordMessage>'

    Examples:
      | userEmail                  | userPassword | errorPasswordMessage       |
      | nataliia.m.test1@gmail.com | 111114       | Your password is incorrect |


  Scenario Outline: Check user can sing in
    When User checks Sign In link visibility
    And User clicks Sign In link
    And User checks Email or mobile phone number field visibility on sign in page
    And User enters his email in Email or mobile phone number field '<userEmail>'
    And User checks Continue button visibility on sign in page
    And User clicks Continue button
    And User checks Password field visibility on sign in page
    And User enters password '<userPassword>'
    And User checks Sign-In button visibility on sign in page
    And User clicks Sign-In button on sign in page
    Then User checks the greeting text on a personal account page '<userName>'

    Examples:
      | userEmail                  | userPassword | userName        |
      | nataliia.m.test1@gmail.com | 111111       | Hello, Nataliia |


  Scenario Outline: Check changing user's name on personal account page
    When User checks Sign In link visibility
    And User clicks Sign In link
    And User checks Email or mobile phone number field visibility on sign in page
    And User enters his email in Email or mobile phone number field '<userEmail>'
    And User checks Continue button visibility on sign in page
    And User clicks Continue button
    And User checks Password field visibility on sign in page
    And User enters password '<userPassword>'
    And User checks Sign-In button visibility on sign in page
    And User clicks Sign-In button on sign in page
    And User clicks Account & Lists button in the header of a page
    And User checks Login & security section visibility on personal account page
    And User clicks Login & security
    And User checks Edit button in Name field visibility
    And User clicks Edit button
    And User checks title of page is '<changeNamePageTitle>'
    And User changes current name to '<newName>' new name
    And User checks Save changes button visibility
    And User clicks Save changes button
    Then User checks that current name is '<currentName>'

    Examples:
      | userEmail                  | userPassword | changeNamePageTitle  | newName       | currentName |
      | nataliia.m.test1@gmail.com | 111111       | Change your name     | Nataliia      | Nataliia    |


  Scenario Outline: Check user can change delivery location with US zip-code
    When User checks Deliver To pop-over link visibility
    And User clicks on Deliver To pop-over link
    And User checks Location Settings Popup visibility
    And User checks Location Settings Popup text equals to '<locationSettingsTitle>' text
    And User checks Zip Code input field visibility
    And User enters Zip Code '<zipCode>' in Zip Code input field
    And User checks Apply button visibility
    And User clicks on Apply button
#    And User checks Continue button visibility
#    And User clicks on Continue button
    And User clicks on Deliver To pop-over link
    And User checks Deliver To pop-over link visibility
    Then User checks current delivery location contains '<zipCode>'

    Examples:
      | locationSettingsTitle | zipCode |
      | Choose your location  | 96742   |



















#  Scenario Outline: Check if items are sorted by price in ascending order
#    When User hovers over menu section drop-down
#    And User clicks on item menu category button
#    And User checks menu category page elements visibility
#    And User clicks on item category button
#    And User checks item category page elements visibility
#    And User clicks on sort drop-down
#    And User clicks on Price + Shipping: lowest first button
#    And User checks item category page elements visibility
#    And User checks first four items are sorted in ascending order
#
#    Examples:
#      | menuSection | itemMenuCategory | itemCategory |
#      |    |