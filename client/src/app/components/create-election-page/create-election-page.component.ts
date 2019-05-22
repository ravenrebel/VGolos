import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Location } from '@angular/common';


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


  ) { }

  ngOnInit() {
  }

}
