#Author: mung.thai@accenture.com

@Sanity
Feature: YouTube Demo

  Background: Open Youtube application
    Given the user opens a Youtube application

  Scenario: Youtube search and play Minios 2019 movie
    When the user search "minions mini movie 2019" and play
    Then Youtube video is playing

#  Scenario: Youtube search and save to playlist
#     When the user search "minions 2015 memorable moments" and save "Minions 2015" to playlist
#     Then verify "Minios 2015" in playlist