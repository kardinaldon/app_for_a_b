package com.ab.app_for_a_b.model.giphy;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

import java.util.Map;

@Data
@JsonRootName(value = "data")
public class GifDataModel {

    @JsonProperty("type")
    private String type;

    @JsonProperty("id")
    private String id;

    @JsonProperty("url")
    private String url;

    @JsonProperty("slug")
    private String slug;

    @JsonProperty("bitly_gif_url")
    private String bitly_gif_url;

    @JsonProperty("bitly_url")
    private String bitly_url;

    @JsonProperty("embed_url")
    private String embed_url;

    @JsonProperty("username")
    private String username;

    @JsonProperty("source")
    private String source;

    @JsonProperty("title")
    private String title;

    @JsonProperty("rating")
    private String rating;

    @JsonProperty("content_url")
    private String content_url;

    @JsonProperty("source_tld")
    private String source_tld;

    @JsonProperty("source_post_url")
    private String source_post_url;

    @JsonProperty("is_sticker")
    private String is_sticker;

    @JsonProperty("import_datetime")
    private String import_datetime;

    @JsonProperty("trending_datetime")
    private String trending_datetime;

    @JsonProperty("images")
    private Map<String, Object> images;

    @JsonProperty("user")
    private Map<String, Object> user;

}
