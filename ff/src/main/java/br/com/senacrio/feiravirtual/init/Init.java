package br.com.senacrio.feiravirtual.init;

import br.com.senacrio.feiravirtual.domain.Empresa;
import br.com.senacrio.feiravirtual.domain.Responsavel;
import br.com.senacrio.feiravirtual.domain.Stand;
import br.com.senacrio.feiravirtual.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class Init implements ApplicationListener<ContextRefreshedEvent> {

    Logger logger = LoggerFactory.getLogger(Init.class);

    private final EmpresaRepository empresaRepository;
    private final StandRepository standRepository;
    private final ResponsavelRepository responsavelRepository;

    public Init(EmpresaRepository empresaRepository,
                StandRepository standRepository,
                ResponsavelRepository responsavelRepository) {
        this.empresaRepository = empresaRepository;
        this.standRepository = standRepository;
        this.responsavelRepository = responsavelRepository;
    }

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    RoleRepository roleRepository;
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        logger.info("Starting saving mock values on database");
        logger.info("Finishing saving mock values on database");
    }

    public void initStandAndResponsavel() {
        Empresa empresa = new Empresa();
        empresa.setEmpresaNome("Facebook");
        empresaRepository.save(empresa);

        Stand stand = new Stand();
        stand.setEmpresa(empresa);
        stand.setStandNome("Stand do Facebook");
        stand.setStandLinkApresentacao("https://image.slidesharecdn.com/shannonandcorinnefbpresentation3-161201151406/95/facebook-presentation-groups-and-more-1-638.jpg?cb=1480605297");
        stand.setStandLinkChat("https://web.facebook.com/");
        stand.setStandLinkLogomarca("https://cdn.clipart.email/462b001acf616cec3b1d12e87f1475d0_how-can-facebook-better-design-its-political-ads-for-2020_1536-768.png");
        stand.setStandStatus(true);
        standRepository.save(stand);

        Responsavel responsavel = new Responsavel();
        responsavel.setResponsavelNomeCompleto("João");
        responsavel.setEmpresa(empresa);
        responsavel.setResponsavelUsuario("joao2020");
        responsavel.setResponsavelSenha("senha123");
        responsavel.setResponsavelTelefone("21 32432345");
        responsavel.setResponsavelEmail("joao@facebook.com");
        responsavel.setResponsavelStatus(0);
        responsavelRepository.save(responsavel);
    }

}
