import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Cliente } from 'src/app/model/cliente';
import { ClienteService } from 'src/app/services/cliente.service';

@Component({
  selector: 'app-cliente',
  templateUrl: './cliente.component.html',
  styleUrls: ['./cliente.component.css'],
})
export class ClienteComponent implements OnInit {
  
  /** Criando array em angular*/
  clientes = new Array<Cliente>();
  clienteEdicao?: Cliente = undefined;
  estaEditando = false;
  columns = ['login','senha', 'nome', 'cpf', 'datadenascimento', 'endereco', 'numero', 'bairro', 'cidade', 'uf', 'cep', 'telefone', 'email', 'actions'];

  constructor(private clienteService: ClienteService, private snackBar: MatSnackBar) { }

  /**função padrão que é executada toda vez que o componente aparece */
  ngOnInit(): void {
    this.listarClientes();
  }

  showSnackbar(msg: string): void{
    this.snackBar.open(msg, '', {duration: 3000});
  }

  listarClientes(): void{
    this.clienteService.listarClientes().subscribe(clientes => {
      /** local para atualizar a tela, para a interface mostrar para o usuario
       */
      this.clientes = clientes;
    });
  }
    salvar(): void {
      if (this.clienteEdicao == undefined){
        return;
      }
    else{
        this.clienteService.atualizarClientes(this.clienteEdicao).subscribe(() => {
          this.listarClientes();
          this.cancelar();
        });
    }
  }
    cancelar() {
      this.clienteEdicao = undefined;
      this.estaEditando = false;
    }

    selecionarCliente(cliente: Cliente){
      this.clienteEdicao = cliente;
      this.estaEditando = true;
    }

    excluir(cliente: Cliente){
      const resposta = confirm(`Confirma a Exclusão de ${cliente.nome}`);
      if(resposta && cliente && cliente.idCliente){
        this.clienteService.excluir(cliente.idCliente).subscribe(() => {
          this.listarClientes();
        });
      }
    }
}

