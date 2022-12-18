package br.com.alura.loja.modelo;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;
    private String name;
    private String inscricao;

    public Cliente(String name, String inscricao) {
        this.name = name;
        this.inscricao = inscricao;
    }

    public Cliente() {
    }

    public BigInteger getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInscricao() {
        return inscricao;
    }

    public void setInscricao(String inscricao) {
        this.inscricao = inscricao;
    }
}
