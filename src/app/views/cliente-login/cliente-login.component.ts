import { Component, OnInit } from '@angular/core';
import { Cliente } from 'src/app/model/cliente';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-cliente-login',
  templateUrl: './cliente-login.component.html',
  styleUrls: ['./cliente-login.component.css']
})
export class ClienteLoginComponent implements OnInit {

  cliente: Cliente = new Cliente(); 

  constructor(private authService: AuthService) { }

  ngOnInit(): void {
  }

  fazerLogin(){
    this.authService.fazerLogin(this.cliente);
  }

}
