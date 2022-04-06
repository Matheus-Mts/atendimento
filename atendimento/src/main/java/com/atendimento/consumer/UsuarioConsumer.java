package com.atendimento.consumer;

import com.atendimento.models.dto.UsuarioDTO;
import com.atendimento.services.UsuarioService;
import com.atendimento.util.RabbitMqConstantes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Optional;

@Component
public class UsuarioConsumer implements Serializable {

    @Autowired
    private UsuarioService usuarioService;

    @RabbitListener(bindings = @QueueBinding(value = @Queue(RabbitMqConstantes.NOME_FILA),
            exchange = @Exchange(name = RabbitMqConstantes.NOME_EXCHANGE),
            key = RabbitMqConstantes.ROUTING_KEY))
    private void consumidorUsuarioIncluir(UsuarioDTO usuarioDTO) {
           Optional<UsuarioDTO> usuario = usuarioService.salvarUsuarioDaFila(usuarioDTO);
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue(RabbitMqConstantes.NOME_FILA),
            exchange = @Exchange(name = RabbitMqConstantes.NOME_EXCHANGE),
            key = RabbitMqConstantes.ROUTING_KEY_USUARIO_EXCLUIR))
    private void consumidorUsuarioExcluir(UsuarioDTO usuarioDTO) {
        this.usuarioService.excluirUsuarioDaFila(usuarioDTO.getId());
    }

}
