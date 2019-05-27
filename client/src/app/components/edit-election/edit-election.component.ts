import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-edit-election',
  templateUrl: './edit-election.component.html',
  styleUrls: ['./edit-election.component.css']
})
export class EditElectionComponent implements OnInit {

  constructor(
    private router: Router,
    private route: ActivatedRoute,
  ) 
  { }

  ngOnInit() {
  }

}
