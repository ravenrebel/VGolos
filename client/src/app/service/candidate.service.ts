import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Candidate } from '../model/candidate';
import { Empty } from '../model/empty';
import { CandidateDTO } from '../model/candidate-dto';

@Injectable({
  providedIn: 'root'
})
export class CandidateControllerService {

  constructor(private http: HttpClient) { }
  
  baseUrl: string = 'http://localhost:8080/candidate/';

  findAll(): Observable<CandidateDTO[]> {
    return this.http.get<CandidateDTO[]>(this.baseUrl);
  }

  create(candidate:CandidateDTO):Observable<CandidateDTO> {
    return this.http.post<CandidateDTO>(this.baseUrl+ "create", candidate);
  }
  update(candidate:CandidateDTO): Observable<CandidateDTO>{
    return this.http.put<CandidateDTO>(this.baseUrl + "update", candidate);
  }
  delete(id: number): Observable<Empty> {
    return this.http.delete<Empty>(this.baseUrl + "delete/" + id);
  }

  findbyid(id:number): Observable<CandidateDTO>{
    return this.http.get<CandidateDTO>(this.baseUrl+ "id/" + id);
  }

  findByElectionId(ElectionId:number): Observable<CandidateDTO[]> {
    return this.http.get<CandidateDTO[]>(this.baseUrl + "findByElectionId/" + ElectionId);
  }
}
