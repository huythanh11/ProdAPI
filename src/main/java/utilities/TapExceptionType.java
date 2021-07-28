package utilities;

public enum TapExceptionType {
    PROCESSING_FAILED,
    UNDEFINED,
    EXPECTED_WEBELEMENT_DOESNOT_EXIST,
    EXPECTED_ALERT_DOESNOT_EXIST,
    VALIDATION_FAILED,
    IO_ERROR,
    INVALID_DATA_TABLE,
    INVALID_PARAMETER;

    private TapExceptionType() {
    }
}
