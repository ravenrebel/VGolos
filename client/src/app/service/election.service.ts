import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Election } from '../model/election';
import { Observable } from 'rxjs';
import { Empty } from '../model/empty';
import { ElectionDTO } from '../model/election-dto';

@Injectable({
  providedIn: 'root'
})
export class ElectionService {
  constructor(private http: HttpClient) { }
  baseUrl: string = 'http://localhost:8080/election/';

  findAll(): Observable<ElectionDTO[]> {
    return this.http.get<ElectionDTO[]>(this.baseUrl);
  }

  create(election:Election):Observable<ElectionDTO> {
    return this.http.post<ElectionDTO>(this.baseUrl + "create", election);
  }

  delete(id: number): Observable<Empty> {
    return this.http.delete<Empty>(this.baseUrl + "delete/" + id);
  }

  findbyid(id:number): Observable<ElectionDTO>{
    return this.http.get<ElectionDTO>(this.baseUrl + "id/" + id);
  }

  search(name:string): Observable<ElectionDTO[]>{
    return this.http.get<ElectionDTO[]>(this.baseUrl +"search/" + name);
  }

  update(election:Election): Observable<ElectionDTO>{
    return this.http.put<ElectionDTO>(this.baseUrl + "update", election);
  }

  isFinished(id:number): Observable<Boolean>{
    return this.http.get<Boolean>(this.baseUrl + "isFinished/" + id);
  }

  isStarted(id:number): Observable<Boolean>{
    return this.http.get<Boolean>(this.baseUrl + "isFinished" + id);
    }
}