package br.com.senacrio.feiravirtual.controllers;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.senacrio.feiravirtual.domain.Bairro;
import br.com.senacrio.feiravirtual.domain.Cidade;
import br.com.senacrio.feiravirtual.domain.CurriculoNivelInstrucao;
import br.com.senacrio.feiravirtual.domain.Estado;
import br.com.senacrio.feiravirtual.domain.FiltroCurriculo;
import br.com.senacrio.feiravirtual.service.BairroService;
import br.com.senacrio.feiravirtual.service.CidadeService;
import br.com.senacrio.feiravirtual.service.CurriculoDadoPessoalService;
import br.com.senacrio.feiravirtual.service.CurriculoNivelInstrucaoService;
import br.com.senacrio.feiravirtual.service.CurriculoService;
import br.com.senacrio.feiravirtual.service.EstadoService;
import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping("relatorio")
public class CurriculoRestController {

    @Autowired
    CurriculoService curriculoService;

    @Autowired
    CurriculoNivelInstrucaoService curriculoNivelInstrucaoService;

    @Autowired
    CurriculoDadoPessoalService curriculoDadoPessoalService;

    @Autowired
    EstadoService estadoService;

    @Autowired
    CidadeService cidadeService;

    @Autowired
    BairroService bairroService;


    @GetMapping("deficiencia")
    public List<Map<String, BigInteger>> deficiente(@RequestParam(name = "tipo", required = false) String deficiente) {
        return curriculoService.findDeficiente(deficiente);
    }

    @GetMapping("formacao")
    public List<Map<String, BigInteger>> formacao(@RequestParam(name = "nivel", required = false) String nivel){
        return curriculoService.findNivelInstrucao(nivel);
    }

    /*=====[Rodrigo Moreira - Inicio servico para tratar dados dos Relatórios com filtros]=====*/
    @RequestMapping(value = "/buscarDadosRelatorio", method = RequestMethod.POST)
    public ResponseEntity<List<Map<String, BigInteger>>> buscarDadosRelatorio(@ModelAttribute("filtro") FiltroCurriculo fitroCurriculo) throws ObjectNotFoundException {

        List<Map<String, BigInteger>> listaResultado = new ArrayList<Map<String, BigInteger>>();
        listaResultado = curriculoDadoPessoalService.listarQuantidadeCurriculosPorBairro(fitroCurriculo.getBairro());

        return new ResponseEntity<List<Map<String, BigInteger>>>(new ArrayList<Map<String, BigInteger>>(listaResultado), HttpStatus.OK);
    }


    @RequestMapping(value = "/buscarTodasEscolaridades", method = RequestMethod.GET)
    public ResponseEntity<List<CurriculoNivelInstrucao>> buscarTodasEscolaridades() throws ObjectNotFoundException {

        List<CurriculoNivelInstrucao> curriculoNivelInstrucaoLista = new ArrayList<>();
        curriculoNivelInstrucaoLista = curriculoNivelInstrucaoService.buscarTodasEscolaridades();

        return new ResponseEntity<List<CurriculoNivelInstrucao>>(new ArrayList<>(curriculoNivelInstrucaoLista), HttpStatus.OK);
    }

    @RequestMapping(value = "/buscarTodosEstados", method = RequestMethod.GET)
    public List<Estado> buscarTodosBairros() throws ObjectNotFoundException {

        return estadoService.searchAll();
    }

    @RequestMapping(value = "/buscarCidadesPorEstado", method = RequestMethod.GET)
    public List<Cidade> buscar(@RequestParam(name = "estado", required = false) Integer estado) throws ObjectNotFoundException {


        return cidadeService.buscarTodasCidadesPorEstado(estadoService.search(estado));
    }


    @RequestMapping(value = "/buscarBairrosPorCidade", method = RequestMethod.GET)
    public List<Bairro> buscarTodosBairros(@RequestParam(name = "cidade", required = false) Integer cidade) throws ObjectNotFoundException {


        return bairroService.buscaPorCidade(cidadeService.buscaPorID(cidade));
    }

//	@GetMapping("regiao")
//	public List<Map<String, BigInteger>> regiao(
//			@RequestParam(name = "bairro", required = false) String bairro,
//			@RequestParam(name = "cidade", required = false) String cidade,
//			@RequestParam(name = "estado", required = false) String estado){
//		return curriculoService.findRegiao(bairro, cidade, estado);
//	}



}