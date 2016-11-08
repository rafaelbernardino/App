package com.bernardino.app.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by rm31243 on 07/11/2016.
 */
public class Participante implements Parcelable {
    private String nome;
    private String email;
    private String telefone;
    private String site;

    public Participante() {

    }

    protected Participante(Parcel in) {
        nome = in.readString();
        email = in.readString();
        telefone = in.readString();
        site = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nome);
        dest.writeString(email);
        dest.writeString(telefone);
        dest.writeString(site);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Participante> CREATOR = new Creator<Participante>() {
        @Override
        public Participante createFromParcel(Parcel in) {
            return new Participante(in);
        }

        @Override
        public Participante[] newArray(int size) {
            return new Participante[size];
        }
    };

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }
}
