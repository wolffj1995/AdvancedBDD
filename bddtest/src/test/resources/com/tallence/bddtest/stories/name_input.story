Narrative:
    test the nameInput at IndexPage

    Scenarios:
        01 - dummy
        02 - dataSet
        03 - StoryInteraction

Scenario: 01 - dummy
Meta:
@Id1 scenario1

Given the index page is called
Then the IndexPage is shown
When enter name Spongebob
When submit name
Then the CalculationInputPage is shown
Then the name matches Spongebob on inputPage

Scenario: 02 - Enter name and goto Calculcation page
Meta:
@Id2 scenario2

Given the index page is called
Then the IndexPage is shown
When enter name Maik
When submit name
Then the CalculationInputPage is shown
Then the name matches Maik on inputPage

Scenario: 03 - StoryInteraction
Meta:
@Id3 scenario3

Given the index page is called
Given the cache filled with {
    "coolName":"Eugene H. Krabs"
}
Then the IndexPage is shown
When enter name $coolName
When submit name
Then the CalculationInputPage is shown
Then the name matches $coolName on inputPage

Scenario: 04 - Composites
Meta:
@Id4 scenario4

Given the index page is called
Then the IndexPage is shown
When enter name $test_data.properties.name2 and submit
Then the CalculationInputPage is shown
Then the name matches $test_data.properties.name2 on inputPage