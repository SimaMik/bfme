package net.sima.bfme.util;

public enum FileType {
    Png ("png"),
    Jpg("jpg");

    public final String extension;
    FileType(String extension){
        this.extension = extension;
    }
}