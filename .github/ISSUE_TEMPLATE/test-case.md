---
name: Test Case
about: Describe this issue template's purpose here.
title: ''
labels: ''
assignees: ''

---

Narrative/Description:

In order to create a new forum topic

As an existing user

I populate valid content and submit the form.

Preconditions:

Staging forum:  

An existing user that is successfully registered and logged in

The user has access to the forum section, where they can create a new topic

Test Steps:

Click the button 'New Topic'

Enter a relevant and descriptive title for the new topic in the provided field:“Create a topic successfully with a title length between 5 and 255 symbols (one sentence)“

Enter a descriptive topic content:“Hello QAs,This is a topic that tests a successful creation of a topic.All fields are populated with valid data. Kind Regards,Didi“

Click the button 'Create Topic'

Expected result:

The ‘Create a new Topic’ window disappeared

The user is redirected to the topic view
