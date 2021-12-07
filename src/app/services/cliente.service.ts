import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Cliente } from '../model/cliente';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  constructor(private http: HttpClient) { }

  listarClientes(): Observable<Cliente[]> {
    return this.http.get<Cliente[]>('http://localhost:8080/freehire/webapi/cliente')
  }

  inserirClientes(cliente: Cliente): Observable<void>{
    return this.http.post<void>('http://localhost:8080/freehire/webapi/cliente', cliente)
  }

  atualizarClientes(cliente: Cliente): Observable<void>{
    return this.http.put<void>('http://localhost:8080/freehire/webapi/cliente', cliente)
  }

  excluir(idCliente: number): Observable<void>{
    let paramentro = new HttpParams();
    paramentro = paramentro.append('id', idCliente);
    return this.http.delete<void>('http://localhost:8080/freehire/webapi/cliente', {params: paramentro});
  }

}
