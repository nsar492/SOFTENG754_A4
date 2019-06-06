Narrative:
In order to manage the non-developer reviewers,
As a developer,
I want to delete reviewers from the database.

Scenario: Developer can delete a reviewer from the database
Given Fred is a reviewer in the database
When user deletes the reviewer Fred
Then Fred is removed from the database
