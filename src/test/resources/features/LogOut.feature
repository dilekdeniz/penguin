@FID10-309
Feature: Default

	#{color:#DE350B}*1- User can log out and ends up in login page.*{color}
	#2- The user can not go to the home page again by clicking the step back button after successfully logged out.
	@FID10-303
	Scenario Outline: User can log out and ends up in login page
		Given user goes to login page
		Then user enters "<username>" as username
		And enters "<password>" as password
		Then user clicks to login button and should be on the homepage
		And user should see logout button the dropdowns by clicking the profile icon
		Then user should be able to click to logout button and land back on the login page
		Examples:
			| username                | password     |
			| salesmanager15@info.com | salesmanager |
			| posmanager20@info.com   | posmanager   |
			| salesmanager72@info.com | salesmanager |
			| posmanager47@info.com   | posmanager   |

	#1- User can log out and ends up in login page.*
	#{color:#DE350B}*2- The user can not go to the home page again by clicking the step back button after successfully logged out.*{color}
	@FID10-306
	Scenario Outline: User can log out and ends up in login page
		Given user goes to login page
		Then user enters "<username>" as username
		And enters "<password>" as password
		Then user clicks to login button and should be on the homepage
		And user should see logout button the dropdowns by clicking the profile icon
		Then user should be able to click to logout button and land back on the login page
		When user navigate back and should see the expired message
		Examples:
			| username                | password     |
			| salesmanager6@info.com  | salesmanager |
			| posmanager87@info.com   | posmanager   |
			| salesmanager12@info.com | salesmanager |
			| posmanager47@info.com   | posmanager   |