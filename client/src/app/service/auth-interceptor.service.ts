import { Injectable } from '@angular/core';
import { TokenStorageService } from './token-storage.service';
import { HttpRequest, HttpHandler, HttpEvent, HTTP_INTERCEPTORS } from '@angular/common/http';
import { Observable } from 'rxjs';

const TOKEN_HEADER_KEY = 'Authorization';

@Injectable({
  providedIn: 'root'
})
export class AuthInterceptorService {

  constructor(private token: TokenStorageService) {
  }

  intercept(req: HttpRequest<any>, next: HttpHandler) : Observable<HttpEvent<any>> {
    const token = this.token.getToken();
    console.log(token);
    if (token != null) {
      if(!token.startsWith('Bearer')){
      req = req.clone({headers: req.headers.set(TOKEN_HEADER_KEY, 'Bearer ' + token)});
    } else {
      req = req.clone({headers: req.headers.set(TOKEN_HEADER_KEY, token)});
    }
  }
    req = req.clone({headers: req.headers.set('Access-Control-Allow-Origin',"http://localhost:8080/")});
    return next.handle(req);
  }

}

export const httpInterceptorProviders = [
  {provide: HTTP_INTERCEPTORS, useClass: AuthInterceptorService, multi: true}
];
