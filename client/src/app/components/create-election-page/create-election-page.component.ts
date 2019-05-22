import { Component, OnInit } from '@angular/core';
// import { TokenStorageService } from 'src/app/service/token-storage.service';
import { Router } from '@angular/router';
import { Location } from '@angular/common';
// import { Election } from '@angular/common';

@Component({
  selector: 'app-create-election-page',
  templateUrl: './create-election-page.component.html',
  styleUrls: ['./create-election-page.component.css']
})
export class CreateElectionPageComponent implements OnInit {

  // creds: Election = new Election();

  constructor(
    private router: Router,
    private location:Location,    
    // private tokenStorage: TokenStorageService,


  ) { }

  ngOnInit() {
  }

}
