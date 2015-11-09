package com.fixeads.pager.network.model;

/**
 * Created by Timwe on 15/10/2015.
 */
public enum ErrorCode {

    AN_ERROR_OCCURRED(0, "An error has occurred"),
    ERROR_CONNECTION(1, "Error connection"),
    PROFILE_EXISTS(101, "Profile already exists"),
    PROFILE_CREATED(102, "Profile not created"),
    ACCOUNT_EXISTS(103, "User account already exists"),
    MISSING_PARAMS(104, "Missing parameters"),
    PLAYLIST_NOTFOUND(105, "Playlist not found"),
    USER_NOTFOUND(106, "User not found"),
    PLAYLIST_EXISTS(107, "Playlist already exists"),
    EVENT_NOTFOUND(108, "Event not found"),
    NEWS_NOTFOUND(109, "News not found"),
    SONG_NOTFOUND(110, "Song not found"),
    ARTIST_NOTFOUND(111, "Artist not found"),
    ALBUM_NOTFOUND(112, "Album not found"),
    INVALID_QUERY(113, "Invalid query type"),
    QUERY_TOOSMALL(114, "Query too small");

    private int code;
    private String message;

    ErrorCode(int code, String message) {
        setCode(code);
        setMessage(message);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static ErrorCode getValue(int code){
        ErrorCode[] values = ErrorCode.values();
        for (ErrorCode value : values) {
            if (value.getCode() == code) {
                return value;
            }
        }
        return ErrorCode.AN_ERROR_OCCURRED;
    }
}
