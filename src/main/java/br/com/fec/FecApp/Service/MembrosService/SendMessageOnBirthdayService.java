package br.com.fec.FecApp.Service.MembrosService;

import br.com.fec.FecApp.Domain.Membro;
import br.com.fec.FecApp.Repositories.MembroRepository.IMembroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SendMessageOnBirthdayService {

    @Autowired
    IMembroRepository membroRepository;

    @Scheduled(cron = "0 0 8 * * *") // Executar todos os dias às 8h da manhã
    public void checkBirthday() {
        LocalDate dataAtual = LocalDate.now();
        List<Membro> birthdayMembers = membroRepository.findBydateOfBirth(dataAtual);

        // Lógica para enviar mensagens para os usuários com aniversário hoje
        for (Membro member : birthdayMembers) {
            // Envie a mensagem para o usuário aqui
            System.out.println("Enviando mensagem para " + member.getName() + " pelo aniversário.");
        }
    }

}
