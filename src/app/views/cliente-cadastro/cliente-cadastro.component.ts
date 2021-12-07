import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Cliente } from 'src/app/model/cliente';
import { ClienteService } from 'src/app/services/cliente.service';

@Component({
  selector: 'app-cliente-cadastro',
  templateUrl: './cliente-cadastro.component.html',
  styleUrls: ['./cliente-cadastro.component.css']
})
export class ClienteCadastroComponent implements OnInit {

  clienteInserir?: Cliente = undefined;

  constructor(private clienteService: ClienteService){ }

  ngOnInit(): void {
  }

  salvar(): void {
    if(this.clienteInserir == undefined){
      return;
    }

    this.clienteService.inserirClientes(this.clienteInserir).subscribe(() =>{
      const resposta = confirm(`Cliente Cadastrado`);
      this.cancelar();
    })
  }

  cadastrarCliente(){
    this.clienteInserir = new Cliente;
  }

  cancelar() {
    this.clienteInserir = undefined;
  }
}
