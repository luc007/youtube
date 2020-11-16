#Author: mung.thai@accenture.com

@Sanity
Feature: YouTube Demo

  Background: Open Youtube application
    Given the user opens a Youtube application

  Scenario: Youtube search and play Minios 2017 movie
    When the user search "minions mini movie 2017" and play
    Then Youtube video is playing

  Scenario: Youtube search and save to playlist
     When the user search "minions mini movie 2017" and save "minions mini movie 2017" to playlist
#     Then verify "Minios 2015" in playlist