import { Component, OnInit } from '@angular/core';
import { LoginCred } from 'src/app/model/login-cred';

@Component({
  selector: 'app-sign-in-page',
  templateUrl: './sign-in-page.component.html',
  styleUrls: ['./sign-in-page.component.css']
})
export class SignInPageComponent implements OnInit {

  creds: LoginCred = new LoginCred();

  constructor() { }

  ngOnInit() {
  }

}
