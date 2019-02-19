@processor
Feature: Processors

	@processor1
  Scenario: Create a Processor
    When a Processor is created
    Then a Processor exists

	@processor2
  Scenario: Starting a Processor
    Given a Processor has been created
    When a Processor is started
    Then the Processor starts

	@processor3
  Scenario: Stopping a Processor
    Given a Processor has been started
    When the Processor is stopped
    Then the Processor stops
