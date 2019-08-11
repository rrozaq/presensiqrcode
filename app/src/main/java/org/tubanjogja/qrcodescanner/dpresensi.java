package org.tubanjogja.qrcodescanner;

public class dpresensi {

    int id;
    String npm;

    // constructors
    public dpresensi() {
    }

    public dpresensi(String npm) {
        this.npm = npm;
    }

    public dpresensi(int id, String npm) {
        this.id = id;
        this.npm = npm;
    }

    // setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNote(String npm) {
        this.npm = npm;
    }

    // getters
    public long getId() {
        return this.id;
    }

    public String getNpm() {
        return this.npm;
    }
}
