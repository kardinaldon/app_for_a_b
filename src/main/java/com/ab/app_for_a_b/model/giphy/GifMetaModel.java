package com.ab.app_for_a_b.model.giphy;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

@Data
@JsonRootName(value = "meta")
public class GifMetaModel {

    @JsonProperty("status")
    private String status;

    @JsonProperty("msg")
    private String msg;

    @JsonProperty("response_id")
    private String responseId;
}
