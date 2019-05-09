Narrative:
In order to check integration of JBehave and Gradle
This is a simple story

Scenario: Verify user can search for a search term
Given user opens Google homepage
When user enters search term "Epam"
When presses Enter on keyboard
Then title of page is "Google Search"
Then search results are matching the search term