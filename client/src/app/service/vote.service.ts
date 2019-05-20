import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Vote } from '../model/vote';
import { Empty } from '../model/empty';


@Injectable({
  providedIn: 'root'
})
export class VoteService {
  constructor(private http: HttpClient) { }
  baseUrl: string = 'http://localhost:8080/vote/';

  findAll(): Observable<Vote[]> {
    return this.http.get<Vote[]>(this.baseUrl);
  }
  create(vote:Vote):Observable<Vote> {
    return this.http.post<Vote>(this.baseUrl+ "create", vote);
  }
  update(vote:Vote): Observable<Vote>{
    return this.http.put<Vote>(this.baseUrl + "update",vote);
  }
  delete(id: number): Observable<Empty> {
    return this.http.delete<Empty>(this.baseUrl + "delete/" + id);
  }
  findbylogin(id:number): Observable<Vote>{
    return this.http.get<Vote>(this.baseUrl+ "id/"+id);
      }
      isExisting(electionId:number,citizenId:number): Observable<Boolean>{
        return this.http.get<Boolean>(this.baseUrl+ "isExisting/"+electionId+citizenId);
          }
}
