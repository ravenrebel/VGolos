import { Injectable, Output, EventEmitter } from '@angular/core';

const TOKEN_KEY = 'AuthToken';
const AUTHORITIES_KEY = 'AuthAuthorities';

@Injectable({
  providedIn: 'root'
})
export class TokenStorageService {

  @Output() signedIn: EventEmitter<any> = new EventEmitter();

  constructor() {
  }

  signOut() {
    window.localStorage.clear();
    this.signedIn.emit(false);
  }

  public saveToken(token: string) {
    window.localStorage.removeItem(TOKEN_KEY);
    window.localStorage.setItem(TOKEN_KEY, token);
    this.signedIn.emit(true);
  }

  public getToken(): string {
    return localStorage.getItem(TOKEN_KEY);
  }

  public saveAuthorities(role : string) {
    window.localStorage.removeItem(AUTHORITIES_KEY);
    window.localStorage.setItem(AUTHORITIES_KEY, role);
  }

  public getAuthorities(): string {
    return localStorage.getItem(AUTHORITIES_KEY);
  }
}
