package com.algafood.domain.repository;

import com.algafood.domain.model.FormaPagamento;

import java.util.List;

public interface FormaPagamentorepository {

    FormaPagamento cadastarFormaDePagamento(FormaPagamento formaPagamento);

    FormaPagamento atualizarFormaPagamento(FormaPagamento formaPagamento);

    List<FormaPagamento> listarFormasPagamento();

    void removerFormasDePagamento(FormaPagamento formaPagamento);
}
