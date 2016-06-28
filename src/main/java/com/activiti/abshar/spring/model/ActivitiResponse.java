package com.activiti.abshar.spring.model;

/**
 * Activiti Response Object returned by all REST apis.
 */
public class ActivitiResponse {
    /**
     * response object.
     */
    private Object response;
    /**
     * error Message.
     */
    private String errorMessage;

    /**
     * response getter.
     *
     * @return response.
     */
    public Object getResponse() {
        return response;
    }

    /**
     * response setter.
     *
     * @param response response.
     */

    public void setResponse(Object response) {
        this.response = response;
    }

    /**
     * errorMessage getter.
     *
     * @return error message.
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * errorMessage setter.
     *
     * @param errorMessage errorMessage.
     */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
