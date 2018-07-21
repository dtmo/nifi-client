Feature: Controller allows access to NiFi Controller features

  Scenario: Create a Controller Service
    Given there are no Controller Services
    When create a Controller Service
    Then a Controller Service exists

  Scenario: Get All Controller Services
    Given there are Controller Services
    When get all Controller Services
    Then all Controller Services are returned

  Scenario: Create a Reporting Task
    Given there are no Reporting Tasks
    When create a Reporting Task
    Then a Reporting Task exists

  Scenario: Get All Reporting Tasks
    Given there are Reporting Tasks
    When get all Reporting Tasks
    Then all Reporting Tasks are returned