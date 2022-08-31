package com.algafood.domain.infrastrutura;

import com.algafood.domain.model.FormaPagamento;
import com.algafood.domain.repository.FormaPagamentorepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

public class FormaPagamentoRepositorioImpl implements FormaPagamentorepository {

    @PersistenceContext
    private EntityManager manager;

    @Transactional
    @Override
    public FormaPagamento cadastarFormaDePagamento(FormaPagamento formaPagamento) {
        return manager.merge(formaPagamento);
    }

    @Transactional
    @Override
    public FormaPagamento atualizarFormaPagamento(FormaPagamento formaPagamento) {
        formaPagamento = manager.find(FormaPagamento.class, formaPagamento.getId());
        return manager.merge(formaPagamento);
    }

    @Override
    public List<FormaPagamento> listarFormasPagamento() {
        return manager.createQuery("from FormaPagamento", FormaPagamento.class).getResultList();
    }

    @Transactional
    @Override
    public void removerFormasDePagamento(FormaPagamento formaPagamento) {
        formaPagamento = manager.find(FormaPagamento.class, formaPagamento.getId());
        manager.remove(formaPagamento);
    }
}
