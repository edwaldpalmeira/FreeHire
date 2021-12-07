import { Component, Input, OnInit } from '@angular/core';
import { Servico } from 'src/app/model/servico';
import { ServicosService } from 'src/app/services/servicos.service';

@Component({
  selector: 'app-servicos-listar',
  templateUrl: './servicos-listar.component.html',
  styleUrls: ['./servicos-listar.component.css']
})

export class ServicosListarComponent implements OnInit {

  servicos = new Array<Servico>();
  servicosEdicao?: Servico = undefined;
  estaEditando = false;
  columns = ['nomeservico', 'descricaoservico', 'valorservico', 'valoravaliacao', 'observacaoservico', 'nomecliente', 'actions']

  constructor(private servicosService: ServicosService) { }
  /**função padrão que é executada toda vez que o componente aparece */
  ngOnInit(): void {
    this.listarServicos();
  }

  listarServicos(): void{
    this.servicosService.listarServicos().subscribe(servicos => {
      this.servicos = servicos;
  
    });
  }
    salvar(): void {
      if (this.servicosEdicao == undefined){
        return;
      }
    else{
        this.servicosService.atualizarServicos(this.servicosEdicao).subscribe(() => {
          this.listarServicos();
          this.cancelar();
        });
    }
  }
    cancelar() {
      this.servicosEdicao = undefined;
      this.estaEditando = false;
    }

    selecionarServicos(servicos: Servico){
      this.servicosEdicao = servicos;
      this.estaEditando = true;
    }

    excluir(servicos: Servico){
      const resposta = confirm(`Confirma a Exclusão de ${servicos.nomeServico}`);
      if(resposta && servicos && servicos.idServico){
        this.servicosService.excluir(servicos.idServico).subscribe(() => {
          this.listarServicos();
        });
      }
    }
}

