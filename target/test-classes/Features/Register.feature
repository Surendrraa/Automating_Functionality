Feature: Registration functionality

  Scenario Outline: User registration with valid and unvalid details
    Given the user is on the home page
    And the user clicks on My Account
    And the user clicks on Register
    And the user enters first name, last name, email, phone, password and confirm password "<firstName>" , "<lastName>" , "<email>" , "<phone>" , "<password>" and "<confirm>"
   # And the user enters last name "<lastName>"
   # And the user enters email "<email>"
   # And the user enters phone "<phone>"
   # And the user enters password "<password>"
   # And the user enters confirm password "<confirm>"
    And the user selects the newsletter option
    And the user agrees to the terms and conditions
    And the user clicks on the Continue button
    Then tear down
    

    Examples:
      | firstName    | lastName | email                   | phone        | password    | confirm     |#    result    | |      comment           |   
      | C V Surendra | Surendra | cvsurendra2001@gmail.com| 8186874383   | Phani@123   | Phani@123   | # sucessful   | |      New User          |
      | C V Surendra | Surendra | cvsurendra2001@gmail.com| 8186874383   | Phani@123   | Phani@123   |# unsucessful  | |      Exesting Use      |
      | C V Surendra | Surendra | cvsurendra2001@gmail.com| 8186874383   | Phani@123   | Phani@      | #unsucessful  | |      worng confirm pwd |
      | C V Surendra | Surendra | cvsurendra2001@gmail.com| 8186874383   | Phani@12    | Phani@123   | #unsucessful  | |      worng pwd         |
      | C V Surendra | Surendra | cvsurendra2001@gmail.com| 8186874      | Phani@123   | Phani@123   |# unsucessful  | |      invalid phone     | 
      | C V Surendra | Surendra | cvsurendra2001@         | 8186874383   | Phani@123   | Phani@123   | #unsucessful  | |      invalid email     |       
      |              | Surendra | cvsurendra2001@gmail.com| 8186874383   | Phani@123   | Phani@      | #unsucessful  | |      blank firstname   |
      | C V Surendra |          | cvsurendra2001@gmail.com| 8186874383   | Phani@12    | Phani@123   | #unsucessful  | |      blank lastname    |
      | C V Surendra | Surendra |                         | 8186874383   | Phani@123   | Phani@123   | #unsucessful  | |      blank email       | 
      | C V Surendra | Surendra | cvsurendra2001@gmail.com|              | Phani@123   | Phani@123   | #unsucessful  | |      blank phone       |
      | C V Surendra | Surendra | cvsurendra2001@gmail.com| 8186874383   |             | Phani@123   | #unsucessful  | |      blank confirm pwd |
      | C V Surendra | Surendra | cvsurendra2001@gmail.com| 8186874383   | Phani@123   |             | #unsucessful  | |      blank confirm pwd |
      |              |          |                         |              |             |             | #unsucessful  | |      blank             |
      | 345566       | $$$      | 85949jjbbb              | % $          | % $ $ $     |       !&%   | #unsucessful  | |      different symbols |
      