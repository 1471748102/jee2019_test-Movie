package bean;

import java.io.Serializable;

public class movie implements Serializable {
    private String moviename;
    private String showtime;
    private String shortinfo;
    private String picturepath;

    public String getMoviename() {
        return moviename;
    }

    public String getShowtime() {
        return showtime;
    }

    public String getShortinfo() {
        return shortinfo;
    }

    public String getPicturepath() {
        return picturepath;
    }

    public void setMoviename(String moviename) {
        this.moviename = moviename;
    }

    public void setShowtime(String showtime) {
        this.showtime = showtime;
    }

    public void setShortinfo(String shortinfo) {
        this.shortinfo = shortinfo;
    }

    public void setPicturepath(String picturepath) {
        this.picturepath = picturepath;
    }

    public movie(){}
    public movie(String moviename,String showtime,String shortinfo,String picturepath){
        super();
        this.moviename=moviename;
        this.showtime=showtime;
        this.shortinfo=shortinfo;
        this.picturepath=picturepath;


    }

    public String toString() {
        return "user{" +
                "username='" + moviename + '\'' +
                ", userid=" + showtime +
                ", userroom='" + shortinfo + '\'' +
                ", userage=" + picturepath +
                '}';
    }
}
