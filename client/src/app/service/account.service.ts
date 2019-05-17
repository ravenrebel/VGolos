import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Empty } from '../model/empty';
import { Account } from '../model/account';

@Injectable({
  providedIn: 'root'
})
export class AccountService {

  constructor(private http: HttpClient) { }
  baseUrl: string = 'http://localhost:8080/accounts/';

  findAll(): Observable<Account[]> {
    return this.http.get<Account[]>(this.baseUrl);
  }

  findByLogin(login: string): Observable<Account> {
    return this.http.get<Account>(this.baseUrl + "login/" + login);
  }

  create(account: Account): Observable<Account> {
    return this.http.post<Account>(this.baseUrl + "create", account);
  }

  delete(id: number): Observable<Empty> {
    return this.http.delete<Empty>(this.baseUrl + "delete/" + id);
  }

  update(account:Account): Observable<Account>{
    return this.http.put<Account>(this.baseUrl + "update",account);
  }
}
