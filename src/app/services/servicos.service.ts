import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Servico } from '../model/servico';

@Injectable({
  providedIn: 'root'
})
export class ServicosService {

  constructor(private http: HttpClient) { }

  listarServicos(): Observable<Servico[]> {
    return this.http.get<Servico[]>('http://localhost:8080/freehire/webapi/servico')
  }

  inserirServicos(servico: Servico): Observable<void>{
    return this.http.post<void>('http://localhost:8080/freehire/webapi/servico', servico)
  }

  atualizarServicos(servico: Servico): Observable<void>{
    return this.http.put<void>('http://localhost:8080/freehire/webapi/servico', servico)
  }

  excluir(idServico: number): Observable<void>{
    let paramentro = new HttpParams();
    paramentro = paramentro.append('id', idServico);
    return this.http.delete<void>('http://localhost:8080/freehire/webapi/servico', {params: paramentro});
  }
}