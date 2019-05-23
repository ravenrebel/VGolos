import { Component, OnInit } from '@angular/core';
import { CustomeAuthService } from 'src/app/service/custome-auth.service';
import { Router, ActivatedRoute } from '@angular/router';
import { TokenStorageService } from 'src/app/service/token-storage.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  signedIn: boolean = false;

  constructor(
    private authService: CustomeAuthService,
    private router: Router,
    private route: ActivatedRoute,
    private tokenStorage: TokenStorageService
  ) { }

  ngOnInit() {
    this.route.params.forEach(params => {
      this.signedIn = this.authService.checkLoggedUser();
      this.authService.signedIn.subscribe(signedIn => this.signedIn = signedIn);
      
      this.tokenStorage.signedIn.subscribe(signedIn => this.signedIn = signedIn);
  
    });
    this.authService.getCurrentUser().subscribe(user => {
      this.isAdmin = user.role == "ADMIN";
    });
  }
  isAdmin: boolean = false;
  logout(): void {
    this.authService.logout();
    this.signedIn = false;
    this.router.navigate(['signin']);
  }

  signIn(): void {
    this.router.navigate(['signin']);
  }
}
