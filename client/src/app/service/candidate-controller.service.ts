import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Candidate } from '../model/candidate';
import { Empty } from '../model/empty';

@Injectable({
  providedIn: 'root'
})
export class CandidateControllerService {

  constructor(private http: HttpClient) { }
  
  baseUrl: string = 'http://localhost:8080/candidate/';
  findAll(): Observable<Account[]> {
    return this.http.get<Account[]>(this.baseUrl);
  }

  create(candidate:Candidate):Observable<Candidate> {
    return this.http.post<Candidate>(this.baseUrl+ "create", candidate);
  }
  update(candidate:Candidate): Observable<Candidate>{
    return this.http.put<Candidate>(this.baseUrl + "update",candidate);
  }
  delete(id: number): Observable<Empty> {
    return this.http.delete<Empty>(this.baseUrl + "delete/" + id);
  }

  findbyid(id:number): Observable<Candidate>{
return this.http.get<Candidate>(this.baseUrl+ "id/"+id);
  }
}
