package com.atendimento.services;

import java.util.List;

public interface ServiceGenerico<T,ID> {

    T salvarObjeto(T objeto);
    T excluirObjeto(T objeto);
    T alterarObjeto (T objeto, ID id);
    T consultarObjeto (ID id);
    List<T> listarTodosObjetos();
}
