import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SobreComponent } from './views/sobre/sobre.component';
import { ClienteComponent } from './views/cliente/cliente.component';
import { FormsModule } from '@angular/forms';
import { ClienteCadastroComponent } from './views/cliente-cadastro/cliente-cadastro.component';
import { FreelancerPerfilComponent } from './views/freelancer-perfil/freelancer-perfil.component';
import { FreelancerCadastroComponent } from './views/freelancer-cadastro/freelancer-cadastro.component';
import { ServicosComponent } from './views/servicos/servicos.component';
import { ServicosListarComponent } from './views/servicos-listar/servicos-listar.component';
import { PropostaListarComponent } from './views/proposta-listar/proposta-listar.component';
import { PropostaComponent } from './views/proposta/proposta.component';
import { ClienteLoginComponent } from './views/cliente-login/cliente-login.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatToolbarModule} from '@angular/material/toolbar';
import { LayoutModule } from '@angular/cdk/layout';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { MatListModule } from '@angular/material/list';
import { MatCardModule } from '@angular/material/card';
import { HomeComponent } from './views/home/home.component';
import { InicioComponent } from './views/inicio/inicio.component';
import { ClienteService } from './services/cliente.service';
import { MatTreeModule} from '@angular/material/tree';
import { MatInputModule} from '@angular/material/input';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { MatTableModule } from '@angular/material/table';
import { MatFormFieldModule } from '@angular/material/form-field';
@NgModule({
  declarations: [
    AppComponent,
    SobreComponent,
    ClienteComponent,
    ClienteCadastroComponent,
    FreelancerPerfilComponent,
    FreelancerCadastroComponent,
    ServicosComponent,
    ServicosListarComponent,
    PropostaListarComponent,
    PropostaComponent,
    ClienteLoginComponent,
    HomeComponent,
    InicioComponent,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    LayoutModule,
    MatSidenavModule,
    MatIconModule,
    MatButtonModule,
    MatListModule,
    MatCardModule,
    MatTreeModule,
    MatInputModule,
    MatSnackBarModule,
    MatTableModule,
    MatFormFieldModule
  ],
  providers: [ClienteService],
  bootstrap: [AppComponent]
})
export class AppModule { }
