Feature:  Medical appointment

  Scenario: Verify list of free slots for a given date
    Given I am with the Medical appointment service URL "http://host/appoinments/<token-id>"
    When I send a request to the service to get the free slots for a given date "2/3/2018"
    Then I should see the available slots for a given date

  Scenario: Verify to reserve a lot for a given date
    Given I am with the Medical appointment service URL "http://host/appoinments/<token-id>"
    When I send a request to the service to book an appointment with date "2/3/2018" time "10:30 AM" for patient "name"
    Then I should see that appointment details

  Scenario: Verify to delete an appointment
    Given I am with the Medical appointment service URL "http://host/appoinments/<token-id>"
    When I send a request to delete the appoint with id "123456"
    Then I should see appointment deleted successfully