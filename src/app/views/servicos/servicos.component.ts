import { Component, Injectable, Input, OnInit } from '@angular/core';
import { Servico } from 'src/app/model/servico';
import { ServicosService } from 'src/app/services/servicos.service';

@Component({
  selector: 'app-servicos',
  templateUrl: './servicos.component.html',
  styleUrls: ['./servicos.component.css']
})

export class ServicosComponent implements OnInit {

  servicosInserir?: Servico = undefined;
  
  constructor(private servicosService: ServicosService) { }

  ngOnInit(): void {
  }

  salvar(): void{
    if(this.servicosInserir == undefined){
      return;
    }
    this.servicosService.inserirServicos(this.servicosInserir).subscribe(() =>{
      const resposta = confirm(`Serviço Criado`);
      this.cancelar();
    });
  }
  cadastrarServicos(){
    this.servicosInserir = new Servico;
  }

  cancelar(){
    this.servicosInserir = undefined;
  }
}
