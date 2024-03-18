package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "data_kelas")
public class KelasModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nama_kelas")
    private String nama_Kelas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNama_Kelas() {
        return nama_Kelas;
    }

    public void setNama_Kelas(String nama_Kelas) {
        this.nama_Kelas = nama_Kelas;
    }

    public String getNama_jurusan() {
        return nama_jurusan;
    }

    public void setNama_jurusan(String nama_jurusan) {
        this.nama_jurusan = nama_jurusan;
    }

    public String getWali_kelas() {
        return wali_kelas;
    }

    public void setWali_kelas(String wali_kelas) {
        this.wali_kelas = wali_kelas;
    }

    @Column(name = "nama_jurusan")
    private String nama_jurusan;

    @Column(name = "wali_kelas")
    private String wali_kelas;
}
