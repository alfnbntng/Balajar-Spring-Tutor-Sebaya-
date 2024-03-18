package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "data_siswa")
public class SiswaModel  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NISN")
    private Long NISN;

    @Column(name = "nama_siswa")
    private String nama_siswa;

    @Column(name = "umur")
    private int umur;

    @Column(name = "alamat")
    private String alamat;

    @Column(name = "kelas")
    private String kelas;

    @Column(name = "jurusan")
    private String jurusan;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNISN() {
        return NISN;
    }

    public void setNISN(Long NISN) {
        this.NISN = NISN;
    }

    public String getNama_siswa() {
        return nama_siswa;
    }

    public void setNama_siswa(String nama_siswa) {
        this.nama_siswa = nama_siswa;
    }

    public int getUmur() {
        return umur;
    }

    public void setUmur(int umur) {
        this.umur = umur;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }
}
