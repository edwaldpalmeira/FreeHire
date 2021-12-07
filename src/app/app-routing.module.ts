import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ClienteCadastroComponent } from './views/cliente-cadastro/cliente-cadastro.component';
import { ClienteLoginComponent } from './views/cliente-login/cliente-login.component';
import { ClienteComponent } from './views/cliente/cliente.component';
import { FreelancerCadastroComponent } from './views/freelancer-cadastro/freelancer-cadastro.component';
import { FreelancerPerfilComponent } from './views/freelancer-perfil/freelancer-perfil.component';
import { HomeComponent } from './views/home/home.component';
import { InicioComponent } from './views/inicio/inicio.component';
import { PropostaListarComponent } from './views/proposta-listar/proposta-listar.component';
import { PropostaComponent } from './views/proposta/proposta.component';
import { ServicosListarComponent } from './views/servicos-listar/servicos-listar.component';
import { ServicosComponent } from './views/servicos/servicos.component';
import { SobreComponent } from './views/sobre/sobre.component';

const routes: Routes = [
  {
    path: 'cliente',
    component: ClienteComponent
  },
  {
    path: 'sobre',
    component: SobreComponent
  },
  {
    path: 'cliente-cadastro',
    component: ClienteCadastroComponent
  },
  {
    path: 'freelancer-perfil',
    component: FreelancerPerfilComponent
  },
  {
    path: 'freelancer-cadastro',
    component: FreelancerCadastroComponent
  },
  {
    path: 'servicos',
    component: ServicosComponent
  },
  {
    path: 'servicos-listar',
    component: ServicosListarComponent
  },
  {
    path: 'proposta',
    component: PropostaComponent
  },
  {
    path: 'proposta-listar',
    component: PropostaListarComponent
  },
  {
    path: 'cliente-login',
    component: ClienteLoginComponent
  },
  {
    path: 'home',
    component: HomeComponent
  },
  {
    path: 'inicio',
    component: InicioComponent
  } 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
