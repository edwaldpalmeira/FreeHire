import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Proposta } from '../model/proposta';

@Injectable({
  providedIn: 'root'
})
export class PropostaService {

  constructor(private http: HttpClient) { }

  listarProposta(): Observable<Proposta[]> {
    return this.http.get<Proposta[]>('http://localhost:8080/freehire/webapi/proposta')
  }

  inserirProposta(proposta: Proposta): Observable<void>{
    return this.http.post<void>('http://localhost:8080/freehire/webapi/proposta', proposta)
  }

  atualizarProposta(proposta: Proposta): Observable<void>{
    return this.http.put<void>('http://localhost:8080/freehire/webapi/proposta', proposta)
  }

  excluir(idProposta: number): Observable<void>{
    let paramentro = new HttpParams();
    paramentro = paramentro.append('id', idProposta);
    return this.http.delete<void>('http://localhost:8080/freehire/webapi/proposta', {params: paramentro});
  }
}