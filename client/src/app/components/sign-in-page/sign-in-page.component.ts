import { Component, OnInit } from '@angular/core';
import { LoginCred } from 'src/app/model/login-cred';
import { CustomeAuthService } from 'src/app/service/custome-auth.service';
import { SignInForm } from 'src/app/model/authentication/signin-form.model';
import { TokenStorageService } from 'src/app/service/token-storage.service';
import { Router } from '@angular/router';
import { Location } from '@angular/common';


@Component({
  selector: 'app-sign-in-page',
  templateUrl: './sign-in-page.component.html',
  styleUrls: ['./sign-in-page.component.css']
})
export class SignInPageComponent implements OnInit {

  creds: SignInForm = new SignInForm();

  constructor(
    private authService: CustomeAuthService,
    private tokenStorage: TokenStorageService,
    private router: Router,
    private location:Location
  ) { }

  ngOnInit() {
    if (this.authService.checkLoggedUser()) {
      this.router.navigate(['']);
    }
  }

  goBack(): void{
    this.location.back();
  }
  onSubmit(): void {
    this.authService.attemptAuth(this.creds).subscribe(
      data => {
        this.tokenStorage.saveToken(data);
        this.authService.getCurrentUser().subscribe(
          user => this.tokenStorage.saveAuthorities(user.role));
        console.log(data);
        console.log("success");
        this.router.navigate(['']);
      },
      error => {
        console.log(error);
      }
    );
  }
}
