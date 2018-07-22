Feature: Create and Instantiate Templates
  Scenario: A template can be created
    Given a Snippet has been created
    When create a Template
    Then getting all Templates includes the Template

  Scenario: A template can be instantiated
    Given a Template has been created
    When the Template is instantiated in the Root Process Group
    Then the Root Process Group contains the Template components

  Scenario: A template can be deleted
    Given a Template has been created
    When the Template is deleted
    Then getting all Templates does not include the Template

  Scenario: A template can be exported
    Given a Template has been created
    When export the Template
    Then the template is exported

  Scenario: A Template can be uploaded
    Given there is no Template called 'Template_Upload_Test'
    When the 'Template_Upload_Test' Template is uploaded
    Then there is a Template called 'Template_Upload_Test'