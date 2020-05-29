package br.com.tt.petshop.api;

import br.com.tt.petshop.dto.UnidadeDto;
import br.com.tt.petshop.service.UnidadeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //@Controller + @ResponseBody
public class UnidadeRestController {

    private UnidadeService unidadeService;

    public UnidadeRestController(UnidadeService unidadeService) {
        this.unidadeService = unidadeService;
    }

    //@RequestMapping(method = RequestMethod.GET, value = "/unidades", produces = "application/json")
    @GetMapping(value = "/unidades", produces = "application/json")
    public List<UnidadeDto> lista(){
        return unidadeService.listarUnidades();
    }

}
