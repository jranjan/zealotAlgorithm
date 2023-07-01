package com.backbase.api.controller.v1.response.error;

import com.backbase.api.controller.v1.response.BackbaseApiOutput;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ApiResponseError extends BackbaseApiOutput {
    private String code;
    private String type;
    private String message;
    private String help;
}
