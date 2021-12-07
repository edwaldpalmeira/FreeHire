import { EventEmitter, Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Cliente } from '../model/cliente';

@Injectable({
  providedIn: 'root'
})

export class AuthService {

  private clienteAutenticado: boolean = false;

  mostrarMenuEmitter = new EventEmitter<boolean>();

  constructor(private router: Router) { }

  fazerLogin(cliente: Cliente){
    if(cliente.login == cliente.login && 
      cliente.senha == cliente.senha){
        this.clienteAutenticado = true;

        this.mostrarMenuEmitter.emit(true);

        this.router.navigate(['/'])
      
    } else {
      this.clienteAutenticado = false;

      this.mostrarMenuEmitter.emit(false);
    }
  }
}
