//package br.com.senacrio.feiravirtual.domain.dto;
//
//import br.com.senacrio.feiravirtual.domain.Stand;
//
//import java.io.Serializable;
//import java.time.LocalDateTime;
//
//public class Relatorio implements Serializable {
//
//    private Long quantidade;
//
//    private LocalDateTime data;
//
//    private Stand stand;
//
//    public Relatorio() {
//    }
//
//    public Relatorio(Long quantidade, LocalDateTime data) {
//        this.quantidade = quantidade;
//        this.data = data;
//    }
//
//    public Relatorio(Long quantidade, LocalDateTime data, Stand stand) {
//        this.quantidade = quantidade;
//        this.data = data;
//        this.stand = stand;
//    }
//
//    public Long getQuantidade() {
//        return quantidade;
//    }
//
//    public void setQuantidade(Long quantidade) {
//        this.quantidade = quantidade;
//    }
//
//    public LocalDateTime getData() {
//        return data;
//    }
//
//    public void setData(LocalDateTime data) {
//        this.data = data;
//    }
//
//    public Stand getStand() {
//        return stand;
//    }
//
//    public void setStand(Stand stand) {
//        this.stand = stand;
//    }
//}