import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Citizen } from '../model/citizen';
import { Empty } from '../model/empty';



@Injectable({
  providedIn: 'root'
})
export class CitizenService {
  constructor(private http: HttpClient) { }
  baseUrl: string = 'http://localhost:8080/citizen/';

  findAll(): Observable<Citizen[]> {
    return this.http.get<Citizen[]>(this.baseUrl);
  }
  findByLogin(login:string):Observable<Citizen>{
    return this.http.get<Citizen>(this.baseUrl+"login/"+login);
  }
  create(citizen:Citizen):Observable<Citizen> {
    return this.http.post<Citizen>(this.baseUrl+ "create", citizen);
  }
  update(citizen:Citizen): Observable<Citizen>{
    return this.http.put<Citizen>(this.baseUrl + "update",citizen);
  }
  delete(id: number): Observable<Empty> {
    return this.http.delete<Empty>(this.baseUrl + "delete/" + id);
  }
  findbyid(id:number): Observable<Citizen>{
    return this.http.get<Citizen>(this.baseUrl+ "id/"+id);
  }
  getAgeInDays(id:number): Observable<number>{
    return this.http.get<number>(this.baseUrl+"getAgeInDays/"+id);
  }
  getAge(id:number): Observable<number>{
    return this.http.get<number>(this.baseUrl+"getAge/"+id);
  }
  search(name:string): Observable<Citizen[]>{
    return this.http.get<Citizen[]>(this.baseUrl+"search/"+name);
  }
  
}