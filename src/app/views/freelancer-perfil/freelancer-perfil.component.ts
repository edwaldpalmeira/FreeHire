import { Component, OnInit } from '@angular/core';
import { Freelancer } from 'src/app/model/freelancer';
import { FreelancerService } from 'src/app/services/freelancer.service';

@Component({
  selector: 'app-freeçamcer',
  templateUrl: './freelancer-Perfil.component.html',
  styleUrls: ['./freelancer-Perfil.component.css']
})
export class FreelancerPerfilComponent implements OnInit {
  
  /** Criando array em angular*/
  freelancer = new Array<Freelancer>();
  freelancerEdicao?: Freelancer = undefined;
  estaEditando = false;
  columns = ['login','senha', 'nome', 'cpf', 'datadenascimento', 'endereco', 'numero', 'bairro', 'cidade', 'uf', 'cep', 'telefone', 'email', 'actions'];

  constructor(private freelancerService: FreelancerService) { }

  /**função padrão que é executada toda vez que o componente aparece */
  ngOnInit(): void {
    this.listarFreelancer();
  }

  listarFreelancer(): void{
    this.freelancerService.listarFreelancer().subscribe(freelancer => {
      /** local para atualizar a tela, para a interface mostrar para o usuario
       */
      this.freelancer = freelancer;
    });
  }
    salvar(): void {
      if (this.freelancerEdicao == undefined){
        return;
      }
    else{
        this.freelancerService.atualizarFreelancer(this.freelancerEdicao).subscribe(() => {
          this.listarFreelancer();
          this.cancelar();
        });
    }
  }
    cancelar() {
      this.freelancerEdicao = undefined;
      this.estaEditando = false;
    }

    selecionarFreelancer(freelancer: Freelancer){
      this.freelancerEdicao = freelancer;
      this.estaEditando = true;
    }

    excluir(freelancer: Freelancer){
      const resposta = confirm(`Confirma a Exclusão de ${freelancer.nome}`);
      if(resposta && freelancer && freelancer.idFreelancer){
        this.freelancerService.excluir(freelancer.idFreelancer).subscribe(() => {
          this.listarFreelancer();
        });
      }
    }
}

