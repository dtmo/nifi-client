Feature: Reporting Tasks

  Scenario: Create a Reporting Task
    Given a Reporting Task has not been created
    When create a Reporting Task
    Then a Reporting Task exists

  Scenario: Get all Reporting Tasks
    Given a Reporting Task has been created
    When get all Reporting Tasks
    Then all Reporting Tasks are returned

  Scenario: Update a Reporting Task
    Given a Reporting Task has been created
    When the Reporting Task is updated
    Then the Reporting Task reports the updated state

  Scenario: Delete a Reporting Task
    Given a Reporting Task has been created
    When delete the Reporting Task
    Then no Reporting Task exists

  Scenario: Start a Reporting Task
    Given a Reporting Task has been created
    And the Reporting Task has not been started
    When start the Reporting Task
    Then the Reporting Task is started

  Scenario: Stop a Reporting Task
    Given a Reporting Task has been created
    And the Reporting Task has been started
    When stop the Reporting Task
    Then the Reporting Task is stopped

  Scenario: Create a Reporting Task Controller Service
    Given there are no Reporting Task Controller Services
    When create a Reporting Task Controller Service
    Then a Reporting Task Controller Service exists

  Scenario: Get all Reporting Task Controller Services
    Given there are Reporting Task Controller Services
    When get all Reporting Task Controller Services
    Then all Reporting Task Controller Services are returned
