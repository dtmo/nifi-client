Feature: Controller allows access to NiFi Controller features

  Scenario: Create a Controller Service
    Given NiFi is available
    And there are no Controller Services
    When create Controller Service
    Then a Controller Service exists

  Scenario: Get All Controller Services
    Given NiFi is available
    And there are Controller Services
    When get all Controller Services
    Then all Controller Services are returned
