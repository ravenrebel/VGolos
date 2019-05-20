import { Component, OnInit } from '@angular/core';
import { SignUpForm } from 'src/app/model/authentication/signup-form.model';
import { CustomeAuthService } from 'src/app/service/custome-auth.service';
import { TokenStorageService } from 'src/app/service/token-storage.service';
import { Router } from '@angular/router';
import { Location } from '@angular/common';

@Component({
  selector: 'app-sign-up-page',
  templateUrl: './sign-up-page.component.html',
  styleUrls: ['./sign-up-page.component.css']
})
export class SignUpPageComponent implements OnInit {

  creds: SignUpForm = new SignUpForm();

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
    this.authService.signUp(this.creds).subscribe(
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
