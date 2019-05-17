import { Component, OnInit } from '@angular/core';
import { SignupCitizenForm } from 'src/app/model/authentication/signup-citizen-form';
import { CustomeAuthService } from 'src/app/service/custome-auth.service';
import { TokenStorageService } from 'src/app/service/token-storage.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-sign-up-citizen-page',
  templateUrl: './sign-up-citizen-page.component.html',
  styleUrls: ['./sign-up-citizen-page.component.css']
})
export class SignUpCitizenPageComponent implements OnInit {

  creds: SignupCitizenForm = new SignupCitizenForm();

  constructor(
    private authService: CustomeAuthService,
    private tokenStorage: TokenStorageService,
    private router: Router
  ) { }

  ngOnInit() {
    if (this.authService.checkLoggedUser()) {
      this.router.navigate(['']);
    }
  }

  onSubmit(): void {
    this.authService.signUpCitizen(this.creds).subscribe(
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
