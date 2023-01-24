Feature: Crypto Prices Dashboard

  Scenario Outline: Filtering UI and extracting data
    Given User Launch Chrome Browser
    When User Opens The URL "https://coinmarketcap.com/"
    And Select Show Rows By Twenty
    Then Capture All Page Contents
    And Filter Data By Algorith-Pow
    And Click To Add filter
    And Toggle Mineable
    And Select All Crytocurrencies
    And Select Coins
    And Select Price
    And Set Minimum Value "<minValue>" & Maximum Value "<maxValue>"
    Then Compare Page Content With Main Content
    And Close Bowser
    
    Examples:
		| minValue | maxValue |
		| 10 | 10000 |
