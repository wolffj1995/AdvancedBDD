Narrative:
    test full webApp flow

    Scenarios:
        01 - dummy
        02 - GivenStories
        03 - PatternVariants
        04 - ExampleTables

Scenario: 01 - dummy
Meta:
@Id1
@smokeTest

Given the index page is called
Then the IndexPage is shown
When enter name Spongebob
When submit name
Then the CalculationInputPage is shown
Then the name matches Spongebob on inputPage
When input field 1 1
And input field 2 1
And input field 3 1
And submit fields
Then the CalculationResultPage is shown
Then the name matches Spongebob on resultPage
Then the result equals 3 on resultPage

Scenario: 02 - GivenStories
Meta:
@Id2

GivenStories: com/tallence/bddtest/stories/name_input.story#{Id2:scenario2}
When input field 1 1
And input field 2 1
And input field 3 1
And submit fields
Then the CalculationResultPage is shown
Then the name matches $test_data.properties.name1 on resultPage
Then the result equals 3 on resultPage

Scenario: 03 - PatternVariants
Meta:
@Id3

GivenStories: com/tallence/bddtest/stories/name_input.story#{Id2:scenario2}
When input field 1 1
And input field 2 1
And input field 3 1
And submit fields
Then the CalculationResultPage is shown
Then the name matches $test_data.properties.name1 on resultPage
Then the result is 3 on resultPage
Then the result equals 3 on resultPage

Scenario: 04 - ExampleTables
Meta:
@Id4

Given the index page is called
Then the IndexPage is shown
When enter name <name>
When submit name
Then the CalculationInputPage is shown
Then the name matches <name> on inputPage
When input field 1 <firstAdd>
And input field 2 <secondAdd>
And input field 3 <thridAdd>
And submit fields
Then the CalculationResultPage is shown
Then the name matches <name> on resultPage
Then the result equals <total> on resultPage

Examples:
|name|firstAdd|secondAdd|thridAdd|total|
|Bugs Bunny|1|1|1|3|
|Taz|10|20|30|60|
|Tweety|100|500|400|1000|
|Daffy Duck|10000|900000|8000000|8910000|