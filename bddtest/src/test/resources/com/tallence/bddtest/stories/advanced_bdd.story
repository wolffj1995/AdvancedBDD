Scenario: Priorisierung
Meta:
@userName Spongebob

Given the index page is called
Then the IndexPage is shown
When enter name using the given username
When submit name
Then the CalculationInputPage is shown
Then the name matches Spongebob on inputPage

Scenario: StoryInteraction
Meta:

Given the index page is called
Given the cache filled with {
    "coolName":"Eugene H. Krabs"
}
Then the IndexPage is shown
When enter name $coolName
When submit name
Then the CalculationInputPage is shown
Then the name matches $coolName on inputPage

Scenario: Composites
Meta:

Given the index page is called
Then the IndexPage is shown
When enter name $test_data.properties.name2 and submit
Then the CalculationInputPage is shown
Then the name matches $test_data.properties.name2 on inputPage

Scenario: GivenStories
Meta:

GivenStories: com/tallence/bddtest/stories/name_input.story#{Id2:scenario2}
When input field 1 1
And input field 2 1
And input field 3 1
And submit fields
Then the CalculationResultPage is shown
Then the name matches Maik on resultPage
Then the result equals 3 on resultPage

Scenario: ExampleTables
Meta:

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

Scenario: Meta Info as parameter
Meta:
@userName Spongebob

Given the index page is called
Then the IndexPage is shown
When enter name using the given username
When submit name
Then the CalculationInputPage is shown
Then the name matches Spongebob on inputPage

Scenario: Meta Info as filter parameter
Meta:
@smokeTest

Given the index page is called
Then the IndexPage is shown
When enter name Spongebob
When submit name
Then the CalculationInputPage is shown
Then the name matches Spongebob on inputPage

Scenario: Parameter Converter
Meta:

Given the index page is called
Given the cache filled with {
    "coolName": "$test_data.properties.name1$"
}
Then the IndexPage is shown
When enter name $coolName
When submit name
Then the CalculationInputPage is shown
Then the name matches $coolName on inputPage