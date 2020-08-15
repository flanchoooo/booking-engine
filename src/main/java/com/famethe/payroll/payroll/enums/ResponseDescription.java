package com.famethe.payroll.payroll.enums;

public enum ResponseDescription {

    // AUTHORISATION
    AUTH_FAILED("Authorisation failed."),
    AUTH_FAILED_ACTIVE("Authorisation failed. Account not active"),
    AUTH_SUCCESS("Authorisation granted."),


    SUCCESS("Success"),
    COMPANY_REG_SUCCESS("Congratulations, You have successfully registered you company with us."),
    COMPANY_ACTIVATION_SUCCESS("Congratulations, You have successfully completed your company profile, now you are all set to get started."),
    EMPLOYEE_REG_SUCCESS("You have successfully added your employee to your company profile."),
    BENEFIT_ACTIVATION_SUCCESS("You have successfully configured a benefit for an employee."),
    FILE_SUCCESS("You have successfully saved a file for an employee."),
    PAYMENT_SAVED_SUCCESS("Your payment status is currently "),
    LEAVE_CONFIG_SUCCESS("You have successfully configured leave for an employee."),
    LOAN_CONFIG_SUCCESS("You have successfully configured a loan for an employee."),
    PAYROLL_GENERATION_SUCCESS("You have successfully run your payroll."),
    DEDUCTION_ACTIVATION_SUCCESS("You have successfully configured a deduction for an employee."),
    MISSING_PARAMETERS("Missing parameters."),
    ENTITY_NOT_FOUND("Entity does not exist."),
    REFERENCE_NOT_FOUND("Reference does not exist."),

    ENTITY_ALREADY_EXISTS("Entity already exists."),
    USER_ENTITY_ALREADY_EXISTS("Username already exists, please try another username."),
    EMPLOYEE_ENTITY_ALREADY_EXISTS("Duplicate entry, an employee with those credentials already exists."),


    LEAVE_BALANCE_ERROR("The employee's leave balance is below the selected date range."),


    ACCOUNT_BLOCKED("Too many login tries. Account locked."),

    GENERAL_ERROR("General Error."),
    HTTP_GENERAL_ERROR("An internal request failed, please contact the support team."),


    PASSWORD_NOT_MATCH("The password you entered does not match."),
    LICENCE("licence"),
    USER_REGISTRATION ("You have successfully registered your account, you many proceed to login."),
    PASSWORD_RESET ("An email has been sent to you, please follow the instructions to reset your password.");
    private final String description;

    ResponseDescription(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
