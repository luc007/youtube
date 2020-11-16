#Author: mung.thai@accenture.com

@Regression
Feature: YouTube Demo

  Background: Open Youtube application
    Given the user opens a Youtube application

  Scenario: Youtube search and play Minios 2015 movie
    When the user search "minions mini movie 2015" and play
    Then Youtube video is playing

  Scenario: Youtube search and save to playlist
     When the user search "minions mini movie 2015" and save "Minions Mini Movie 2015" to playlist
#     Then verify "Minions Mini Movie 2015" in playlist