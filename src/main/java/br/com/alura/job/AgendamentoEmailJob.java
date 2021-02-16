package br.com.alura.job;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;

import br.com.alura.entidade.AgendamentoEmail;
import br.com.alura.servico.AgendamentoEmailServico;

@Singleton
public class AgendamentoEmailJob {

    @Inject
    private AgendamentoEmailServico agendamentoEmailServico;

    @Inject
    @JMSConnectionFactory("java:jboss/DefaultJMSConnectionFactory")
    private JMSContext context;

    @Resource(mappedName = "java:/jms/queue/EmailQueue")
    private Queue queue;

    @Schedule(hour = "*", minute = "*", second = "*/10")
    public void enviarEmail() {
        List<AgendamentoEmail> listarPorNaoAgendado
                = agendamentoEmailServico.listarPorNaoAgendado();
        listarPorNaoAgendado.forEach(emailNaoAgendado -> {
            context.createProducer().send(queue, emailNaoAgendado);
            agendamentoEmailServico.alterar(emailNaoAgendado);
        });
//        SCHEDULE CONTROLA DE QUANTO EM QUANTO TEMPO SERA ENVIADO O EMAIL
    }

    /*
    STATELESS X SINGLETON
    No desenvolvimento da nossa aplicação não dará para ver muito este cenário,
    pois apenas nós fazemos requisição para a aplicação em desenvolvimento.
    Se fosse para produção, com um número de requisições pelos usuários aumentando,
    com o @Stateless seriam criados vários objetos de AgendarEmailJob,
    por mais que nas instâncias criadas, o job só fosse executado uma vez,
    não seria o comportamento que queríamos.
    O @Singleton, independente de quantos usuários estão requisitando a nossa aplicação,
    teríamos uma única instância desse objeto.
     */

}
