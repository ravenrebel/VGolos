import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Vote } from '../model/vote';
import { Empty } from '../model/empty';
import { VoteDTO } from '../model/vote-dto';


@Injectable({
  providedIn: 'root'
})
export class VoteService {
  constructor(private http: HttpClient) { }
  baseUrl: string = 'http://localhost:8080/vote/';

  findAll(): Observable<VoteDTO[]> {
    return this.http.get<VoteDTO[]>(this.baseUrl);
  }

  create(vote:Vote):Observable<VoteDTO> {
    return this.http.post<VoteDTO>(this.baseUrl+ "create", vote);
  }

  update(vote:Vote): Observable<VoteDTO>{
    return this.http.put<VoteDTO>(this.baseUrl + "update",vote);
  }

  delete(id: number): Observable<Empty> {
    return this.http.delete<Empty>(this.baseUrl + "delete/" + id);
  }
<<<<<<< HEAD
  findbylogin(id:number): Observable<Vote>{
    return this.http.get<Vote>(this.baseUrl+ "id/"+id);
      }
      isExisting(electionId:number,citizenId:number): Observable<Boolean>{
        return this.http.get<Boolean>(this.baseUrl+ "isExisting/"+electionId+citizenId);
          }
=======

  findbylogin(id:number): Observable<VoteDTO>{
    return this.http.get<VoteDTO>(this.baseUrl + "id/" + id);
  }

  isExisting(electionId:number, citizenId:number): Observable<Boolean>{
    return this.http.get<Boolean>(this.baseUrl + "isExisting" + electionId + citizenId);
  }
>>>>>>> 11a286280680f3ed8c98fe75c58c110bd00ce5cc
}
