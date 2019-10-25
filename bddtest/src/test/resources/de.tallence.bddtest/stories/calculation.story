Narrative:


    Scenarios:
        01 -

Scenario: 01 - input name + calculation
Meta:

Given the index page is called
Then the IndexPage is shown
When enter name Jonas
When submit name
Then the CalculationInputPage is shown
Then the name matches Jonas on inputPage
When input field 1 1
And input field 2 1
And input field 3 1
And submit fields
Then the CalculationResultPage is shown

