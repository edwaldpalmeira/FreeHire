import { Component, OnInit } from '@angular/core';
import { Proposta } from 'src/app/model/proposta';
import { PropostaService } from 'src/app/services/proposta.service';

@Component({
  selector: 'app-proposta',
  templateUrl: './proposta.component.html',
  styleUrls: ['./proposta.component.css']
})
export class PropostaComponent implements OnInit {

  propostaInserir?: Proposta = undefined;

  constructor(private propostaService: PropostaService) { }

  ngOnInit(): void {
  }

  salvar(): void{
    if(this.propostaInserir == undefined){
      return;
    }
    this.propostaService.inserirProposta(this.propostaInserir).subscribe(() =>{
      const resposta = confirm(`Proposta Criada`);
      this.cancelar();
    })
  }
  cadastrarProposta(){
    this.propostaInserir = new Proposta;
  }
  cancelar(){
    this.propostaInserir = undefined;
  }

}
