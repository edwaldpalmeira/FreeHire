import { Component, OnInit } from '@angular/core';
import { Freelancer } from 'src/app/model/freelancer';
import { FreelancerService } from 'src/app/services/freelancer.service';

@Component({
  selector: 'app-freelancer-cadastro',
  templateUrl: './freelancer-cadastro.component.html',
  styleUrls: ['./freelancer-cadastro.component.css']
})
export class FreelancerCadastroComponent implements OnInit {

  freelancerInserir?: Freelancer = undefined;

  constructor(private freelancerService: FreelancerService){ }

  ngOnInit(): void {
  }

  salvar(): void {
    if(this.freelancerInserir == undefined){
      return;
    }

    this.freelancerService.inserirFreelancer(this.freelancerInserir).subscribe(() =>{
      const resposta = confirm(`Freelancer Cadastrado`);
      this.cancelar();
    });
  }

  cadastrarFreelancer(){
    this.freelancerInserir = new Freelancer;
  }

  cancelar() {
    this.freelancerInserir = undefined;
  }
}
