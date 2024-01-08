package br.com.fec.FecApp.Service.ChurchService;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class SendMessageYouthCultService {

    @Scheduled(cron = "0 0 8 ? * MON", zone = "America/Sao_Paulo")
    public void runAtStartOfWeek() {
        // Lógica para a tarefa a ser executada no início da última semana do mês
        System.out.println("Executando na primeira tarefa da última semana do mês.");
    }

    @Scheduled(cron = "0 0 8 ? * 7L", zone = "America/Sao_Paulo")
    public void runLastSaturday() {
        // Lógica para a tarefa a ser executada no último sábado do mês
        System.out.println("Executando na segunda tarefa da última semana do mês (último sábado).");
    }
}
