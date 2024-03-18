package com.example.demo.model;


import javax.persistence.*;

@Entity
@Table(name = "data_sekolah")
public class SekolahModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nama_sekolah")
    private String nama_sekolah;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNama_sekolah() {
        return nama_sekolah;
    }

    public void setNama_sekolah(String nama_sekolah) {
        this.nama_sekolah = nama_sekolah;
    }

    public String getAlamat_sekolah() {
        return alamat_sekolah;
    }

    public void setAlamat_sekolah(String alamat_sekolah) {
        this.alamat_sekolah = alamat_sekolah;
    }

    public String getNo_telfon() {
        return no_telfon;
    }

    public void setNo_telfon(String no_telfon) {
        this.no_telfon = no_telfon;
    }

    public String getEmail_sekolah() {
        return email_sekolah;
    }

    public void setEmail_sekolah(String email_sekolah) {
        this.email_sekolah = email_sekolah;
    }

    public String getMoto() {
        return motto;
    }

    public void setMoto(String motto) {
        this.motto = motto;
    }

    @Column(name = "alamat_sekolah")
    private String alamat_sekolah;

    @Column(name = "no_telfon")
    private String no_telfon;

    @Column(name = "email_sekolah")
    private String email_sekolah;

    @Column(name = "motto")
    private String motto;
}
