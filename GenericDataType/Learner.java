package com.wipro.JavaBasics.GenericDataType;

public class Learner {

    private String name;
    private String mic = "Off";
    private String video = "Off";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMic() {
        return mic;
    }

    public void setMic(String mic) {
        this.mic = mic;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }
}