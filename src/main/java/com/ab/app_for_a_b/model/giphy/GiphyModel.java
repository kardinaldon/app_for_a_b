package com.ab.app_for_a_b.model.giphy;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GiphyModel {

    @JsonProperty("data")
    private GifDataModel gifDataModel;

    @JsonProperty("meta")
    private GifMetaModel gifMetaModel;
}
