package com.labti.springHibernate.controller;

import com.labti.springHibernate.app;
import com.labti.springHibernate.config.MahasiswaTableModel;
import com.labti.springHibernate.model.Mahasiswa;
import com.labti.springHibernate.view.MahasiswaView;
import java.util.List;
import javax.swing.JOptionPane;

public class MahasiswaController {
    private final MahasiswaView mahasiswaView;
    private MahasiswaTableModel mahasiswaTableModel;
    private List<Mahasiswa> mahasiswas;
    
    public MahasiswaController(MahasiswaView mahasiswaView) {
        this.mahasiswaView = mahasiswaView;
    }
    
    public void tampilData() {
	mahasiswas = app.getMahasiswaService().getMahasiswas();
	mahasiswaTableModel = new MahasiswaTableModel(mahasiswas);	
	this.mahasiswaView.getTabel().setModel(mahasiswaTableModel);
    }
    
    public void show() {
	int index = this.mahasiswaView.getTabel().getSelectedRow();
	this.mahasiswaView.getNpm().setText(String.valueOf(
	this.mahasiswaView.getTabel().getValueAt(index, 0)));
	this.mahasiswaView.getNama().setText(String.valueOf(
	this.mahasiswaView.getTabel().getValueAt(index, 1)));
	this.mahasiswaView.getKelas().setText(String.valueOf(
	this.mahasiswaView.getTabel().getValueAt(index, 2)));
	this.mahasiswaView.getAlamat().setText(String.valueOf(
	this.mahasiswaView.getTabel().getValueAt(index, 3)));
    }
    
    public void clear() {
	this.mahasiswaView.getNpm().setText("");
	this.mahasiswaView.getNama().setText("");
	this.mahasiswaView.getKelas().setText("");
	this.mahasiswaView.getAlamat().setText("");
    }
    
    public void saveMahasiswa() {
	Mahasiswa mahasiswa = new Mahasiswa();
	mahasiswa.setNpm(this.mahasiswaView.getNpm().getText());
	mahasiswa.setNama(this.mahasiswaView.getNama().getText());
	mahasiswa.setKelas(this.mahasiswaView.getKelas().getText());
	mahasiswa.setAlamat(this.mahasiswaView.getAlamat().getText());
	app.getMahasiswaService().save(mahasiswa);
	JOptionPane.showMessageDialog(null, "Data Berhasil di Simpan", "info",
	JOptionPane.INFORMATION_MESSAGE);
        clear();
        tampilData();
    }
    
    public void updateMahasiswa() {
	Mahasiswa mahasiswa = new Mahasiswa();
	mahasiswa.setNpm(this.mahasiswaView.getNpm().getText());
	mahasiswa.setNama(this.mahasiswaView.getNama().getText());
	mahasiswa.setKelas(this.mahasiswaView.getKelas().getText());
	mahasiswa.setAlamat(this.mahasiswaView.getAlamat().getText());
	app.getMahasiswaService().update(mahasiswa);
	JOptionPane.showMessageDialog(null, "Data Berhasil di Edit", "info",
	JOptionPane.INFORMATION_MESSAGE);
	clear();
	tampilData();
    }
    
    public void deleteMahasiswa(){
        if(this.mahasiswaView.getNpm().getText() == null){
            JOptionPane.showMessageDialog(null, "Mahasiswa belum dipilih", "error",JOptionPane.ERROR_MESSAGE);
        }else{
            Mahasiswa mahasiswa = new Mahasiswa();
            mahasiswa.setNpm(this.mahasiswaView.getNpm().getText());
            int pilih = JOptionPane.showConfirmDialog(null,"Apakah data ingin dihapus ?", "Warning",JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if(pilih == JOptionPane.YES_OPTION){
                app.getMahasiswaService().delete(mahasiswa);
                JOptionPane.showMessageDialog(null, "Data Berhasil di Hapus", "info",JOptionPane.INFORMATION_MESSAGE);
                clear();
                tampilData();
            }
        }
    }






}
