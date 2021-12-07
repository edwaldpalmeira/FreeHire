import { Component, OnInit } from '@angular/core';
import { Proposta } from 'src/app/model/proposta';
import { PropostaService } from 'src/app/services/proposta.service';

@Component({
  selector: 'app-proposta-listar',
  templateUrl: './proposta-listar.component.html',
  styleUrls: ['./proposta-listar.component.css']
})
export class PropostaListarComponent implements OnInit {

  proposta = new Array<Proposta>();
  propostaEdicao?: Proposta = undefined;
  estaEditando = false;
  columns = ['descricaoproposta', 'dataproposta', 'dataavaliacao', 'valorproposta', 'valoravaliacao', 'observacaoproposta', 'actions']

  constructor(private propostaService: PropostaService) { }
  /**função padrão que é executada toda vez que o componente aparece */
  ngOnInit(): void {
    this.listarProposta();
  }

  listarProposta(): void{
    this.propostaService.listarProposta().subscribe(proposta => {
      this.proposta = proposta;
  
    });
  }
    salvar(): void {
      if (this.propostaEdicao == undefined){
        return;
      }
    else{
        this.propostaService.atualizarProposta(this.propostaEdicao).subscribe(() => {
          this.listarProposta();
          this.cancelar();
        });
    }
  }
    cancelar() {
      this.propostaEdicao = undefined;
      this.estaEditando = false;
    }

    selecionarProposta(proposta: Proposta){
      this.propostaEdicao = proposta;
      this.estaEditando = true;
    }

    excluir(proposta: Proposta){
      const resposta = confirm(`Confirma a Exclusão de ${proposta.idProposta}`);
      if(resposta && proposta && proposta.idProposta){
        this.propostaService.excluir(proposta.idProposta).subscribe(() => {
          this.listarProposta();
        });
      }
    }
}

