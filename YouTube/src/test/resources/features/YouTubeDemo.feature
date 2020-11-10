#Author: mung.thai@accenture.com

Feature: YouTube Search and Play

  Scenario: Youtube search and play Minios in 720p
    Given the user opens a Youtube application
     When the user search "Minions 2015 Memorable Moments" and play in "720p"
     Then Youtube will play
