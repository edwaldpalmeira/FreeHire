import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Freelancer } from '../model/freelancer';

@Injectable({
  providedIn: 'root'
})
export class FreelancerService {

  constructor(private http: HttpClient) { }

  listarFreelancer(): Observable<Freelancer[]> {
    return this.http.get<Freelancer[]>('http://localhost:8080/freehire/webapi/freelancer')
  }

  inserirFreelancer(freelancer: Freelancer): Observable<void>{
    return this.http.post<void>('http://localhost:8080/freehire/webapi/freelancer', freelancer)
  }

  atualizarFreelancer(freelancer: Freelancer): Observable<void>{
    return this.http.put<void>('http://localhost:8080/freehire/webapi/freelancer', freelancer)
  }

  excluir(idFreelancer: number): Observable<void>{
    let paramentro = new HttpParams();
    paramentro = paramentro.append('id', idFreelancer);
    return this.http.delete<void>('http://localhost:8080/freehire/webapi/freelancer', {params: paramentro});
  }
}