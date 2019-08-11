package org.tubanjogja.qrcodescanner;

public class dmahasiswa {
    int id;
    String npm;
    String nama;
    String jurusan;

    // constructors
    public dmahasiswa() {

    }

    public dmahasiswa(String npm) {
        this.npm = npm;
    }

    public dmahasiswa(int id, String nama, String jurusan) {
        this.id = id;
        this.nama = nama;
        this.jurusan = jurusan;
    }

    // setter
    public void setId(int id) {
        this.id = id;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    // getter
    public int getId() {
        return this.id;
    }

    public String getNama() {
        return this.nama;
    }
}
