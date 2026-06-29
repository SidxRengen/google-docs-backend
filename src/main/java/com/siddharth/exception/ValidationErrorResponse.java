package com.siddharth.exception;

import java.util.HashMap;

public record ValidationErrorResponse(
        HashMap<String, String> error
) {
}
