#Author: mung.thai@accenture.com

@YouTubeDemo
Feature: YouTube Demo

	Background: Open Youtube application
   	Given the user opens a Youtube application
	    
  Scenario: Youtube search and play Minios movie
     When the user search "minions 2015 memorable moments" and play
     Then Youtube video is playing
     
  Scenario: Youtube search and save to playlist
     When the user search "minions 2015 memorable moments" and save "Minions 2015" to playlist
     Then verify "Minios 2015" in playlist     