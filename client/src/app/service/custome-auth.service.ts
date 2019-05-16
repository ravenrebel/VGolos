import { Injectable, Output, EventEmitter } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { TokenStorageService } from './token-storage.service';
import { SignInForm } from '../model/authentication/signin-form.model';
import { Observable } from 'rxjs';
import { SignUpForm } from '../model/authentication/signup-form.model';
import {
  SIGNIN_URL, SIGNUP_URL, CURRENT_USER_URL, ACCESS_TOKEN,
  LOGOUT_URL, FORGOT_PASSWORD_URL, RESET_PASSWORD_URL
} from '../constants/index.js';
import { Account } from '../model/account';

@Injectable({
  providedIn: 'root'
})
export class CustomeAuthService {

  @Output() signedIn: EventEmitter<any> = new EventEmitter();

  constructor(private http: HttpClient, private tokenStorage: TokenStorageService) {
  }

  attemptAuth(credentials: SignInForm): Observable<any> {
    console.log(credentials);
    return this.http.post(SIGNIN_URL, credentials, { responseType: 'text' }).pipe(data => {
      this.signedIn.emit(this.checkLoggedUser());
      return data;
    });
  }



  signUp(info: SignUpForm): Observable<any> {
    return this.http.post(SIGNUP_URL, info, { responseType: 'text' });
  }

  getCurrentUser(): Observable<Account> {
    return this.http.get<Account>(CURRENT_USER_URL);
  }

  checkLoggedUser(): boolean {
    if (this.tokenStorage.getToken() == null) {
      return false;
    } else {
      return true;
    }
  }

  logout(): boolean {
    this.tokenStorage.signOut();
    this.http.get(LOGOUT_URL);
    if (!this.checkLoggedUser) {
      console.log("logout successed");
      return true;
    } else {
      console.log("logout failed");
      return false;
    }
  }
}
