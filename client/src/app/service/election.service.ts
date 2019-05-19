import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Election } from '../model/election';
import { Observable } from 'rxjs';
import { Empty } from '../model/empty';

@Injectable({
  providedIn: 'root'
})
export class ElectionService {
  constructor(private http: HttpClient) { }
  baseUrl: string = 'http://localhost:8080/election/';
  findAll(): Observable<Election[]> {
    return this.http.get<Election[]>(this.baseUrl);
  }
  create(election:Election):Observable<Election> {
    return this.http.post<Election>(this.baseUrl+ "create", election);
  }
  delete(id: number): Observable<Empty> {
    return this.http.delete<Empty>(this.baseUrl + "delete/" + id);
  }
  findbyid(id:number): Observable<Election>{
    return this.http.get<Election>(this.baseUrl+ "id/"+id);
  }
  search(name:string): Observable<Election[]>{
    return this.http.get<Election[]>(this.baseUrl+"search/"+name);
  }
  update(election:Election): Observable<Election>{
    return this.http.put<Election>(this.baseUrl + "update",election);
  }
  isFinished(id:number): Observable<Boolean>{
    return this.http.get<Boolean>(this.baseUrl + "isFinished"+id);
  }

}
