package StepDefs;

import Util.MedicalService;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ServiceSteps {
    String ServiceURL = "";
    String response = "";

    @Given("^I am with the Medical appointment service URL \"([^\"]*)\"$")
    public void iAmWithTheMedicalAppointmentServiceURL(String URL) throws Throwable {
        ServiceURL = URL;
    }

    @Given("^I am with the Medical appointment service$")
    public void iAmWithTheMedicalAppointmentService() throws Throwable {
        ServiceURL = "";
    }

    @When("^I send a request to the service to get the free slots for a given date \"([^\"]*)\"$")
    public void iSendARequestToTheServiceToGetTheFreeSlotsForAGivenDate(String date) throws Throwable {
        MedicalService medicalService = new MedicalService();
        ServiceURL = ServiceURL+"/"+date+"/free";
        response = medicalService.get(ServiceURL);
    }

    @Then("^I should see the available slots for a given date$")
    public void iShouldSeeTheAvailableSlotsForAGivenDate() throws Throwable {
        if(response.contains("slots:[]")){
           throw new RuntimeException("Got empty slots for the given date");
        }
    }

    @When("^I send a request to the service to book an appointment with date \"([^\"]*)\" time \"([^\"]*)\" for patient \"([^\"]*)\"$")
    public void iSendARequestToTheServiceToBookAnAppointmentWithDateTimeForPatient(String date, String time, String patientName) throws Throwable {
        MedicalService medicalService = new MedicalService();
        ServiceURL = ServiceURL+"/"+date+"/"+time+"/"+"patientName";
        response = medicalService.post(ServiceURL);
    }

    @Then("^I should see that appointment details$")
    public void iShouldSeeThatAppointmentDetails() throws Throwable {
        if(response.contains("Unable to reserve the appointment")){
            throw new RuntimeException("Failed to reserve an appointment");
        }
    }

    @When("^I send a request to delete the appoint with id \"([^\"]*)\"$")
    public void iSendARequestToDeleteTheAppointWithId(String appointmentID) throws Throwable {
        MedicalService medicalService = new MedicalService();
        ServiceURL = ServiceURL+"/"+appointmentID;
        response = medicalService.post(ServiceURL);
    }

    @Then("^I should see appointment deleted successfully$")
    public void iShouldSeeAppointmentDeletedSuccessfully() throws Throwable {
        if(response.contains("Unable to cancel the appointment")){
            throw new RuntimeException("Failed to cancel the appointment");
        }
    }


}
