import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { CustomeAuthService } from 'src/app/service/custome-auth.service';
import { TokenStorageService } from 'src/app/service/token-storage.service';
import { Citizen } from 'src/app/model/citizen';
import { CitizenService } from 'src/app/service/citizen.service';

@Component({
  selector: 'app-voters',
  templateUrl: './voters.component.html',
  styleUrls: ['./voters.component.css']
})
export class VotersComponent implements OnInit {

  citizens: Citizen[];
  signedIn: boolean = false;


  constructor(
    private router: Router,
    private authService: CustomeAuthService,
    private route: ActivatedRoute,
    private tokenStorage: TokenStorageService,
    private citizensService: CitizenService,
   ) 
   {

  }

  ngOnInit() {
    this.citizensService.findAll().subscribe(data => {
      this.citizens = data;
    });
    if (!this.authService.checkLoggedUser()) {
      this.router.navigate(['/signin']);
    }
  }

}

